package org.its.dl.count;

import javax.inject.Named;
import java.util.HashMap;

@Named("meetingCountDL")
public class MeetingCountDLImpl implements MeetingCountDL {

    HashMap<Integer, Integer> appuntamenti = new HashMap<>();

    @Override
    public void incrementAppuntamenti(int idUtente) {
        Integer count = appuntamenti.get(idUtente);
        if(count != null )
            appuntamenti.replace(idUtente,count++);
        else{
            appuntamenti.put(idUtente,1);
        }
    }

    @Override
    public void decrementAppuntamenti(int idUtente) {
        appuntamenti.replace(idUtente,appuntamenti.get(idUtente)-1);
    }

    @Override
    public int getAppuntamenti(int idUtente) {
        return appuntamenti.get(idUtente);
    }


}
