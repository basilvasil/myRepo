package com.revature.models;

/**
 * This class builds AccountAccessor objects
 * An AccountAccessor object is used in the LogIntoAccount class in the services package
 * Various services are performed on it there
 */

public class AccountAccessor {

    private String emailAddress;
    private String password;

    public String getPassword(){return password;}
    public void setPassword(String newPassword){this.password=newPassword;}

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String newEmailAddress) {
        this.emailAddress=newEmailAddress;
    }

}
