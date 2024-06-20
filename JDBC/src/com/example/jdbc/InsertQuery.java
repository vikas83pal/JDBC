package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "lenovo123";
        String query = "INSERT INTO emp (id, name, sal) VALUES (5, 'vikas', 5000)";

        try {
            // Load and register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement stmt = con.createStatement();

            // Execute the insert query
            int rowsAffected = stmt.executeUpdate(query);

            // Process the result (if needed)
//            if (rowsAffected > 0) {
//                System.out.println("Record inserted successfully.");
//            }

            // Close the statement and connection
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Handle error for Class.forName
        } catch (SQLException e) {
            e.printStackTrace(); // Handle errors for JDBC
        }
    }
}
