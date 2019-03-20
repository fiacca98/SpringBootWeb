package org.its.bl.dataaccess;

import org.its.bl.entity.UtenteBO;

import java.util.List;

public interface UserBL {
    List<UtenteBO> getAll();

    UtenteBO getById(String id);

    UtenteBO add(UtenteBO utenteBO);

    boolean delete(String id);

    UtenteBO modificaUtente(UtenteBO utenteBO, String id);

    void abilitaUtente(String id) throws Exception;

    void disabilitaUtente(String id) throws Exception;

}
