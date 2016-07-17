package com.manado.model;

import com.manado.model.user.User;

import java.util.ArrayList;

/**
 * Created by macbookpro on 13-07-16.
 */
public class Transaction {
    private int amount;
    private String date;
    private User owner;
    private House house;
    private ArrayList<User> participants;
}
