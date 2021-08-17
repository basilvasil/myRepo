package com.revature.models;
import com.revature.util.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tables {

    private static String name;
    private static String schema;

    public Tables(String name, String schema) {
        this.name = name;
        this.schema = schema;
    }

    @Override
    public String toString() {
        return "Tables{" +
                "name='" + name + '\'' +
                ", schema='" + schema + '\'' +
                '}';}

    public static String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public static String getSchema() {return schema;}

    public void setSchema(String schema) {this.schema = schema;}



}
