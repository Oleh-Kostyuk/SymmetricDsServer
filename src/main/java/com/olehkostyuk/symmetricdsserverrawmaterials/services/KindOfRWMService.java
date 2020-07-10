package com.olehkostyuk.symmetricdsserverrawmaterials.services;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.KindOfRawMaterials;

import com.olehkostyuk.symmetricdsserverrawmaterials.repositories.KindOfRawMaterialsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KindOfRWMService implements IKindOfRWMService {

    @Autowired
    KindOfRawMaterialsRepository kindOfRawMaterialsRepository;

    @Override
    public List<KindOfRawMaterials> findAll() {
        return (List<KindOfRawMaterials>) kindOfRawMaterialsRepository.findAll();
    }

    @Override
    public List<KindOfRawMaterials> getKindOfRWM(String name) {
        return kindOfRawMaterialsRepository.findByName(name);
    }
}
