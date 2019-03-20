package org.its.dl.dataaccess;

import org.its.dl.entity.UtenteDL;
import org.its.pl.entity.Utente;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Named("userDl")
public class UserDLDAOImpl implements UserDL {
    @Override
    public List<UtenteDL> getAll() {
        EntityManager em = Em.createEntityManager();
        Query query = em.createQuery("SELECT u FROM UtenteDL u");
        List<UtenteDL> utentiDL = query.getResultList();
        return utentiDL;
    }

    @Override
    public UtenteDL add(UtenteDL utenteDL) {
        utenteDL.setId(null);
        EntityManager em = Em.createEntityManager();
        em.getTransaction().begin();
        em.persist(utenteDL);
        em.getTransaction().commit();
        return utenteDL;
    }

    @Override
    public boolean delete(Integer id) {
        EntityManager em = Em.createEntityManager();

        UtenteDL utenteDL = this.getById(id);
        em.getTransaction().begin();
        em.remove(utenteDL);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(UtenteDL utenteDL) throws Exception {
        UtenteDL userDB = this.getById(utenteDL.getId());

        userDB.setName(utenteDL.getName());
        userDB.setEnabled(utenteDL.isEnabled());
        EntityManager em = Em.createEntityManager();
        em.getTransaction().begin();
        em.merge(utenteDL);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public UtenteDL getById(Integer id) {
        EntityManager em = Em.createEntityManager();
        Query query = em.createQuery("SELECT u from UtenteDL u WHERE u.id = :id");
        query.setParameter("id", id);
        UtenteDL utenteDL = (UtenteDL) query.getSingleResult();
        return utenteDL;
    }
}
