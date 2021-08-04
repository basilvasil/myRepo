package mainPackage;

import java.util.Random;
import java.util.Scanner;

public class AccountCreation {
    private static String firstName;
    private static String lastName;
    private static String streetAddress;
    private static String city;
    private static String state;
    private static String zipCode;


    public static void creationOfAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name:");
        firstName = input.nextLine();
        System.out.println("Enter your last name:");
        lastName = input.nextLine();
        System.out.println("Enter your street address:");
        streetAddress = input.nextLine();
        System.out.println("Enter your city:");
        city = input.nextLine();
        System.out.println("Enter your state:");
        state = input.nextLine();
        System.out.println("Enter your zip code:");
        zipCode = input.nextLine();
    }

    private static void accountFinished(int accountChoice){
        if (accountChoice != 1) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }

    public static void verificationOfAccount() {
        Scanner input = new Scanner(System.in);
        while (true) {
            int verification = input.nextInt();

            switch (verification) {
                case 1:
                    int accountNumber = 100000000 + new Random().nextInt(900000000);
                    String accountString = Integer.toString(accountNumber);
                    String[] account = new String[7];
                    account[0] = firstName;
                    account[1] = lastName;
                    account[2] = streetAddress;
                    account[3] = city;
                    account[4] = state;
                    account[5] = zipCode;
                    account[6] = accountString;

                    System.out.println("Your account number is " + accountString +
                            "\nPress '1' to return to the main menu" +
                            "\nPress any other key to close the application");
                    int verificationChoice = input.nextInt();
                    accountFinished(verificationChoice);
                    break;
                case 2:
                    System.out.println("Lets try again\n");
                default:
                    System.out.println("Invalid entry. Try again");

            }
        }
    }
}
