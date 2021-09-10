package com.revature.Create;
import com.revature.util.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Creator {

    public void createTable(String name){


        String create = "create table ? (ID serial not null)";
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(create);

            ps.setString(1, name);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
