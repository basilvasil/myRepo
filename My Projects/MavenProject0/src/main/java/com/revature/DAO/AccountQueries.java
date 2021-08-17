package com.revature.DAO;

import com.revature.services.CreateAccount;
import com.revature.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;



/**
 * This class belong to the DAO layer of the application
 * It holds a method for all the SQL queries that are made during runtime
 */
public class AccountQueries {

    
    /**
     * The insertIntoUserInfo() method creates a new record in the userinfo table in the project0 schema
     * It does this using an SQL command
     * It is run after the user has confirmed their information in CreateAccount.verifyAccount()
     * @param newEmailAddress the new user's email address
     * @param newStreetAddress the new user's street address
     * @param newCity the new user's city
     * @param newState the new user's state
     * @param newZipCode the new user's zip code
     */
    public static void insertIntoUserInfo(String newEmailAddress, String newStreetAddress, String newCity,
                                          String newState, String newZipCode) {
        String insertUserInfo = "insert into project0.userinfo(registeredemail, streetaddress, " +
                "city, state, zipcode) values(?,?,?,?,? )";
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(insertUserInfo);
            ps.setString(1, newEmailAddress);
            ps.setString(2, newStreetAddress);
            ps.setString(3, newCity);
            ps.setString(4, newState);
            ps.setString(5, newZipCode);
            ps.execute();
            ConnectionFactory.getConnection().close();
        } catch (SQLException e) {
            //e.printStackTrace();
        }


    }

    /**
     * The insertIntoAccount() method inserts a new record into the accounts table of the project0 schema
     * It does this using an SQL command
     * It is run after the user has confirmed their information in CreateAccount.verifyAccount()
     * @param accountNumber the user's account number
     */
    public static void insertIntoAccount(String accountNumber) {
        String insertAccount = "insert into project0.accounts(accountnumber, balance) " +
                "values(?,0)";
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(insertAccount);
            ps.setString(1, accountNumber);
            ps.execute();
            ConnectionFactory.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    /**
     * The insertIntoUser() method inserts a new record into the users table of the project0 schema
     * It does this using an SQL command
     * It is run after the user has confirmed their information in CreateAccount.verifyAccount()
     * Additionally, it must be run after insertIntoAccount() and insertIntoUserInfo()
     * This is do to the foreign key constraints on the users table
     * @param newFirstName The new user's first name
     * @param newLastName The new user's last name
     * @param newAccountNumber The new user's account number
     * @param newUserPassword The new user's password
     * @param newEmailAddress The new user's email address
     */
    public static void insertIntoUser(String newFirstName, String newLastName, String newAccountNumber,
                                      String newUserPassword, String newEmailAddress) {
        String insertUser = "insert into project0.users(firstname, lastname, accountnumber, userpassword, " +
                "emailaddress) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(insertUser);
            ps.setString(1, newFirstName);
            ps.setString(2, newLastName);
            ps.setString(3, newAccountNumber);
            ps.setString(4, newUserPassword);
            ps.setString(5, newEmailAddress);
            ps.execute();
            ConnectionFactory.getConnection().close();

        } catch (SQLException e) {
            System.out.println("An account is already registered to that email. Please try again");
            deleteExtraAccount();
            CreateAccount.createAccount();
        }
    }

    /**
     * The retrieveEmailAndPassword() method pulls the email address and password form a record
     * This record is stored in the users table of the project0 schema
     * It stores the retrieved values in a RevArrayList
     * That list is then used in the LogIntoAccount class for various services
     * @param emailAddress the existing user's email address
     * @return returns the user's email address and password in a RevArrayList
     */
    public static ArrayList<String> retrieveEmailAndPassword(String emailAddress) {
        ArrayList<String> accountList = new ArrayList<>();
        try {

            final String searchForPassword = "select \"emailaddress\", \"userpassword\" from project0.users where " +
                    "emailaddress = '" +
                    emailAddress + "';";
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(searchForPassword);
            ResultSet rs = ps.executeQuery();
            ConnectionFactory.getConnection().close();
            while (rs.next()) {
                accountList.add(rs.getString(1));
                accountList.add(rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return accountList;
    }

    /**
     * The retrieveBalance() method retrieves the user's account balance
     * @param accountNumber the account number associated with the balance
     * @ returns the balance in a RevArrayList
     */
    public static double retrieveBalance(String accountNumber) {
        ArrayList<Double> balance = new ArrayList<>();
        String pullBalance = "select balance from project0.accounts where accountnumber = ?";
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(pullBalance);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            ConnectionFactory.getConnection().close();

            while (rs.next()) {
                balance.add(rs.getDouble(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return balance.get(0);
    }

    /**
     * The retrieveAccountNumber() retrieves an existing user's account number
     * Its is used in LogIntoAccount.checkForPassword()
     * It retrieves the account number, so it can then be used ManageBalance.yourBalance()
     * @param emailAddress the existing user's email address
     * @return returns the existing user's account number
     */
    public static String retrieveAccountNumber(String emailAddress){

        ArrayList accountNumberList = new ArrayList();
        String pullAccountNumber = "select accountnumber from project0.users where emailaddress = ?;";
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(pullAccountNumber);
            ps.setString(1, emailAddress);
            ResultSet rs = ps.executeQuery();
            ConnectionFactory.getConnection().close();

            while (rs.next()) {
                accountNumberList.add(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        String userAccountNumber = String.valueOf(accountNumberList.get(0));
        return userAccountNumber;
    }

    /**
     * The updateBalance() method updates the existing balance in the accounts table of the project0 schema
     * It is executed in ManageBalance.calculateBalance()
     * @param newBalance the new balance to be entered
     * @param accountNumber the account number associated with the balance
     */
    public static void updateBalance(double newBalance, String accountNumber){
        String updateUserBalance = "update project0.accounts set balance = ? where accountnumber = ?";
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(updateUserBalance);
            ps.setDouble(1,newBalance);
            ps.setString(2, accountNumber);
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method deletes an extra record generated by the insertIntoUsers() method
     * When the SQLException is thrown a new account record is generated
     * This method deletes that record
     */
    public static void deleteExtraAccount(){
        String deleteExtra = "  DELETE\n" +
                "  FROM project0.accounts\n" +
                "  WHERE entry in (\n" +
                "      SELECT entry \n" +
                "      FROM project0.accounts \n" +
                "      ORDER BY entry desc\n" +
                "      LIMIT 1\n" +
                "     )";

        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(deleteExtra);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
