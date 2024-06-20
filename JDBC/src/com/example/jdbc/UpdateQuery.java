package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateQuery {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "lenovo123";
        String query = "UPDATE emp SET sal=7000 WHERE id=1";

        

        try {
            // Load and register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement stmt = con.createStatement();

            // Execute the update query
            int updateRow = stmt.executeUpdate(query);

            // Check if any rows were updated
            if (updateRow > 0) {
                System.out.println("Rows are updated");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Handle error for Class.forName
        } catch (SQLException e) {
            e.printStackTrace(); // Handle errors for JDBC
        } 
    }
}
