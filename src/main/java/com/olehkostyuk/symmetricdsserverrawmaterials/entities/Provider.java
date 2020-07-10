package com.olehkostyuk.symmetricdsserverrawmaterials.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "providers")
public class Provider {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    private long km;
    @OneToMany(mappedBy = "provider",cascade = CascadeType.ALL,
            orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Order> orders= new ArrayList<>();

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

    public long getKm() {
        return km;
    }

    public void setKm(long km) {
        this.km = km;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
