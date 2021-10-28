package com.company;

import java.util.Random;

public abstract class Card {
    private enum elementType{
        Fire,
        Water,
        Normal
    }
    private enum monstertype{
        Goblin,
        Dragon,
        Wizzard,
        Orks,
        Knight,
        Kraken,
        Elve
    }
    private String name;
    private int dmg;
    elementType type;
    monstertype monster;

    public Card(){
        Random rand = new Random();
        int randomElement = rand.nextInt(3);
        int randomType = rand.nextInt(7);
        switch (randomElement){
            case 0:
                type = elementType.Fire;
                break;
            case 1:
                type = elementType.Water;
                break;
            case 2:
                type = elementType.Normal;
                break;
        }
        switch (randomType){
            case 0:
                monster = monstertype.Dragon;
                break;
            case 1:
                monster = monstertype.Elve;
                break;
            case 2:
                monster = monstertype.Goblin;
                break;
            case 3:
                monster = monstertype.Knight;
                break;
            case 4:
                monster = monstertype.Kraken;
                break;
            case 5:
                monster = monstertype.Orks;
                break;
            case 6:
                monster = monstertype.Wizzard;
                break;
        }
        name = String.valueOf(type) + String.valueOf(monster);
        dmg = rand.nextInt(10) * 10;
    }

    public int getDmg() {
        return dmg;
    }

    public String getName() {
        return name;
    }

}
