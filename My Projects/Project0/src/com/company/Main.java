package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        mainMenu();
    }

  public static void mainMenu() {
        System.out.println("Press '1' to create a new account.\nPress '2' to" +
                            "log into " + "an existing account.\nPress '0' to exit");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        boolean i = true;
            while (i) {
                if (choice == 0) {
                    System.out.println("Goodbye!");
                    break;
                } else if (choice == 1) {
                    newAccount();
                    i = false;
                } else if (choice == 2) {
                    i = false;
                } else {
                    System.out.println("Error! Try again");
                    choice = input.nextInt();
                }
            }
        }


    public static void newAccount() {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter your first name:");
        String firstName = read.nextLine();
        System.out.println("Enter your last name:");
        String lastName = read.nextLine();
        System.out.println("Enter your street address:");
        String streetAddress = read.nextLine();
        System.out.println("Enter your city:");
        String city = read.nextLine();
        System.out.println("Enter your state:");
        String state = read.nextLine();
        System.out.println("Enter your zip code:");
        String zip = read.nextLine();

        boolean i = true;
        while (i) {
            System.out.println("Is the following correct?\n" +
                    "Name: " + firstName + " " + lastName + "\n" +
                    "Street Address: " + streetAddress + "\n" +
                    "City: " + city + "\n" +
                    "State: " + state + "\n" +
                    "Zip Code: " + zip + "\n" +
                    "Enter '1' for 'Yes' or '2' for no");
            int choice = read.nextInt();
            if (choice == 1) {
                int accountNumber = 100000000 + new Random().nextInt(900000000);
                System.out.println("Your account number is " + accountNumber +
                        "\nPress '1' to return to the main menu" +
                        "\nPress any other key to close the application");
                int accountFinished = read.nextInt();
                    if(accountFinished == 1){
                        mainMenu();
                        break;
                    }
                    else {
                        System.out.println("Goodbye!");
                        i = false;
                    }
            } else if (choice == 2) {
                System.out.println("Lets try again\n");
                newAccount();
            } else {
                System.out.println("Invalid entry. Try again");
            }
        }
    }

    public static void returningUser(){


    }
}



