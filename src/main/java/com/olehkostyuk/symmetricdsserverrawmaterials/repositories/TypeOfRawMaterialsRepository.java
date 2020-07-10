package com.olehkostyuk.symmetricdsserverrawmaterials.repositories;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.TypeOfRawMaterials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(collectionResourceRel = "typeRWM", path = "typeRWM")
public interface TypeOfRawMaterialsRepository extends CrudRepository<TypeOfRawMaterials,Long> {
    List<TypeOfRawMaterials> findByName (@Param("name")String name);
}
