package org.its.dl.count;

public interface MeetingCountDL {

    void incrementAppuntamenti(int idUtente);

    void decrementAppuntamenti(int idUtente);

    int getAppuntamenti(int idUtente);
}
