package revature;



import java.util.Random;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args){
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
                i = false;
            } else if (choice == 1) {
                creationOfAccount();

            }
            else if (choice == 2){
                System.out.println("Welcome back!");
                i = false;
            }
            else {
                System.out.println("Error! Try again");
                choice = input.nextInt();
            }
        }
    }

    public static void creationOfAccount() {
        AccountCreation creator = new AccountCreation();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your first name:");
        creator.setFirstName(input.nextLine());
        System.out.println("Enter your last name:");
        creator.setLastName(input.nextLine());
        System.out.println("Enter your street address:");
        creator.setStreetAddress(input.nextLine());
        System.out.println("Enter your city:");
        creator.setCity(input.nextLine());
        System.out.println("Enter your state:");
        creator.setState(input.nextLine());
        System.out.println("Enter your zip code:");
        creator.setZipCode(input.nextLine());
        System.out.println("Enter your email address:");
        creator.setEmailAddress(input.nextLine());

        boolean i = true;
        while (i) {
            System.out.println("Is the following correct?\n" +
                    "Name: " + creator.getFirstName() + " " + creator.getLastName() + "\n" +
                    "Street Address: " + creator.getStreetAddress()+ "\n" +
                    "City: " + creator.getCity() + "\n" +
                    "State: " + creator.getState() + "\n" +
                    "Zip Code: " + creator.getZipCode() + "\n" +
                    "Email Address: " +creator.getEmailAddress() +"\n" +
                    "Enter '1' for 'Yes' or '2' for no");
            int verification = input.nextInt();
            if (verification == 1) {
                int accountNumber = 100000000 + new Random().nextInt(900000000);
                String accountString = Integer.toString(accountNumber);
                String[] account = new String[8];
                account[0] = creator.getFirstName();
                account[1] = creator.getLastName();
                account[2] = creator.getStreetAddress();
                account[3] = creator.getCity();
                account[4] = creator.getState();
                account[5] = creator.getZipCode();
                account[6] = creator.getEmailAddress();
                account[7] = accountString;

                System.out.println("Your account number is " + accountString +
                        "\nPress '1' to return to the main menu" +
                        "\nPress any other key to close the application");

                int accountFinished = input.nextInt();

                if (accountFinished == 1) {
                    break;
                } else {
                    System.out.println("Goodbye!");
                    i = false;
                }

            } else if ( verification == 2) {
                System.out.println("Lets try again\n");

            } else {
                System.out.println("Invalid entry. Try again");
            }
        }
    }
}

