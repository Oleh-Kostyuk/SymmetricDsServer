package com.olehkostyuk.symmetricdsserverrawmaterials.services;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.Provider;
import java.util.List;

public interface IProviderService {
    List<Provider> find();
    List<Provider> getProvider(String name);
}
