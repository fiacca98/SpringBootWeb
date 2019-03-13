package org.etlabora.dl;

import java.util.List;

public interface UtenteDL {

    List<UtenteDLO> getAll();
    UtenteDLO getUser(int id);
    UtenteDLO insertUser(UtenteDLO utenteDLO);
    UtenteDLO updateUser(UtenteDLO utenteDLO);
    UtenteDLO deleteUser(UtenteDLO utenteDLO);
}
