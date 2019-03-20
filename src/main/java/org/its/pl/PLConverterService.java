package org.its.pl;

import org.its.bl.entity.AppuntamentoBL;
import org.its.bl.entity.UtenteBO;
import org.its.pl.entity.Appuntamento;
import org.its.pl.entity.Utente;

public class PLConverterService {

    public Utente convertToUtente(UtenteBO utenteBO) throws Exception{
        Utente utente = new Utente(utenteBO.getId(), utenteBO.getName());
        return  utente;
    }

    public UtenteBO convertToUtenteBO(Utente utente){
        UtenteBO utenteBO = new UtenteBO(utente.getId(), utente.getName(), false);
        return  utenteBO;
    }

    public Appuntamento convertToAppuntamento(AppuntamentoBL appuntamentoBL){
        Appuntamento appuntamento = new Appuntamento(appuntamentoBL.getId(),appuntamentoBL.getIdUtente(),appuntamentoBL.getDataInizio(),
                appuntamentoBL.getDataFine(),appuntamentoBL.getIdUtenteToMeet());
        return appuntamento;
    }

    public AppuntamentoBL convertToAppuntamentoBL(Appuntamento appuntamento){
        AppuntamentoBL appuntamentoBL = new AppuntamentoBL(appuntamento.getId(),appuntamento.getIdUtente(),appuntamento.getDataInizio(),
                appuntamento.getDataFine(),appuntamento.getIdUtenteToMeet());
        return appuntamentoBL;
    }
}
