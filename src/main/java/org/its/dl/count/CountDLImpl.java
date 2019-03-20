package org.its.dl.count;

import javax.inject.Named;

@Named("countDL")
public class CountDLImpl implements CountDL {

    private int enabled = 0;

    @Override
    public void incrementEnabled() {
        enabled++;
    }

    @Override
    public void decrementEnabled() {
        enabled--;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
