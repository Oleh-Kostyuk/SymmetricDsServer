package com.olehkostyuk.symmetricdsserverrawmaterials.services;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<Order> findAll();
    Optional<Order> find(Long id);
}
