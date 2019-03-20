package org.its.bl;

import org.its.bl.entity.AppuntamentoBL;
import org.its.bl.entity.UtenteBO;
import org.its.dl.entity.AppuntamentoDL;
import org.its.dl.entity.UtenteDL;

public class BOConverterService {

    public UtenteDL convertToUtenteDL(UtenteBO utenteBO){
        UtenteDL utenteDL = new UtenteDL(utenteBO.getId(), utenteBO.getName(),utenteBO.isEnabled());
        return  utenteDL;
    }

    public UtenteBO convertToUtenteBO(UtenteDL utenteDL){
        UtenteBO utenteBO = new UtenteBO(utenteDL.getId(), utenteDL.getName(), utenteDL.isEnabled());
        return  utenteBO;
    }

    public AppuntamentoBL convertToAppuntamentoBL(AppuntamentoDL appuntamentoDL){
        AppuntamentoBL appuntamentoBL = new AppuntamentoBL(appuntamentoDL.getId(),appuntamentoDL.getIdUtente(),appuntamentoDL.getDataInizio(),
                appuntamentoDL.getDataFine(),appuntamentoDL.getIdUtenteToMeet());
        return appuntamentoBL;
    }

    public AppuntamentoDL convertToAppuntamentoDL(AppuntamentoBL appuntamentoBL){
        AppuntamentoDL appuntamentoDL = new AppuntamentoDL(appuntamentoBL.getId(),appuntamentoBL.getIdUtente(),appuntamentoBL.getDataInizio(),
                appuntamentoBL.getDataFine(),appuntamentoBL.getIdUtenteToMeet());
        return appuntamentoDL;
    }
}
