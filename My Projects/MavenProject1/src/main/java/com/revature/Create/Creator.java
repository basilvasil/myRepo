package com.revature.Create;
import com.revature.util.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Creator {
    public void createTable(String tableName){
        String create = "create table "+tableName+" (ID serial not null, Primary Key (ID));";
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(create);
            ps.executeQuery();
            ConnectionFactory.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createColumn(String tableName, String columnName, String enteredType){

        String create = "alter table "+tableName+" add "+columnName+" "+enteredType;

        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(create);
            ps.executeQuery();
            ConnectionFactory.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createRecord(String tableName, String columnName, String value){

        String insert = "insert into "+tableName+" ("+columnName+") values("+value+")";

        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(insert);
            ps.executeQuery();
            ConnectionFactory.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

