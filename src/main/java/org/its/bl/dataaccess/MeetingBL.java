package org.its.bl.dataaccess;

import org.its.bl.entity.AppuntamentoBL;
import org.its.dl.entity.AppuntamentoDL;

import java.util.List;

public interface MeetingBL {

    public List<AppuntamentoBL> getAll();

    public List<AppuntamentoBL> getByIdUtente(int idUtente);

    public AppuntamentoBL add(AppuntamentoBL appuntamentoBL);

    public boolean removeByIdAppuntamento(int idAppuntamentod);

    public boolean updateByIdAppuntamento(int idAppuntamento, AppuntamentoBL appuntamentoBL);
}
