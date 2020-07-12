package com.olehkostyuk.symmetricdsserverrawmaterials.configuration;

import org.jumpmind.db.sql.SqlScript;
import org.jumpmind.symmetric.AbstractSymmetricEngine;
import org.jumpmind.symmetric.common.ParameterConstants;
import org.jumpmind.symmetric.db.ISymmetricDialect;
import org.jumpmind.symmetric.web.ServerSymmetricEngine;
import org.jumpmind.symmetric.web.SymmetricEngineHolder;
import org.jumpmind.symmetric.web.SymmetricServlet;
import org.jumpmind.symmetric.web.WebConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;


import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;


    @Configuration
    @PropertySource("classpath:serverEngine.properties")
    public class SymDSModule implements ApplicationListener<ApplicationReadyEvent> {

        private  final String SQLRESOURCEFILE =
                "db/changelog/changes_to_sym_tables.sql";


        @Autowired
        ServletContext servletContext;

        @Autowired
        DataSource dataSource;

        @Autowired
        ApplicationContext applicationContext;

        public SymDSModule() throws IOException {
        }

        @Override
        final public void onApplicationEvent(ApplicationReadyEvent event) {
            SymmetricEngineHolder holder = new SymmetricEngineHolder();

            Properties properties = new Properties();

            File file = null;
            try {
                file = new ClassPathResource(
                        "serverEngine.properties").getFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ServerSymmetricEngine serverEngine = new ServerSymmetricEngine(file, applicationContext, holder);
            serverEngine.setDeploymentType("server");
            holder.getEngines().put(properties.getProperty(ParameterConstants.EXTERNAL_ID), serverEngine);
            holder.setAutoStart(false);
            servletContext.setAttribute(WebConstants.ATTR_ENGINE_HOLDER, holder);
            serverEngine.setup();
            try {
                runSql(serverEngine,SQLRESOURCEFILE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            serverEngine.start();
        }

        @Bean
        public ServletRegistrationBean<SymmetricServlet> symServlet() {
            ServletRegistrationBean<SymmetricServlet> bean = new ServletRegistrationBean<>(new SymmetricServlet(), "/sync");
            bean.setLoadOnStartup(1);
            return bean;
        }

        @Bean(name="dataSource")
        public DataSource getDataSource() {
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.driverClassName("org.h2.Driver");
            dataSourceBuilder.url("jdbc:h2:mem:RawMaterials");
            dataSourceBuilder.username("SA");
            dataSourceBuilder.password("");
            return dataSourceBuilder.build();
        }
        private static void runSql(AbstractSymmetricEngine engine, String fileName)
                throws IOException {
            ISymmetricDialect dialect = engine.getSymmetricDialect();
            File file = new ClassPathResource(fileName).getFile();
            if (file.exists() && file.isFile()) {
                SqlScript script = new SqlScript(file.toURL(), dialect.getPlatform().getSqlTemplate() );
                script.execute();
            }
            else {
                throw new FileNotFoundException("Could not find;" + fileName);
            }
        }
    }