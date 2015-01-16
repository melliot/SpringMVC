package com.spring.alexis;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class ConnectToDB {
    private static final String URL = "jdbc:mysql://localhost:3306/javatest";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = connection.createStatement()){

            ResultSet set = statement.executeQuery("SELECT *  FROM javatest.users;");

            while (set.next()){
                System.out.println(set.getString("name"));
            }
        }
        catch (SQLException e){
            System.out.println(e.getStackTrace() + "bla bla");
        }
    }
}
