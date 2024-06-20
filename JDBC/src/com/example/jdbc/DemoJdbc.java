package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJdbc {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "lenovo123"; // Replace with your actual MySQL root password

        // Query to be executed
        String query = "SELECT id,name,sal FROM emp";

        try {
            // 1. Load and register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            Connection con = DriverManager.getConnection(url, username, password);

            // 3. Create a statement
            Statement stmt = con.createStatement();

            // 4. Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // 5. Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int salary = rs.getInt("sal");
                System.out.println(id + " " +name + " "+ salary);
            }

            // 6. Close the result set, statement, and connection
            rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Handle error for Class.forName
        } catch (SQLException e) {
            e.printStackTrace(); // Handle errors for JDBC
        }
    }
}
