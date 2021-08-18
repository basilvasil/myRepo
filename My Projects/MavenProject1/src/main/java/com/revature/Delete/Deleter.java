package com.revature.Delete;

import com.revature.util.AppAppenders;
import com.revature.util.ConnectionFactory;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deleter {

    final static Logger logger = Logger.getLogger(Deleter.class);

    public static void dropTable(String tableName){
        String drop = "drop table "+tableName;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(drop);
            ps.execute();
            ConnectionFactory.getConnection().close();
            AppAppenders.fileAppender();
            logger.info("Table "+tableName+" was SUCCESSFULLY dropped");

        } catch (SQLException e) {
            AppAppenders.fileAppender();
            logger.error("Table "+tableName+" was NOT dropped");
            e.printStackTrace();
        }
    }

    public static void dropColumn(String tableName, String columnName){
        String drop = "alter table "+tableName+" drop column "+columnName;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(drop);
            ps.execute();
            ConnectionFactory.getConnection().close();
            AppAppenders.fileAppender();
            logger.info("Column "+columnName+" in table "+tableName+" was SUCCESSFULLY dropped");
        } catch (SQLException e) {
            AppAppenders.fileAppender();
            logger.info("Column "+columnName+" in table "+tableName+
                        " was NOT dropped. Verify method parameters are correct");
            e.printStackTrace();
        }
    }

    public static void deleteRecord(String tableName, String columnName, String recordName){
        String delete = "delete from "+tableName+" where "+columnName+"="+recordName;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(delete);
            ps.execute();
            ConnectionFactory.getConnection().close();
            AppAppenders.fileAppender();
            logger.info("Record "+recordName+" was SUCCESSFULLY deleted from column "+columnName+
                    " in table "+tableName);
        } catch (SQLException e) {
            AppAppenders.fileAppender();
            logger.info("Record  "+recordName+" was NOT deleted from column "+columnName+
                    " in table "+tableName);
            e.printStackTrace();
        }
    }
}
