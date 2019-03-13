package org.etlabora.bl;

import org.etlabora.conversionutility.BODLConversion;
import org.etlabora.dl.UtenteDL;
import org.etlabora.dl.UtenteDLImpl;
import org.etlabora.dl.UtenteDLO;
import org.etlabora.pl.Utente;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("utenteBL")
public class UtenteBOImpl implements UtenteBL {

    UtenteDL dao = new UtenteDLImpl();

    @Override
    public List<UtenteBO> getAll() {

        List<UtenteDLO> utentiDL = dao.getAll();

        List<UtenteBO> utentiBO = new ArrayList<UtenteBO>();

        for(UtenteDLO user : utentiDL){
            utentiBO.add(BODLConversion.fromUtenteDLOToUtenteBO(user));
        }

        return utentiBO;
    }

    @Override
    public UtenteBO getUser(int id) {
        UtenteDLO utenteDLO = dao.getUser(id);
        return utenteDLO != null
                ? BODLConversion.fromUtenteDLOToUtenteBO(utenteDLO)
                : null;
    }

    @Override
    public UtenteBO insertUser(UtenteBO utenteBO) {
        UtenteDLO utenteDLO = dao.insertUser(BODLConversion.fromUtenteBoToUtenteDLO(utenteBO));
        return utenteDLO != null
                ? BODLConversion.fromUtenteDLOToUtenteBO(utenteDLO)
                : null;
    }

    @Override
    public UtenteBO updateUser(UtenteBO utenteBO) {
        UtenteDLO utenteDLO = dao.updateUser(BODLConversion.fromUtenteBoToUtenteDLO(utenteBO));
        return utenteDLO != null
                ? BODLConversion.fromUtenteDLOToUtenteBO(utenteDLO)
                : null;
    }

    @Override
    public UtenteBO deleteUser(UtenteBO utenteBO) {
        UtenteDLO utenteDLO = dao.deleteUser(BODLConversion.fromUtenteBoToUtenteDLO(utenteBO));
        return utenteDLO != null
                ? BODLConversion.fromUtenteDLOToUtenteBO(utenteDLO)
                : null;
    }
}
