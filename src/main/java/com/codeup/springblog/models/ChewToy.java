package com.codeup.springblog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "chew_toys")
public class ChewToy {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String brand;
    private boolean isDestroyed;
    // who the chew toy belongs to!!!
    @ManyToOne
    @JoinColumn(name = "pet_id")
    @JsonBackReference
    private Pet pet;


    // CON
    public ChewToy() {
    }

    public ChewToy(String name, String brand, boolean isDestroyed, Pet pet) {
        this.name = name;
        this.brand = brand;
        this.isDestroyed = isDestroyed;
        this.pet = pet;
    }

    // GET
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBrand() {
        return brand;
    }
    public boolean isDestroyed() {
        return isDestroyed;
    }
    public Pet getPet() {
        return pet;
    }


    // SET
    public void setName(String name) {
        this.name = name;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }


}  //<--END
