package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    private static final String URL = "jdbc:mysql://localhost:8889/islands";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection CONNECTION_SINGLETON = null;

    private ConnectionManager() {
        // avoid instantiation
    }

    public static Connection getConnection() {
        if (CONNECTION_SINGLETON == null) {
            try {
                loadDriver();
                CONNECTION_SINGLETON = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Connexion impossible");
            }
        }
        return CONNECTION_SINGLETON;
    }

    public static void closeConnection() {
        try {
            CONNECTION_SINGLETON.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void loadDriver() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            System.err.println("Driver Mysql introuvable");
        }
    }
}
