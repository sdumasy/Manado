package com.manado.model;

import java.util.ArrayList;

/**
 * Created by macbookpro on 13-07-16.
 */
public class House {
    ArrayList<User> users;
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
}
