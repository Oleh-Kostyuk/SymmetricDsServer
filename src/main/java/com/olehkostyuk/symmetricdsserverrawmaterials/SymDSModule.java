package com.olehkostyuk.symmetricdsserverrawmaterials;

import org.jumpmind.symmetric.common.ParameterConstants;
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
import java.io.IOException;
import java.util.Properties;


    @Configuration
    @PropertySource("classpath:serverEngine.properties")
    public class SymDSModule implements ApplicationListener<ApplicationReadyEvent> {

        @Autowired
        ServletContext servletContext;

        @Autowired
        DataSource dataSource;

        @Autowired
        ApplicationContext applicationContext;

        @Override
        final public void onApplicationEvent(ApplicationReadyEvent event) {
            SymmetricEngineHolder holder = new SymmetricEngineHolder();

            Properties properties = new Properties();
//            properties.put(ParameterConstants.DATA_LOADER_IGNORE_MISSING_TABLES, "true");
//            properties.put(ParameterConstants.TRIGGER_CREATE_BEFORE_INITIAL_LOAD, "false");
//            properties.put(ParameterConstants.AUTO_RELOAD_ENABLED, "true");
//            properties.put(ParameterConstants.AUTO_REGISTER_ENABLED, "true");
//            properties.put(ParameterConstants.REGISTRATION_URL, "http://127.0.0.1:8080");
//            properties.put (ParameterConstants.NODE_GROUP_ID,"server");
//            properties.put(ParameterConstants.EXTERNAL_ID,"serverEngine");
            File file = null;
            try {
                file = new ClassPathResource(
                        "serverEngine.properties").getFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //ServerSymmetricEngine serverEngine = new ServerSymmetricEngine(dataSource, applicationContext, properties, false, holder);
            ServerSymmetricEngine serverEngine = new ServerSymmetricEngine(file, applicationContext, holder);
            serverEngine.setDeploymentType("server");
            holder.getEngines().put(properties.getProperty(ParameterConstants.EXTERNAL_ID), serverEngine);
            holder.setAutoStart(false);
            servletContext.setAttribute(WebConstants.ATTR_ENGINE_HOLDER, holder);

            serverEngine.setup();
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


}
