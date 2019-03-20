package org.its.dl.dataaccess;

import org.its.dl.entity.AppuntamentoDL;

import java.util.List;

public interface MeetingDL {

    public List<AppuntamentoDL> getAll();

    public List<AppuntamentoDL> getByIdUtente(int idUtente);

    public AppuntamentoDL add(AppuntamentoDL appuntamentoDL);

    public boolean removeByIdAppuntamento(int idAppuntamento);

    public boolean updateByIdAppuntamento(int idAppuntamento, AppuntamentoDL appuntamentoDL);
}
