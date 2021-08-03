package mainPackage;

import java.util.Random;
import java.util.Scanner;

public class AccountCreation {
    private static String firstName;
    private static String lastName;
    private static String  streetAddress;
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
    public static void verificationOfAccount(){
        Scanner input = new Scanner(System.in);
        boolean i = true;
        while (i) {
            System.out.println("Is the following correct?\n" +
                    "Name: " + firstName + " " + lastName + "\n" +
                    "Street Address: " + streetAddress + "\n" +
                    "City: " + city + "\n" +
                    "State: " + state + "\n" +
                    "Zip Code: " + zipCode + "\n" +
                    "Enter '1' for 'Yes' or '2' for no");
            int verification = input.nextInt();
            if (verification == 1) {
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

                int accountFinished = input.nextInt();
                if (accountFinished == 1) {
                    break;
                } else {
                    System.out.println("Goodbye!");
                    i = false;
                    System.exit(0);
                }

            } else if ( verification == 2) {
                System.out.println("Lets try again\n");
                break;
            } else {
                System.out.println("Invalid entry. Try again");
            }
        }
    }
}
