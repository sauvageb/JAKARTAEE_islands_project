package com.example.demo.dao.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class EMFManager {

    private static EntityManagerFactory EMF;

    private EMFManager() {
    }

    public static EntityManagerFactory getEMF() {
        if (EMF == null) {
            EMF = Persistence.createEntityManagerFactory("PU");
        }
        return EMF;
    }

    public static void close() {
        if (EMF != null && EMF.isOpen()) {
            EMF.close();
        }
    }


}
