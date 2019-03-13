package org.etlabora.dl;

import java.util.ArrayList;
import java.util.List;

public class UtenteDLImpl implements UtenteDL {

    List<UtenteDLO> utenti = new ArrayList<UtenteDLO>();

    int nextID = 0;

    @Override
    public List<UtenteDLO> getAll() {
        return utenti;
    }

    @Override
    public UtenteDLO getUser(int id) {
        for(UtenteDLO user : utenti) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public UtenteDLO insertUser(UtenteDLO utenteDLO) {
        if (utenteDLO != null && validateUtente(utenteDLO) ){
            utenteDLO.setId(generateID());
            utenti.add(utenteDLO);
            return utenteDLO;
        }
        else
            return null;
    }

    private int generateID(){
        int toReturn = nextID;
        nextID ++;
        return toReturn;
    }

    private boolean validateUtente(UtenteDLO utenteDLO){
        if(utenteDLO.getName().length() <= 2)
            return false;
        else if(utenteDLO.getName().toLowerCase().contains("test"))
            return false;
        else
            return true;
    }

    @Override
    public UtenteDLO updateUser(UtenteDLO utenteDLO) {
        for(UtenteDLO user : utenti) {
            if(user.getId() == utenteDLO.getId()){
                user = utenteDLO;
                return utenteDLO;
            }
        }
        return null;
    }

    @Override
    public UtenteDLO deleteUser(UtenteDLO utenteDLO) {
        boolean res = utenti.remove(utenteDLO);
        return res ? utenteDLO : null;
    }
}
