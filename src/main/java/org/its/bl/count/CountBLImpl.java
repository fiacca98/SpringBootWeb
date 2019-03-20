package org.its.bl.count;

import org.its.bl.UtenteMessage;
import org.its.bus.Bus;
import org.its.bus.BusMessage;
import org.its.dl.count.CountDL;

import javax.inject.Named;


public class CountBLImpl implements CountBL {

    private final CountDL dataLayer;

    public CountBLImpl(@Named("countDL")CountDL dataLayer,
                       @Named("bus")Bus bus){
        this.dataLayer = dataLayer;
        bus.register(UtenteMessage.class,this);
    }

    @Override
    public int countEnabled(){return dataLayer.getEnabled();}

    @Override
    public void handle(BusMessage message) throws Exception {
        System.out.println("Handle interno");
        UtenteMessage umsg =(UtenteMessage)message;
        if(umsg.isEnabled())
            dataLayer.incrementEnabled();
        else
            dataLayer.decrementEnabled();
    }
}
