package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "petDetails")
public class PetDetails {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String personalityDescription;
    private boolean isSterile;
    private int weightInOunces;

    // CON
    public PetDetails() {
    }

    // GET
    public long getId() {
        return id;
    }
    public String getPersonalityDescription() {
        return personalityDescription;
    }
    public boolean isSterile() {
        return isSterile;
    }
    public int getWeightInOunces() {
        return weightInOunces;
    }

    // SET
    public void setPersonalityDescription(String personalityDescription) {
        this.personalityDescription = personalityDescription;
    }
    public void setSterile(boolean sterile) {
        isSterile = sterile;
    }
    public void setWeightInOunces(int weightInOunces) {
        this.weightInOunces = weightInOunces;
    }

    // CHECK
    @Override
    public String toString() {
        return "PetDetails{" +
                "id=" + id +
                ", personalityDescription='" + personalityDescription + '\'' +
                ", isSterile=" + isSterile +
                ", weightInOunces=" + weightInOunces +
                '}';
    }

}  //<--END
