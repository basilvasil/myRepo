import java.util.Scanner;

public class Menu {
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
                AccountCreation.creationOfAccount();
            }

            else if (choice == 2) {
                System.out.println("Welcome back!");
            } else {
                System.out.println("Error! Try again");
                choice = input.nextInt();
            }
        }
    }
}
