package net.revature;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    String first;
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
                    AccountCreation creator = new AccountCreation();
                    creator.creationOfAccount();
            }

            else if (choice == 2){
                System.out.println("Welcome back!");
            }
            else {
                System.out.println("Error! Try again");
                choice = input.nextInt();
            }
        }
    }
}
