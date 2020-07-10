package com.olehkostyuk.symmetricdsserverrawmaterials.services;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.TypeOfRawMaterials;
import com.olehkostyuk.symmetricdsserverrawmaterials.repositories.TypeOfRawMaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypeOfRWMService implements ITypeOfRWMService {

   @Autowired
    TypeOfRawMaterialsRepository typeOfRawMaterialsRepository;

    @Override
    public List<TypeOfRawMaterials> findAll() {

        return (List<TypeOfRawMaterials>) typeOfRawMaterialsRepository.findAll();
    }

    @Override
    public List<TypeOfRawMaterials> getTypeOfRWM(String name) {
        return typeOfRawMaterialsRepository.findByName(name);
    }
}
