package com.revature.services;

import com.revature.models.AccountAccess;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.util.Scanner;

public class AccountLogIn {
    private static final Connection connection = ConnectionFactory.getConnection();
    private static final Scanner input = new Scanner(System.in);
    private static final AccountAccess logIntoAccount = new AccountAccess();
    public static void LogIn(){
        System.out.println("Please enter your email address");
        String emailLogIn = input.nextLine();


    }



}
