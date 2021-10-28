package com.company;
import java.io.*;
import java.net.*;
public class Main {

    public static void main(String[] args) {
        if(args.length == 1 && args[0].equals("server")){
            Server.main(args);
        } else if(args.length == 1 && args[0].equals("client")){
            Client.main(args);
        } else {
            System.out.println("invalid usage... start with 1 agrument that should be either client or server");
        }
    }
}
