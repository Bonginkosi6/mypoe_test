/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import java.util.Scanner;
import javax.swing.*;
import java.util.Random;



public class ChatApp {//Start of class

    static int totalMessagesSent = 0;
    boolean isLoggedIn = true;

    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
        
    }

    public static boolean checkPassword(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*()].*");
    }

    public static boolean checkCellPhoneNumber(String phone) {
        return phone.matches(" \\+27\\d{9}");
    }

    public static boolean loginUser(String enteredUsername, String enteredPassword,
                                    String storedUsername, String storedPassword){
        
    
            return enteredUsername.equals (storedUsername)&&
                    
               enteredPassword.equals(storedPassword);
    }        
    public static void main(String[] args) {//start of main method
        
        
        Scanner input = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter SA phone number (+27...): ");
        String phone = input.nextLine();

        // ckeckUsername
        if (checkUserName(username)) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length");
            return;
        }

        // checkPassword
        if (checkPassword(password)) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character"
);
            return;
        }

        // checkPhonenumber
        if (checkCellPhoneNumber(phone)) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code");
            return;
        }

        // Login
        System.out.println("\n=====Login======:");
        System.out.print("Username: ");
        String userLogin = input.nextLine();

        System.out.print("Password: ");
        String passLogin = input.nextLine();

        if (loginUser(userLogin, passLogin, username, password)) {
            System.out.println("Welcome " + username + ", it is great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }
    
       
