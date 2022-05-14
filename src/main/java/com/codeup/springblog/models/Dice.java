package com.codeup.springblog.models;

public class Dice {

    private int upSide;

    public Dice() {
    }
    public Dice(int upSide) {
        this.upSide = upSide;
    }

    public int getUpSide() {
        return upSide;
    }

    public void setUpSide(int upSide) {
        this.upSide = upSide;
    }
}
