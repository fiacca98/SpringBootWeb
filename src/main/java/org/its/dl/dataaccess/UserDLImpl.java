package org.its.dl.dataaccess;

import org.its.dl.entity.UtenteDL;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Named("userDl2")
public class UserDLImpl implements UserDL {


    HashMap<Integer, UtenteDL> listaUtenteDL = new HashMap<Integer, UtenteDL>();

    int maxId = 1;

    @Override
    public List<UtenteDL> getAll() {
        return new ArrayList<UtenteDL>(listaUtenteDL.values());
    }

    public UtenteDL add(UtenteDL utenteDL) {
        utenteDL.setId(maxId);
        maxId ++;
        listaUtenteDL.put(utenteDL.getId(),utenteDL);
        return utenteDL;

    }

    @Override
    public boolean delete(Integer id) {

       if(!listaUtenteDL.containsKey(id))
           return false;

       listaUtenteDL.remove(id);
       return true;

    }

    @Override
    public boolean update(UtenteDL utenteDL) throws Exception {
        if(!listaUtenteDL.containsKey(utenteDL.getId()))
            throw new Exception("Utente non esistente");
        UtenteDL oldUser = listaUtenteDL.get(utenteDL.getId());
        if(utenteDL.getName().equals(oldUser.getName())
                && utenteDL.isEnabled() == oldUser.isEnabled())
            return false;
        else{
            listaUtenteDL.put(utenteDL.getId(),utenteDL);
            return true;
        }
    }

    @Override
    public UtenteDL getById(Integer id) {
        return null;
    }


}

