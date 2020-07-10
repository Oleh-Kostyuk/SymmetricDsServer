package com.olehkostyuk.symmetricdsserverrawmaterials.controllers;


import com.olehkostyuk.symmetricdsserverrawmaterials.entities.TypeOfRawMaterials;
import com.olehkostyuk.symmetricdsserverrawmaterials.services.ITypeOfRWMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeOfRWMController {
    @Autowired
    ITypeOfRWMService typeOfRWMService;

    @GetMapping(value="rest/typeRWM")
    public List<TypeOfRawMaterials> getAll(@RequestParam(required = false) String name) {
        if (name == null) {
            return typeOfRWMService.findAll();
        }
        return typeOfRWMService.getTypeOfRWM(name);
    }
}

