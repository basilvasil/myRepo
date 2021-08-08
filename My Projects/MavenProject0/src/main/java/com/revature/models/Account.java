package com.revature.models;

public interface Account {


    int getAccountNumber();
    void setAccountNumber(int newAccountNumber);

    String getFirstName();
    void setFirstName(String newFirstName);

    String getLastName();
    void setLastName(String newLastName);

    String getStreetAddress();
    void setStreetAddress(String newStreetAddress);

    String getCity();
    void setCity(String newCity);

    String getState();
    void setState(String newState);

    String getZipCode();
    void setZipCode(String newZipCode);

    String getEmailAddress();
    void setEmailAddress(String newEmailAddress);
}
