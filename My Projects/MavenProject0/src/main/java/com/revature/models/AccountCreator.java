package com.revature.models;

public class AccountCreator implements Account{

    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String emailAddress;
    private int accountNumber;


    public AccountCreator() {
        super();
    }

    public AccountCreator(String firstName, String lastName, String streetAddress,
                          String city, String state, String zipCode, int accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.accountNumber = accountNumber;
    }
    @Override
    public int getAccountNumber() {return accountNumber;}
    @Override
    public void setAccountNumber(int newAccountNumber) {this.accountNumber = newAccountNumber;}

    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    @Override
    public String getStreetAddress() {
        return streetAddress;
    }
    @Override
    public void setStreetAddress(String newStreetAddress) {
        this.streetAddress = newStreetAddress;
    }


    @Override
    public String getCity() {
        return city;
    }
    @Override
    public void setCity(String newCity) {
        this.city = newCity;
    }

    @Override
    public String getState() {
        return state;
    }
    @Override
    public void setState(String newState) {
        this.state = newState;
    }

    @Override
    public String getZipCode() {return zipCode;}
    @Override
    public void setZipCode(String newZipCode) {this.zipCode = newZipCode;}

    @Override
    public String getEmailAddress() {return emailAddress;}
    @Override
    public void setEmailAddress(String newEmailAddress) {this.emailAddress = newEmailAddress;}
}
