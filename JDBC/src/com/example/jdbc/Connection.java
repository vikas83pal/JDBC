package com.example.jdbc;

public interface Connection {

	Statement createStatement();

	void close();


}
