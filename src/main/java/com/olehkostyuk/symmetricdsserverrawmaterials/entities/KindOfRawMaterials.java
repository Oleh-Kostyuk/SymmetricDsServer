package com.olehkostyuk.symmetricdsserverrawmaterials.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="kind_of_raw_materials")
public class KindOfRawMaterials {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String name;

    @OneToMany( mappedBy = "kindRwm", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public KindOfRawMaterials() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
