package com.olehkostyuk.symmetricdsserverrawmaterials.controllers;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.Provider;
import com.olehkostyuk.symmetricdsserverrawmaterials.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="rest/providers")
public class ProviderController {
    @Autowired
    ProviderService providerService;

    @GetMapping
    public List<Provider> getAll(@RequestParam(required = false) String name) {
        if (name == null) {
            return providerService.find();
        }

        return providerService.getProvider(name);
    }
}







