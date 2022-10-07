package com.example.demo.dao;

import com.example.demo.dao.jpa.JpaCountryDAO;
import com.example.demo.dao.jpa.JpaIslandDAO;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static IslandDAO getIslandDAO() {
//        return new MemoryIslandDAO();
//        return new JdbcIslandDAO();
        return new JpaIslandDAO();
    }

    public static CountryDAO getCountryDAO() {
        return new JpaCountryDAO();
    }
}
