package com.itvdn.jdbcandhibernate.ex004_prepared_statement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

/**
 * Created by Asus on 09.10.2017.
 */
public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/carsshop?useSSL=false";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW = "INSERT INTO dish(title, description, rating, published, created, icon) "
                                            + " VALUES(?,?,?,?,?,?)";
    //Question marks mean that we add values instead of '?' using methods.
    public static void main(String[] args) {
        registerDriver();


        Connection connection = null;
        PreparedStatement statement = null;


        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(INSERT_NEW);

            statement.setString(1, "Title");
            statement.setString(2, "Description");
            statement.setDouble(3, 4.5);
            statement.setBoolean(4, false);
            statement.setDate(5, new Date(Calendar.getInstance().getTimeInMillis()));
            statement.setBlob(6, new FileInputStream("chair.png"));

            statement.execute();

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }  finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
