package com.example.demo.dao;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static IslandDAO getIslandDAO() {
//        return new MemoryIslandDAO();
        return new JdbcIslandDAO();
    }
}
