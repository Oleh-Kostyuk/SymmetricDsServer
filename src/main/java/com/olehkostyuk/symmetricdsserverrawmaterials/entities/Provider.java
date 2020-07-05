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
    @OneToMany(mappedBy = "provider",cascade = CascadeType.ALL,
            orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Order> orders= new ArrayList<>();



}
