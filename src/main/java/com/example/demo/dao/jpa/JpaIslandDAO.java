package com.example.demo.dao.jpa;

import com.example.demo.dao.IslandDAO;
import com.example.demo.model.Island;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class JpaIslandDAO implements IslandDAO {
    @Override
    public List<Island> findAll() {
        return null;
    }

    @Override
    public boolean create(Island island) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(island);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public Optional<Island> findById(long idParam) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean edit(Island islandToEdit) {
        return false;
    }
}
