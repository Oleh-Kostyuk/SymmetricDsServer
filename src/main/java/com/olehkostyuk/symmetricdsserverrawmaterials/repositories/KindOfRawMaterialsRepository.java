package com.olehkostyuk.symmetricdsserverrawmaterials.repositories;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.KindOfRawMaterials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "kindRWM", path = "kindRWM")
public interface KindOfRawMaterialsRepository  extends CrudRepository<KindOfRawMaterials, Long> {
    List<KindOfRawMaterials> findByName (@Param("name")String name);
}
