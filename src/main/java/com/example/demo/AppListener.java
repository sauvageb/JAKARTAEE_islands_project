package com.example.demo;

import com.example.demo.dao.jdbc.ConnectionManager;
import com.example.demo.dao.jpa.EMFManager;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("--------------- APP INITIALIZED ---------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("--------------- APP DESTROYED ---------------");
        ConnectionManager.closeConnection();
        EMFManager.close();
    }
}
