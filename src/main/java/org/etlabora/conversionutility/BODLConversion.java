package org.etlabora.conversionutility;

import org.etlabora.bl.UtenteBO;
import org.etlabora.dl.UtenteDLO;

public class BODLConversion {

    public static UtenteDLO fromUtenteBoToUtenteDLO(UtenteBO utenteBO){
        UtenteDLO utente = new UtenteDLO();

        utente.setId(utenteBO.getId());
        utente.setName(utenteBO.getName());
        return utente;
    }

    public static UtenteBO fromUtenteDLOToUtenteBO(UtenteDLO utenteDLO){
        UtenteBO utente = new UtenteBO();
        utente.setId(utenteDLO.getId());
        utente.setName(utenteDLO.getName());
        return utente;
    }

}
