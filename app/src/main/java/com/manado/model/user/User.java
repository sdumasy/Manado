package com.manado.model.user;

import java.util.ArrayList;

/**
 * Created by macbookpro on 13-07-16.
 */

public class User {
    String type;
    int id;
    UserAttribute attributes;

    public UserAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(UserAttribute attributes) {
        this.attributes = attributes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
