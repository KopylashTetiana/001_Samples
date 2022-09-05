package com.itvdn.jdbcandhibernate.HomeTask1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/HomeTask1?autoReconnect=true&useSSL=false";
    private static final String login = "root";
    private static final String password = "root";
    private static final String insertNew = "INSERT INTO Towels (Colour, length, width, count) VALUES (?, ?, ?, ?)";

    public DBWorker() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success.");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver.");
            e.printStackTrace();
        }
    }

    public List<Towel> getAllTowels() {
        Connection connection = null;
        Statement statement = null;
        List<Towel> towels = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, login, password);
            statement = connection.createStatement(); //Static statement
            //statement.execute("ALTER TABLE Towels ADD Count INT DEFAULT 1;");
            statement.execute("ALTER TABLE Towels DROP CONSTRAINT UniqColour;");
            statement.execute("ALTER TABLE Towels ADD CONSTRAINT UniqColour UNIQUE(Colour);");
            System.out.println("Add property 'Unique' to the field 'Colour'.");
            int res = statement.executeUpdate("UPDATE Towels SET count = count + 1  WHERE Colour >= 'white'");
            System.out.println(res);
            statement.addBatch("INSERT INTO Towels (Colour, length, width, count) VALUES ('Grey', 75, 35, 3)");
            statement.addBatch("INSERT INTO Towels (Colour, length, width, count) VALUES ('Red', 75, 35, 1)");
            statement.addBatch("INSERT INTO Towels (Colour, length, width, count) VALUES ('Yellow', 100, 45, 1)");
            statement.executeBatch();
            System.out.println("Add new towels");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Towels;");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String colour = resultSet.getString("Colour");
                int length = resultSet.getInt("Length");
                int width = resultSet.getInt("Width");
                int count = resultSet.getInt("Count");
                Towel tow = new Towel(id, colour, length, width, count);
                towels.add(tow);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return towels;
    }

    public void addTowel(Towel tow) { //this method adds new towel to the table Towels using PreparedStatement
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, login, password);
            statement = connection.prepareStatement(insertNew);
            statement.setString(1, tow.getColour());
            statement.setInt(2, tow.getLength());
            statement.setInt(3, tow.getWidth());
            statement.setInt(4, tow.getCount());
            statement.execute();
            System.out.println("Towel added.");

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
