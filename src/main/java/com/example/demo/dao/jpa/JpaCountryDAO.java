package com.example.demo.dao.jpa;

import com.example.demo.dao.CountryDAO;
import com.example.demo.dao.entity.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaCountryDAO implements CountryDAO {

    @Override
    public List<Country> findAll() {
        List<Country> countryList = new ArrayList<>();
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        try {
            countryList = em.createQuery("SELECT c FROM Country c", Country.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return countryList;
    }

    @Override
    public boolean create(Country country) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(country);
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
    public Optional<Country> findById(long idParam) {
        Country country = null;
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        try {
            country = em.find(Country.class, idParam);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.ofNullable(country);
    }

    @Override
    public boolean delete(long id) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Country country = em.find(Country.class, id);
            em.remove(country);
            et.commit();
            return true;
        } catch (RuntimeException e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean edit(Country countryToEdit) {
        EntityManagerFactory emf = EMFManager.getEMF();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(countryToEdit);
            et.commit();
            return true;
        } catch (RuntimeException e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return false;
    }
}
