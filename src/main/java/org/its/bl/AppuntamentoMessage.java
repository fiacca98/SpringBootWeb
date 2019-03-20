package org.its.bl;

import org.its.bus.BusMessage;

public class AppuntamentoMessage implements BusMessage {

    private boolean added;
    private int idUtente;

    public AppuntamentoMessage(boolean added, int idUtente) {
        this.added = added;
        this.idUtente = idUtente;
    }

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public int getIdUtente(){return this.idUtente;}
}
