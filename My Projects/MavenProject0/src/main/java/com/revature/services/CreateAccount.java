package com.revature.services;

import com.revature.DAO.AccountQueries;
import com.revature.displays.Menus;
import com.revature.models.AccountCreator;
import org.postgresql.util.PSQLException;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

/**
 * The CreateAccount class holds the services performed on AccountCreator objects
 */
public class CreateAccount {
    /**
     * A private AccountCreator named newAccount is instantiated
     *
     */
    private static final AccountCreator newAccount = new AccountCreator();
    private static final Scanner input = new Scanner(System.in);

    /**
     * This method asks a user to enter information for their new account
     * It then sets that information to the newAccount object
     * Next, it generates a random number using the Random class
     * Finally, it converts that number as a string and then stores it
     */
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

        int accountNumber = 100000000 + new Random().nextInt(900000000);
        String accountNumberAsString = String.valueOf(accountNumber);
        newAccount.setAccountNumber(accountNumberAsString);

        createPassword();

    }

    /**
     * The insertAccount() method runs three SQL queries
     * insertIntoUserInfo(), insertIntoAccount() and insertIntoUser()
     * These queries can be found in the AccountQueries class in the DAO package
     */
    public static void insertAccount() {


            AccountQueries.insertIntoUserInfo(newAccount.getEmailAddress(), newAccount.getStreetAddress(),
                    newAccount.getCity(), newAccount.getState(), newAccount.getZipCode());

            AccountQueries.insertIntoAccount(newAccount.getAccountNumber());

            AccountQueries.insertIntoUser(newAccount.getFirstName(), newAccount.getLastName(), newAccount.getAccountNumber(),
                    newAccount.getPassword(), newAccount.getEmailAddress());


    }

    /**
     * The createPassword() method asks the user to create a password for their account
     * It asks for the password, and then to confirm it
     * If the confirmation matches the initial entry, the method runs the verifyAccount() located in this class
     * Otherwise, it prompts the user to try again
     */
    public static void createPassword() {
        System.out.println("Please create a password:");
        newAccount.setPassword(input.nextLine());
        System.out.println("Please confirm your password");
        String confirmedPassword = input.nextLine();


        if (confirmedPassword.equals(newAccount.getPassword())) {
            verifyAccount();
        } else {
            System.out.println("Passwords do not match. Please try again\n");
            createPassword();
        }
    }

    /**
     * The verifyAccount() method asks the user to verify the information they entered in the createAccount() method
     * If the user indicates the information is incorrect, the method will run the createAccount() method\
     * If the user confirms the information is correct the insertAccount() method is run
     * Then it takes the user to the accountFinishedMenu() method in the Menus class in the displays package
     * If an invalid character is entered in the initial prompt, the method is rerun
     */
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
        while (i) {
            if (verification == 1) {
                insertAccount();
                System.out.println("Your account number is " + newAccount.getAccountNumber());
                Menus.accountFinishedMenu();
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
}




