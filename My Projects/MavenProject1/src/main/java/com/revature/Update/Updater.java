package com.revature.Update;

import com.revature.util.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Updater {
    public void renameTable(String oldTableName, String newTableName){
        String rename = "alter table "+oldTableName+" rename to "+newTableName;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(rename);
            ps.executeQuery();
            ConnectionFactory.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void renameColumn(String tableName, String oldColumnName, String newColumnName){
        String rename = "alter table "+tableName+" rename column "+oldColumnName+" to "+newColumnName;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(rename);
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateRecord(String tableName, String setColumnName, String setUpdate,
                             String condition){
        String update = "update "+tableName+" set "+setColumnName+"="+setUpdate+" where "+condition;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
