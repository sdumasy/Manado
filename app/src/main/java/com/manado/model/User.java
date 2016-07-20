package com.manado.model;

import java.util.ArrayList;

/**
 * Created by macbookpro on 13-07-16.
 */

public class User {
    private String id;
    private String username;
    private String email;
    private float saldo;
    private String houseId;

    public User(String username, String email, float saldo) {
        this.username = username;
        this.email = email;
        this.saldo = saldo;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
