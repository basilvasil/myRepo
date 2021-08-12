package com.revature.services;
import com.revature.displays.Menus;
import com.revature.models.BalanceBuilder;
import java.text.DecimalFormat;

import java.util.Scanner;
import static com.revature.DAO.AccountQueries.retrieveBalance;
import static com.revature.DAO.AccountQueries.updateBalance;

/**
 * This class performs services related to manipulating a user's balance
 */
public class ManageBalance {
    /**
     * A class scanner and DecimalFormat option are initialized
     * The DecimalFormat option will format the balance of the user's account
     */
    static DecimalFormat numberFormat = new DecimalFormat("#.00");
    static Scanner input = new Scanner(System.in);

    /**
     * The yourBalance() method pulls the account balance into a BalanceBuilder object
     * The argument passed will be the account number found when signing in to an account
     * @param userAccountNumber the account number from LogIntoAccount.checkPassword()
     */
    public static void yourBalance(String userAccountNumber){
        BalanceBuilder accountBalance = new BalanceBuilder();
        accountBalance.setBalanceAmount(retrieveBalance(userAccountNumber));

        double currentBalanceAmount = accountBalance.getBalanceAmount();
        Menus.balanceMenu(currentBalanceAmount, userAccountNumber);
    }

    /**
     * This method attempts to withdrawal an amount from a user's balance
     * If the withdrawal is larger than the user's balance, the withdrawal will not be preformed
     * It updates the balance with the calculateBalance() method
     * @param currentBalance user's current balance
     * @param accountNumber the user's account number
     */
    public static void withdrawalFromBalance(double currentBalance, String accountNumber){
        System.out.println("Please enter the amount you would like to withdrawal");
        double withdrawal = input.nextDouble();

        if(withdrawal>currentBalance){
            Menus.insufficientFundsMenu(currentBalance,accountNumber);
        }

        else{
            double newBalance = currentBalance - withdrawal;
            calculateBalance(newBalance, accountNumber);
            Menus.balanceMenu(newBalance, accountNumber);
        }
    }

    /**
     * This method adds a deposit to the users balance
     * It updates the balance with the calculateBalance() method
     * @param currentBalance the user's current balance
     * @param accountNumber the user's account number
     */
    public static void depositToBalance(double currentBalance, String accountNumber){
        System.out.println("Please enter an amount to deposit");
        double deposit = input.nextDouble();
        double newBalance = currentBalance + deposit;
        calculateBalance(newBalance, accountNumber);
        Menus.balanceMenu(newBalance, accountNumber);
    }

    /**
     * Calculates the new balance after a deposit or withdrawal
     * @param newBalance the updated balance
     * @param accountNumber the account number
     */
    public static void calculateBalance (double newBalance, String accountNumber){

        numberFormat.format(newBalance);
        updateBalance(newBalance, accountNumber);
        System.out.println("Finished");

    }

}
