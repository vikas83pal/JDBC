package com.example.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DeleteRecord {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/company";
		String username = "root";
		String password = "lenovo123";
		String query = "delete from emp where id=5";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			int deletedRow = stmt.executeUpdate(query);
			if(deletedRow > 0) {
				System.out.println("Rows are deleted");
			}
			
			con.close();
			stmt.close();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
