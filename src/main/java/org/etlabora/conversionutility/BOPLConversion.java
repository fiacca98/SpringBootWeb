package org.etlabora.conversionutility;

import org.etlabora.bl.UtenteBO;
import org.etlabora.pl.Utente;

public class BOPLConversion {

    public static UtenteBO fromUtenteToUtenteBO(Utente utente){
        UtenteBO utenteBO = new UtenteBO();
        utenteBO.setId(utente.getId());
        utenteBO.setName(utente.getName());
        return utenteBO;
    }

    public static Utente fromUtenteBOToUtente(UtenteBO utenteBO){
        Utente utente = new Utente();
        utente.setId(utenteBO.getId());
        utente.setName(utenteBO.getName());
        return utente;
    }

}
