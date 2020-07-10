package com.olehkostyuk.symmetricdsserverrawmaterials.services;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.KindOfRawMaterials;
import com.olehkostyuk.symmetricdsserverrawmaterials.entities.TypeOfRawMaterials;

import java.util.List;

public interface IKindOfRWMService {
    List<KindOfRawMaterials> findAll();
    List<KindOfRawMaterials> getKindOfRWM(String name);
}
