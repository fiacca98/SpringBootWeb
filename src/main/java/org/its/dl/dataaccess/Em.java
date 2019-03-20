package org.its.dl.dataaccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Em {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager createEntityManager() {

        if(entityManagerFactory == null)
        {
            entityManagerFactory = Persistence.createEntityManagerFactory("Utenti");
        }
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager(EntityManager em) {
     em.close();

    }
    public static void closeEntityManagerFactory() {
        if(entityManagerFactory != null) entityManagerFactory.close();
    }

}
