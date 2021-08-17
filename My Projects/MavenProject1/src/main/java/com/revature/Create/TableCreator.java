package com.revature.Create;

import com.revature.models.Tables;
import com.revature.util.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableCreator {
    public  static void createTable(String name){

        String create = "CREATE TABLE ? (mycolumn varchar(50));";
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(create);
            ps.setString(1, name);
            ps.execute();
            ConnectionFactory.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
