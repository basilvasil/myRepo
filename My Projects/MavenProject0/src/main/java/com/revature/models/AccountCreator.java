package com.revature.models;

/**
 * This class builds AccountCreator objects
 * An AccountCreator object is used in the CreateAccount class in the services package
 * Various services are performed on it there
 */

public class AccountCreator{

    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String emailAddress;
    private String accountNumber;
    private String password;


    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getAccountNumber() {return accountNumber;}
    public void setAccountNumber(String newAccountNumber) {this.accountNumber = newAccountNumber;}

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String newStreetAddress) {
        this.streetAddress = newStreetAddress;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String newCity) {
        this.city = newCity;
    }

    public String getState() {
        return state;
    }
    public void setState(String newState) {
        this.state = newState;
    }

    public String getZipCode() {return zipCode;}
    public void setZipCode(String newZipCode) {this.zipCode = newZipCode;}

    public String getEmailAddress() {return emailAddress;}
    public void setEmailAddress(String newEmailAddress) {this.emailAddress = newEmailAddress;}

    public String toString() {
        return "AccountCreator{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
