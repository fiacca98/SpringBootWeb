package org.its.dl.dataaccess;

import org.its.dl.entity.AppuntamentoDL;
import org.its.dl.entity.UtenteDL;

import javax.inject.Named;
import java.util.*;

@Named("meetingDL")
public class MeetingDLImpl implements MeetingDL {

    HashMap<Integer, AppuntamentoDL> listaAppuntamentoDL = new HashMap<Integer, AppuntamentoDL>();

    int maxId = 1;

    @Override
    public List<AppuntamentoDL> getAll() {
        return new ArrayList<AppuntamentoDL>(listaAppuntamentoDL.values());
    }

    @Override
    public List<AppuntamentoDL> getByIdUtente(int idUtente) {
        List<AppuntamentoDL> meetingWithId = new ArrayList<AppuntamentoDL>();
        for(AppuntamentoDL meeting : listaAppuntamentoDL.values()){
            if(meeting.getIdUtente() == idUtente)
                meetingWithId.add(meeting);
        }
        return new ArrayList<AppuntamentoDL>(listaAppuntamentoDL.values());
    }

    @Override
    public AppuntamentoDL add(AppuntamentoDL appuntamentoDL) {
        appuntamentoDL.setId(maxId);
        maxId ++;
        listaAppuntamentoDL.put(appuntamentoDL.getId(),appuntamentoDL);
        return appuntamentoDL;
    }

    @Override
    public boolean removeByIdAppuntamento(int idAppuntamento){
        Iterator it = listaAppuntamentoDL.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer,AppuntamentoDL> pair = (Map.Entry)it.next();
            if (pair.getValue().getId() == idAppuntamento)
                listaAppuntamentoDL.remove(pair.getKey());
            it.remove();
        }
        return true;
    }

    @Override
    public boolean updateByIdAppuntamento(int idAppuntamento, AppuntamentoDL appuntamentoDL){
        Iterator it = listaAppuntamentoDL.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer,AppuntamentoDL> pair = (Map.Entry)it.next();
            if (pair.getKey() == idAppuntamento)
                listaAppuntamentoDL.replace(pair.getKey(),appuntamentoDL);
            it.remove();
        }
        return true;
    }

}
