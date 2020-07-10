package com.olehkostyuk.symmetricdsserverrawmaterials.controllers;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.Order;
import com.olehkostyuk.symmetricdsserverrawmaterials.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrdersController {

    @Autowired
    private IOrderService orderService;



    public IOrderService getOrderService() {
        return orderService;
    }


    @GetMapping( name="/orders",produces="application/json")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping("orders/{id}")
    public Optional<Order> findById (@PathVariable Long id){
        return orderService.find(id);
    }



}
