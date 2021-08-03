import java.util.Random;
import java.util.Scanner;

public class AccountCreation {



    public static void creationOfAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name:");
        String firstName = input.nextLine();
        System.out.println("Enter your last name:");
        String lastName = input.nextLine();
        System.out.println("Enter your street address:");
        String streetAddress = input.nextLine();
        System.out.println("Enter your city:");
        String city = input.nextLine();
        System.out.println("Enter your state:");
        String state = input.nextLine();
        System.out.println("Enter your zip code:");
        String zipCode = input.nextLine();

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
                    Menu.mainMenu();
                } else {
                    System.out.println("Goodbye!");
                    i = false;
                    System.exit(0);
                }

            } else if ( verification == 2) {
                System.out.println("Lets try again\n");
                creationOfAccount();
            } else {
                System.out.println("Invalid entry. Try again");
            }
        }
    }
}
