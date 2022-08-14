package com.itvdn.jdbcandhibernate.ex001_get_db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//получение Connection
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/carsshop?useSSL=false";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            if(!connection.isClosed()) {
                System.out.println("Correct connection to DB!");
            }
            connection.close();
            if(connection.isClosed()) {
                System.out.println("Connection closed :(");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}