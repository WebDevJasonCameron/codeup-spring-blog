package com.codeup.springblog.models;

public class Coffee {
    private String roast;
    private String origin;
    private String brand;

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

    //    public Coffee(String roast, String origin) {            //<--BREAKS
//        this.roast = roast;
//        this.origin = origin;
//    }

    public String getRoast() {
        return roast;
    }

    public void setRoast(String roast) {
        this.roast = roast;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
