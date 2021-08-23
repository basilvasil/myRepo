package com.revature.services;

import com.revature.models.Hero;
import com.revature.util.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Crud {

    public Optional<List<Hero>> readORM(){
        List<Hero> allHeroes = new ArrayList<>();
        try{
            String sql = "select * from heroes";
            PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                allHeroes.add(new Hero(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("alias")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(allHeroes);

    }
    public int insert(Hero hero) {
        try{
            PreparedStatement stmt;
            String sql = "INSERT into hero (firstname, lastname, alias) " +
                    "VALUES (?, ?, ?)";
            stmt = ConnectionFactory.getConnection().prepareStatement(sql);
            stmt.setInt(1, hero.getId());
            stmt.setString(2, hero.getFirstName());
            stmt.setString(3, hero.getLastName());
            stmt.setString(4, hero.getAlias());

            return stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public boolean update(Hero hero) {
        int success = 0;

        try{
            String sql = "UPDATE heroes set firstname = ?," +
                    " lastname = ?, alias = ?" +
                    "where id = ?";

            PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

            stmt.setString(1, hero.getFirstName());
            stmt.setString(2, hero.getLastName());
            stmt.setString(3, hero.getLastName());
            stmt.setInt(4, hero.getId());

            success = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success == 1;
    }

    public boolean delete(int id) {
        int success = 0;

        try{

            String sql = "DELETE from users where user_id = " + id;

            Statement stmt = ConnectionFactory.getConnection().createStatement();
            success = stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success == 1;
    }
}
