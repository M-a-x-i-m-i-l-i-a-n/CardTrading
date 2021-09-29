package com.company;

public abstract class Card {
    private enum elementType{
        fire,
        water,
        normal;
    }
    private String name;
    private int dmg;


    public Card(String name, int dmg){
        this.name = name;
        this.dmg = dmg;
    }

    public int getDmg() {
        return dmg;
    }

    public String getName() {
        return name;
    }
}
