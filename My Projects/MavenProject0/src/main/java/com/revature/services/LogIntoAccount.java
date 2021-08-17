package com.revature.services;

import com.revature.DAO.AccountQueries;
import com.revature.models.AccountAccessor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class performs services when attempting to log into an account
 *
 */
public class LogIntoAccount {
    /**
     * A class scanner and a AccountAccessor object are initialized
     */
    private static final Scanner input = new Scanner(System.in);
    private static final AccountAccessor logIntoAccount = new AccountAccessor();

    /**
     * The enterEmailAddress() method asks the user to enter their email address
     * Then it executes the checkForEmail() method found in this class
     */
    public static void enterEmailAddress() {
        System.out.println("Please enter your email address");
        logIntoAccount.setEmailAddress(input.nextLine());
        checkForEmail();

    }

    /**
     * The checkForEmail() method is used to run the query in the retrieveEmailAndPassword() method
     * The query searches for the entered email address in enterEmailAddress() and stores it in a RevArrayList
     * If one is not found, an IndexOutOfBoundsException is thrown
     * This indicates an account for that email address does not exist
     */
    public static void checkForEmail() {
        ArrayList<String> emailAccountList =
                AccountQueries.retrieveEmailAndPassword(logIntoAccount.getEmailAddress());
        try {
            emailAccountList.get(0);
            enterPassword();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Email address does not exist.");
            enterEmailAddress();
        }
    }

    /**
     * The enterPassword() method prompts the user to enter their password
     * It then executes the checkForPassword() method
     */
    public static void enterPassword() {
        System.out.println("Please enter your password:");
        logIntoAccount.setPassword(input.nextLine());
        checkForPassword();

    }

    /**
     * The checkForPassword() runs the query in the retrieveEmailAndPassword() method
     * The query searches the record with the entered email address in enterEmailAddress()
     * It then pulls the email address and password into a RevArrayList
     * If the password in the list matches the one entered, the user is logged in
     * This method also passes the account number to be used in the youBalanceMethod()
     * Note: if an email address entered is not found, this method will not be executed
     */
    public static void checkForPassword(){
            ArrayList<String> passwordAccountList =
                    AccountQueries.retrieveEmailAndPassword(logIntoAccount.getEmailAddress());

            if(passwordAccountList.get(1).equals(logIntoAccount.getPassword())){
                String accountNumber = AccountQueries.retrieveAccountNumber(logIntoAccount.getEmailAddress());
                System.out.println("Welcome!\n");
                ManageBalance.yourBalance(accountNumber);
                System.exit(0);
            }
            else{
                System.out.println("Password Incorrect");
            }
    }
}



