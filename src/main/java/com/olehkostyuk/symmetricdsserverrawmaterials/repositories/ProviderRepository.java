package com.olehkostyuk.symmetricdsserverrawmaterials.repositories;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "providers", path = "providers")
public interface ProviderRepository extends CrudRepository<Provider,Long> {
   List<Provider> findByName(@Param("name") String name);

}
