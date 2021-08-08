package com.revature;
import com.revature.services.AccountCreation;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Press '1' to create a new account.\nPress '2' to" +
                    "log into an existing account.\nPress '0' to exit");
            int choice = input.nextInt();
            switch(choice) {
                case 1:
                    AccountCreation.createAccount();
                    break;
                case 2:
                    System.out.println("Welcome back");
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input! Select a valid choice.");
            }
        }
    }
}

