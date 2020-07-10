package com.olehkostyuk.symmetricdsserverrawmaterials.services;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.Provider;
import com.olehkostyuk.symmetricdsserverrawmaterials.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProviderService implements IProviderService {
    @Autowired
    ProviderRepository providerRepository;

    @Override
    public List<Provider> find() {
        return (List<Provider>) providerRepository.findAll();
    }

    @Override
    public List<Provider> getProvider(String name) {
        return providerRepository.findByName(name);
    }
}
