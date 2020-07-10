package com.olehkostyuk.symmetricdsserverrawmaterials.services;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.TypeOfRawMaterials;

import java.util.List;

public interface ITypeOfRWMService {
    List<TypeOfRawMaterials> findAll();
    List<TypeOfRawMaterials> getTypeOfRWM(String name);
}
