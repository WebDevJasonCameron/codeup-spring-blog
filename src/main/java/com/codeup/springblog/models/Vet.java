package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vets")                   // NOT the OWNER
public class Vet {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    @ManyToMany
    private List<Pet> vetPets;

    // CON
    public Vet() {
    }
    public Vet(long id, String name, String address, String phoneNumber, List<Pet> vetPets) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.vetPets = vetPets;
    }


    // GET
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public List<Pet> getVetPets() {
        return vetPets;
    }


    // SET
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setVetPets(List<Pet> vetPets) {
        this.vetPets = vetPets;
    }


}  //<--END
