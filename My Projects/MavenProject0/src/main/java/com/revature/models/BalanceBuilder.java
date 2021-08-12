package com.revature.models;

/**
 * This class builds BalanceBuilder objects
 * An AccountCreator object is used in the ManageBalance class in the services package
 * Various services are performed on it there
 */


public class BalanceBuilder {

    private double balanceAmount;

    public double getBalanceAmount() {return balanceAmount;}
    public void setBalanceAmount(double balanceAmount) {this.balanceAmount = balanceAmount;}
}
