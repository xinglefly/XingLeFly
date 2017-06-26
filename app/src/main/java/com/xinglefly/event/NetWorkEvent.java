package com.xinglefly.event;


public class NetWorkEvent {

    private boolean isNetwork;

    public boolean isNetwork() {
        return isNetwork;
    }

    public void setIsNetwork(boolean isNetwork) {
        this.isNetwork = isNetwork;
    }

    public NetWorkEvent(boolean isNetwork) {
        this.isNetwork = isNetwork;
    }
}
