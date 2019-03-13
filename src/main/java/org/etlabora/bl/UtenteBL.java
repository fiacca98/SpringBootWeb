package org.etlabora.bl;

import org.etlabora.dl.UtenteDL;
import org.etlabora.pl.Utente;

import java.util.List;

public interface UtenteBL {

    List<UtenteBO> getAll();
    UtenteBO getUser(int id);
    UtenteBO insertUser(UtenteBO utenteBO);
    UtenteBO updateUser(UtenteBO utenteBO);
    UtenteBO deleteUser(UtenteBO utenteBO);
}
