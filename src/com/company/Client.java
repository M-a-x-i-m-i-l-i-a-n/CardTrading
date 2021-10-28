package com.company;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static User clientUser = new User("username", "password");
    //All the inputs from the user are processed with these methods
    public static int intInput(){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }
    public static String stringInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
    //Handels the register input
    public static void register(){
        boolean problem = true;
        String username = "username", password = "a", pwdcheck = "b";

        while (problem) {
            System.out.println("To register, you have to choose a username and a password.\nPlease choose a username: ");
            username = stringInput();

            while (!password.equals(pwdcheck)) {
                System.out.println("Please choose a password: ");
                password = stringInput();
                System.out.println("Please confirme you password: ");
                pwdcheck = stringInput();

                if (password.equals(pwdcheck)) {
                    problem = false;
                    System.out.println("Your username an password are now saved and you can use them to login in the future.");
                } else {
                    System.out.println("The first and second entry of the password are not the same. Please try again.");
                }
            }
        }
        clientUser.setUsername(username);
        clientUser.setPassword(password);
    }
    //Handels the login input
    public static void login(){
        String username, password;
        System.out.println("Please enter you username: ");
        username = stringInput();
        System.out.println("Please enter you password: ");
        password = stringInput();
         clientUser.setUsername(username);
         clientUser.setPassword(password);
    }
    public static void printOptions(){
        System.out.println("Welcome to the menu. Please choose one of the following options.\n1 - Manage cards\n2 - Buy a pack\n3 - Battle\n4 - Show Scoreboard\n5 - Show Profile");
    }
    public static void main(String[] args){
        System.out.println("Welcome to MTCG\nIf you already have an account the please choose the login option. If you are new to the game then plesae create an account.\n1 - Login\n2 - Register");

            System.out.println("Please chosse an option");
            int option = intInput();
            while (option != 1 || option != 2) {
                System.out.println("The chosen option is not valid. Please try again.\n1 - Login\n2 - Register");
                option = intInput();
            }

            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
            }

        //Rest-Communication is needed
        //The first thing that is send to the server is the username and the password of the user to check if the user is already saved

        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
            System.out.println("cli: " + reader.readLine());
            System.out.println("cli: " + reader.readLine());
            String input = null;
            System.out.println("cli: ");
            while (!"quit".equals(input = consoleReader.readLine())){
                writer.write(input);
                writer.newLine();
                writer.flush();
                System.out.println("cli: ");
            }
            writer.write("quit");
            writer.newLine();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("close client");
    }
}
