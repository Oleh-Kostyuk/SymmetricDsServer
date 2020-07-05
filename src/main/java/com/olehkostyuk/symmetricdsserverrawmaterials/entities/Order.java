package com.olehkostyuk.symmetricdsserverrawmaterials.entities;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="provider_id")
    private Provider provider;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="kindRwm_id")
    private KindOfRawMaterials kindRwm;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="typeRwm_id")
    private KindOfRawMaterials typeRwm;

    private double quantity;

    private double price;

    public Order() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public KindOfRawMaterials getKindRwm() {
        return kindRwm;
    }

    public void setKindRwm(KindOfRawMaterials kindRwm) {
        this.kindRwm = kindRwm;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public KindOfRawMaterials getTypeRwm() {
        return typeRwm;
    }

    public void setTypeRwm(KindOfRawMaterials typeRwm) {
        this.typeRwm = typeRwm;
    }

    public void setPrice(double price) {
        this.price = price;

    }
}
