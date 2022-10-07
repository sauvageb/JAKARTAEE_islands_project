package com.example.demo.dao.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class ConnectionManager {

    private static Connection CONNECTION_SINGLETON = null;

    private ConnectionManager() {
        // avoid instantiation
    }

    public static Connection getConnection() {
        if (CONNECTION_SINGLETON == null) {
            try {
                loadDriver();
                InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("dbconfig.properties");
                Properties properties = new Properties();
                properties.load(inputStream);

                CONNECTION_SINGLETON = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.username"), properties.getProperty("db.password"));
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Connexion impossible");
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("dbconfig.properties introuvable");
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
