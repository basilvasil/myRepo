package com.revature.models;

public class Records {

    private String type;
    private String name;
    private String attribute;

    @Override
    public String toString() {
        return "Records{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", attribute='" + attribute + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
