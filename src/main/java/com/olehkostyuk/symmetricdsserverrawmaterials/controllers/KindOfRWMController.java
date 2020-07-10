package com.olehkostyuk.symmetricdsserverrawmaterials.controllers;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.KindOfRawMaterials;
import com.olehkostyuk.symmetricdsserverrawmaterials.entities.TypeOfRawMaterials;
import com.olehkostyuk.symmetricdsserverrawmaterials.services.IKindOfRWMService;
import com.olehkostyuk.symmetricdsserverrawmaterials.services.ITypeOfRWMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class KindOfRWMController {
    @Autowired
    IKindOfRWMService kindOfRWMService;

    @GetMapping(value="rest/kindRWM")
    public List<KindOfRawMaterials> getAll(@RequestParam(required = false) String name) {
        if (name == null) {
            return kindOfRWMService.findAll();
        }
        return kindOfRWMService.getKindOfRWM(name);
    }
}
