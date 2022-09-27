package com.example.demo.dao;

import com.example.demo.model.Island;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcIslandDAO implements IslandDAO {

    @Override
    public List<Island> findAll() {
        List<Island> islandList = new ArrayList<>();

        Connection connection = ConnectionManager.getConnection();
        String query = "SELECT * FROM island";

        try (Statement st = connection.createStatement()) {

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Island island = mapResulSetToIsland(rs);
                islandList.add(island);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return islandList;
    }

    @Override
    public boolean create(Island island) {
        Connection connection = ConnectionManager.getConnection();

        String query = "INSERT INTO island VALUES(null, ?,?,?,?,?,?,?)";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, island.getName());
            pst.setString(2, island.getPictureUrl());
            pst.setDouble(3, island.getSurface());
            pst.setDouble(4, island.getInhabitants());
            pst.setDouble(5, island.getLatitude());
            pst.setDouble(6, island.getLongitude());
            pst.setString(7, island.getCountry());
            return pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<Island> findById(long idParam) {
        Connection connection = ConnectionManager.getConnection();
        String query = "SELECT * FROM island WHERE id=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setLong(1, idParam);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Island island = mapResulSetToIsland(rs);
                return Optional.of(island);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Island mapResulSetToIsland(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        String pictureUrl = rs.getString("picture_url");
        double surface = rs.getDouble("surface");
        long inhabitants = rs.getLong("inhabitants");
        double latitude = rs.getDouble("latitude");
        double longitude = rs.getDouble("longitude");
        String country = rs.getString("country");
        return new Island(id, name, pictureUrl, surface, inhabitants, latitude, longitude, country);
    }

    @Override
    public boolean delete(long id) {
        Connection connection = ConnectionManager.getConnection();
        String query = "DELETE FROM island WHERE id= ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setLong(1, id);
            return pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Island island) {
        Connection connection = ConnectionManager.getConnection();
        String query = "UPDATE island SET name=?, picture_url=?, surface=?, inhabitants=?, latitude=?, longitude=?, country=? WHERE id=?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, island.getName());
            pst.setString(2, island.getPictureUrl());
            pst.setDouble(3, island.getSurface());
            pst.setDouble(4, island.getInhabitants());
            pst.setDouble(5, island.getLatitude());
            pst.setDouble(6, island.getLongitude());
            pst.setString(7, island.getCountry());
            pst.setLong(8, island.getId());

            return pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}

