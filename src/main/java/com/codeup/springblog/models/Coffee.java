package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="coffees")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50)
    private String roast;
    @Column(nullable = false)
    private String origin;
    @Column(nullable = false, length = 100)
    private String brand;

    // CON
    public Coffee() {
    }
    public Coffee(String roast, String brand) {
        this.roast = roast;
        this.origin = brand;
    }
    public Coffee(String roast, String origin, String brand) {
        this.roast = roast;
        this.origin = origin;
        this.brand = brand;
    }

    // GET
    public String getRoast() {
        return roast;
    }
    public String getOrigin() {
        return origin;
    }
    public String getBrand() {
        return brand;
    }

    // SET
    public void setRoast(String roast) {
        this.roast = roast;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

}  //<--END
