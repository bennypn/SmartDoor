package com.example.smartdoor;

public class User {
    String rfid;
    Integer fpID;

    public User() {
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public Integer getFpID() {
        return fpID;
    }

    public void setFpID(Integer fpID) {
        this.fpID = fpID;
    }
}
