package com.revature.Delete;

import com.revature.util.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deleter {
    public static void dropTable(String tableName){
        String drop = "drop table "+tableName;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(drop);
            ps.executeQuery();
            ConnectionFactory.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void dropColumn(String tableName, String columnName){
        String drop = "alter table "+tableName+" drop column "+columnName;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(drop);
            ps.executeQuery();
            ConnectionFactory.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRecord(String tableName, String columnName, String recordName){
        String delete = "delete from "+tableName+" where "+columnName+"="+recordName;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(delete);
            ps.executeQuery();
            ConnectionFactory.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
