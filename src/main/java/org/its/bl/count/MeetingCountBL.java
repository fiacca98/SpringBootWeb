package org.its.bl.count;

import org.its.bus.MessageConsumer;

public interface MeetingCountBL extends MessageConsumer {
    public int countAppuntamenti(int idUtente);
}
