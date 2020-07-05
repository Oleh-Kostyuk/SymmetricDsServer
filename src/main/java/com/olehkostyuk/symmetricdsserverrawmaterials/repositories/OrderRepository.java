package com.olehkostyuk.symmetricdsserverrawmaterials.repositories;

import com.olehkostyuk.symmetricdsserverrawmaterials.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {



}
