package com.revature.Update;

import com.revature.util.AppAppenders;
import com.revature.util.ConnectionFactory;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Updater {

    final static Logger logger = Logger.getLogger(Updater.class);

    public static void renameTable(String oldTableName, String newTableName){
        String rename = "alter table "+oldTableName+" rename to "+newTableName;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(rename);
            ps.executeUpdate();
            ConnectionFactory.getConnection().close();
            AppAppenders.fileAppender();
            logger.info("Table "+oldTableName+" was renamed to "+newTableName);
        } catch (SQLException e) {
            AppAppenders.fileAppender();
            logger.error("Table "+oldTableName+" was NOT renamed to "+newTableName);
            e.printStackTrace();
        }
    }
    public static void renameColumn(String tableName, String oldColumnName, String newColumnName){
        String rename = "alter table "+tableName+" rename column "+oldColumnName+" to "+newColumnName;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(rename);
            ps.executeUpdate();
            ConnectionFactory.getConnection().close();
            AppAppenders.fileAppender();
            logger.info("Column "+oldColumnName+" in table "+tableName+" was SUCCESSFULLY renamed to "+newColumnName);
        } catch (SQLException e) {
            AppAppenders.fileAppender();
            logger.warn("Column "+oldColumnName+" in table "+tableName+" was NOT renamed to "+newColumnName);
            e.printStackTrace();
        }
    }
    public static void updateRecord(String tableName, String setColumnName, String setUpdate,
                             String condition){
        String update = "update "+tableName+" set "+setColumnName+"="+setUpdate+" where "+condition;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(update);
            ps.executeUpdate();
            ConnectionFactory.getConnection().close();
            AppAppenders.fileAppender();
            logger.info("Record in table "+tableName+" was SUCCESSFULLY updated");

        } catch (SQLException e) {
            logger.warn("Record in table "+tableName+" was NOT updated");
            e.printStackTrace();
        }
    }
}
