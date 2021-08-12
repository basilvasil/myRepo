
package com.revature.displays;

import com.revature.services.CreateAccount;
import com.revature.services.LogIntoAccount;
import com.revature.services.ManageBalance;
import java.text.DecimalFormat;
import java.util.Scanner;



public class Menus {
    /**
     * This class belongs to the display layer
     * It houses methods used to display the various menus to users
     */
    static DecimalFormat numberFormat = new DecimalFormat("#.00");
    private static final Scanner input = new Scanner(System.in);

    /**
     * This is the main menu
     * It is executed in the main method
     */
    public static void MainMenu() {

                while (true) {
                    System.out.println("Press 1 to create a new account.\nPress 2 to " +
                            "log into an existing account.\nPress 0 to exit");
                    String choice = input.nextLine();

                    switch (choice) {
                        case "1":
                            CreateAccount.createAccount();
                            break;
                        case "2":
                            LogIntoAccount.enterEmailAddress();
                            break;
                        case "0":
                            System.out.println("Goodbye!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid input! Select a valid choice.");
                    }
                }


        }



    /**
     * This menu is accessed by users that log into their account to make changes to their balance
     * @param currentBalanceAmount the user's current balance
     * @param accountNumber the user's account number
     */
    public static void balanceMenu(double currentBalanceAmount, String accountNumber) {
        System.out.println("Your balance is " + numberFormat.format(currentBalanceAmount) + "\n" +
                "Press 1 to make a withdrawal\n" +
                "Press 2 to make a deposit\n" + "Press 0 to close");
        while (true) {
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    ManageBalance.withdrawalFromBalance(currentBalanceAmount, accountNumber);
                    break;
                case "2":
                    ManageBalance.depositToBalance(currentBalanceAmount, accountNumber);
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input! Select a valid choice.");

            }
        }
    }

    /**
     * This menu is used when a user attempts to withdrawal more money than is in their balance
     * It prompts them to try again, or to exit
     * @param userBalance the user's actual balance and not the withdrawal amount
     * @param userAccountNumber the account number of the user
     */
    public static void insufficientFundsMenu(double userBalance, String userAccountNumber) {
        System.out.println("Insufficient funds.\n" +
                "Press 1 to try again\n" +
                "Press 2 to return to the main menu\n" +
                "Press 0 to exit");
        String choice = input.nextLine();
        while (true) {
            switch (choice) {
                case "1":
                    ManageBalance.withdrawalFromBalance(userBalance, userAccountNumber);
                case "2":
                    Menus.MainMenu();
                case "0":
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }

    /**
     * This menu appears after a user has finished creating their account
     * It prompts to return to the main menu using Menus.MainMenu() or to exit
     */
    public static void accountFinishedMenu() {

        System.out.println("Press 1 to return to the main menu\n" +
                "Press 0 to exit the application");
        String choice = input.nextLine();
        while (true) {
            switch (choice) {
                case "1":
                    Menus.MainMenu();
                case "0":
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again!");
            }
        }
    }
}
