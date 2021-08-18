package com.revature.Create;
import com.revature.util.AppAppenders;
import com.revature.util.ConnectionFactory;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Creator {

    private final static Logger logger = Logger.getLogger(Creator.class);

    public static void createTable(String tableName){
        String create = "create table "+tableName+" (ID serial not null, Primary Key (ID));";
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(create);
            ps.execute();
            ConnectionFactory.getConnection().close();
            AppAppenders.fileAppender();
            logger.info("Table "+tableName+ " was SUCCESSFULLY created");
        } catch (SQLException e) {
            AppAppenders.fileAppender();
            logger.error("Table "+tableName+" was NOT created");
            e.printStackTrace();
        }
    }

    public static void createColumn(String tableName, String columnName, String enteredType){

        String create = "alter table "+tableName+" add "+columnName+" "+enteredType;

        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(create);
            ps.execute();
            ConnectionFactory.getConnection().close();
            AppAppenders.fileAppender();
            logger.info("Column "+columnName+" was SUCCESSFULLY created in table "+tableName);
        } catch (SQLException e) {
            AppAppenders.fileAppender();
            logger.warn("Column "+columnName+" was NOT created in "+tableName+
                        ". Verify method parameters are correct");
            e.printStackTrace();
        }
    }

    public static void createRecord(String tableName, String columnName, String value){

        String insert = "insert into "+tableName+" ("+columnName+") values("+value+")";

        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(insert);
            ps.execute();
            ConnectionFactory.getConnection().close();
            AppAppenders.fileAppender();
            logger.info("A record with the value "+value+" was SUCCESSFULLY inserted into column "+columnName+
                        " in table "+tableName);
        } catch (SQLException e) {
            AppAppenders.fileAppender();
            logger.warn("A record with the value "+value+
                        " was NOT created in column "+columnName+" in table "+tableName+
                        ". Verify method parameters are correct");
            e.printStackTrace();
        }
    }
}

