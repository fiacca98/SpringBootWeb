package org.its.dl.dataaccess;

import org.its.dl.entity.AppuntamentoDL;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Named("meetingDL")
public class MeetingDLDAOImpl implements MeetingDL {
    @Override
    public List<AppuntamentoDL> getAll() {
        EntityManager em = Em.createEntityManager();
        Query query = em.createQuery("SELECT a FROM AppuntamentoDL a");
        List<AppuntamentoDL> appuntamentoDLS = query.getResultList();
        return appuntamentoDLS;
    }

    @Override
    public List<AppuntamentoDL> getByIdUtente(int idUtente) {
        return null;
    }

    @Override
    public AppuntamentoDL add(AppuntamentoDL appuntamentoDL) {
        return null;
    }

    @Override
    public boolean removeByIdAppuntamento(int idAppuntamento) {
        return false;
    }

    @Override
    public boolean updateByIdAppuntamento(int idAppuntamento, AppuntamentoDL appuntamentoDL) {
        return false;
    }
}
