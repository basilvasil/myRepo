package com.revature.services;

import com.revature.Driver;
import com.revature.models.AccountCreator;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class AccountCreation {
    private static final Connection connection = ConnectionFactory.getConnection();
    private static final String insertSQL = "insert into project0.accounts(emailaddress, firstname, lastname, " +
            "streetaddress , city , state , zipcode) " +
            "values (?, ?, ?, ?, ?, ?, ?);";
    private static final AccountCreator newAccount = new AccountCreator();
    private static final Scanner input = new Scanner(System.in);

    public static void createAccount() {
        System.out.println("Enter your email address:");
        newAccount.setEmailAddress(input.nextLine());
        System.out.println("Enter your first name:");
        newAccount.setFirstName(input.nextLine());
        System.out.println("Enter your last name:");
        newAccount.setLastName(input.nextLine());
        System.out.println("Enter your street address:");
        newAccount.setStreetAddress(input.nextLine());
        System.out.println("Enter your city:");
        newAccount.setCity(input.nextLine());
        System.out.println("Enter your state:");
        newAccount.setState(input.nextLine());
        System.out.println("Enter your zip code:");
        newAccount.setZipCode(input.nextLine());

        verifyAccount();
    }

    public static void insertAccount() {
        try {
            PreparedStatement ps = connection.prepareStatement(insertSQL);
            ps.setString(1, newAccount.getEmailAddress());
            ps.setString(2, newAccount.getFirstName());
            ps.setString(3, newAccount.getLastName());
            ps.setString(4, newAccount.getStreetAddress());
            ps.setString(5, newAccount.getCity());
            ps.setString(6, newAccount.getState());
            ps.setString(7, newAccount.getZipCode());

            ps.execute();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void verifyAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Is the following information correct? Press '1' for 'Yes' or '2' for 'No'.\n" +
                "Email Address: " + newAccount.getEmailAddress() + "\n" +
                "First Name: " + newAccount.getFirstName() + "\n" +
                "Last Name: " + newAccount.getLastName() + "\n" +
                "Street Address: " + newAccount.getStreetAddress() + "\n" +
                "City: " + newAccount.getCity() + "\n" +
                "State: " + newAccount.getState() + "\n" +
                "Zip Code: " + newAccount.getZipCode());
        int verification = input.nextInt();
        boolean i = true;
        while(i){
            if (verification == 1) {
                insertAccount();
                newAccount.setAccountNumber(100000000 + new Random().nextInt(900000000));
                System.out.println("Your account number is " + newAccount.getAccountNumber() +
                        "\nPress '1' to return to the main menu" +
                        "\nPress any other key to close the application");
                int verifyChoice = input.nextInt();
                accountFinished(verifyChoice);
                i = false;
            } else if (verification == 2) {
                System.out.println("Lets try again\n\n");
                createAccount();
                i = false;
            } else {
                System.out.println("Invalid input! Select a valid choice.");
                verifyAccount();
            }
        }

    }

    private static void accountFinished(int choice) {
            if (choice == 1) {
                Driver.mainMenu();
            }
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }



