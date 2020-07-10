package com.olehkostyuk.symmetricdsserverrawmaterials.services;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.Order;
import com.olehkostyuk.symmetricdsserverrawmaterials.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
     return  (List<Order>)orderRepository.findAll();
    }

    @Override
    public Optional<Order> find(Long id) {
        return orderRepository.findById(id);
    }
}
