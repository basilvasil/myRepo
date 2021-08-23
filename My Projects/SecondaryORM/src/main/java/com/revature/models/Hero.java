package com.revature.models;

public class Hero {
    private int id;
    private String firstName;
    private String lastName;
    private String alias;




    public Hero(int id, String firstName, String lastName, String alias) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
    }

    public Hero(String firstName, String lastName, String alias) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "Heroes{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}

