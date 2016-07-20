package com.manado.model;

/**
 * Created by macbookpro on 20-07-16.
 */
public class Invitation {
    private String houseName;
    private String recUserName;
    private String sendUserName;
    private String date;

    public Invitation(String houseName, String recUserName, String sendUserName, String date) {
        this.houseName = houseName;
        this.recUserName = recUserName;
        this.sendUserName = sendUserName;
        this.date = date;
    }

    public String getHouseName() {

        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getRecUserName() {
        return recUserName;
    }

    public void setRecUserName(String recUserName) {
        this.recUserName = recUserName;
    }

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
