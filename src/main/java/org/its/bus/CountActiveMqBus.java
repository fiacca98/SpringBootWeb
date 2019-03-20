package org.its.bus;

import org.its.bl.UtenteMessage;
import org.its.bl.count.CountBLImpl;
import org.its.dl.count.CountDL;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named("countBL")
@Component
public class CountActiveMqBus extends CountBLImpl {

    public CountActiveMqBus(@Named("countDL")CountDL dataLayer,
                            @Named("bus")Bus bus) {
        super(dataLayer, bus);
    }

    @JmsListener(
            destination = "queue",
            containerFactory = "queueListenerFactory",
            selector = "classtype = 'UtenteMessage'")
    public void handle(UtenteMessage message) throws Exception {
        System.out.println("Handle esterno");
        super.handle(message);
    }
}
