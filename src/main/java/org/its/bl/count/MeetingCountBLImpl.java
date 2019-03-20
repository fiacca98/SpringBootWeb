package org.its.bl.count;

import org.its.bl.AppuntamentoMessage;
import org.its.bl.UtenteMessage;
import org.its.bus.Bus;
import org.its.bus.BusMessage;
import org.its.dl.count.CountDL;
import org.its.dl.count.MeetingCountDL;

import javax.inject.Named;

@Named("meetingCountBL")
public class MeetingCountBLImpl implements MeetingCountBL {
    private final MeetingCountDL dataLayer;

    public MeetingCountBLImpl(
            @Named("meetingCountDL")MeetingCountDL dataLayer,
                       @Named("bus") Bus bus){
        this.dataLayer = dataLayer;
        bus.register(AppuntamentoMessage.class,this);
    }

    @Override
    public int countAppuntamenti(int idUtente){return dataLayer.getAppuntamenti(idUtente);}

    @Override
    public void handle(BusMessage message) throws Exception {
        AppuntamentoMessage amsg =(AppuntamentoMessage)message;
        if(amsg.isAdded())
            dataLayer.incrementAppuntamenti(amsg.getIdUtente());
        else
            dataLayer.decrementAppuntamenti(amsg.getIdUtente());
    }
}
