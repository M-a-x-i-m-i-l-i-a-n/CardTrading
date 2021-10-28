package com.company;

public class User {
    private String username;
    private String password;
    Card[] deck;
    Card[] stack;
    int elo;
    int coins;


    public User(String username, String password){
        this.username = username;
        this.password = password;
        elo = 100;    //starting elo for every new player
        coins = 20;

    }
    public void setUsername(String username){this.username = username;}
    public void setPassword(String password){this.password = password;}
    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public int getElo(){
        return elo;
    }
    public void setElo(int elo){
        this.elo =+ elo;
    }
    public int getCoins(){
        return coins;
    }
    public void setCoins(){
        coins = coins - 5;
    }
}
