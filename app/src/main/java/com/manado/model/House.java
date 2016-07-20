package com.manado.model;

import java.util.ArrayList;

/**
 * Created by macbookpro on 13-07-16.
 */
public class House {
    String houseId;


    ArrayList<String> userIds;
    String houseName;
    String houseAddres;

    public String getHouseAddres() {
        return houseAddres;
    }

    public void setHouseAddres(String houseAddres) {
        this.houseAddres = houseAddres;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }


    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public ArrayList<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(ArrayList<String> userIds) {
        this.userIds = userIds;
    }
}
