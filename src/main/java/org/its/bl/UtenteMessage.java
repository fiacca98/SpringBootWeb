package org.its.bl;

import org.its.bus.BusMessage;

public class UtenteMessage implements BusMessage {

    public UtenteMessage() {

    }

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


}
