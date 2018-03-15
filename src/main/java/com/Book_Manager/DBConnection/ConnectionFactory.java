package com.Book_Manager.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/book";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection conn = null;

    public Connection getConnection()  {
        try{
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return conn;
        }catch (SQLException e){
            throw new RuntimeException("Error connecting to the database" ,e);
        }
    }
}

