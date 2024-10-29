package com.javaweb.mvc.repositories.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/c0324h1_web?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "Ngoc2507";
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public BaseRepository() {
    }

    public static Connection getConnection() {
        return connection;
    }

}