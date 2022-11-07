package com.example.smartdoor;

public class History {
    private String User;
    private long Epoch;

    public History() {
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public long getEpoch() {
        return Epoch;
    }

    public void setEpoch(long epoch) {
        Epoch = epoch;
    }
}
