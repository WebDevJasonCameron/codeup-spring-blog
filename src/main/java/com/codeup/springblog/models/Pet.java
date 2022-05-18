package com.codeup.springblog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pet {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int age;
    private String type;
    private String name;
    @OneToOne
    private PetDetails petDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    @JsonBackReference
    private List<ChewToy> chewToys;

    // CON
    public Pet() {
    }

    // GET
    public long getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public PetDetails getPetDetails() {
        return petDetails;
    }
    public List<ChewToy> getChewToys() {
        return chewToys;
    }

    // SET
    public void setAge(int age) {
        this.age = age;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPetDetails(PetDetails petDetails) {
        this.petDetails = petDetails;
    }
    public void setChewToys(List<ChewToy> chewToys) {
        this.chewToys = chewToys;
    }

    // CHECK
    public String toString() {
        return "Pet{ " +
                "id=" + id +
                ", age=" + age +
                ", type='" + type + "\"" +
                ", name='" + name + "\"" +
                ", petDetails=" + petDetails +
                "}";

    }


}  //<--END
