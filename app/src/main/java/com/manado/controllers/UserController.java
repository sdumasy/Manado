package com.manado.controllers;

import android.util.Log;

import com.manado.http.ManadoApiClient;
import com.manado.http.UserService;
import com.manado.model.User;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by macbookpro on 15-07-16.
 */
public class UserController {

    public static void getUser(Callback<User> callback) {

        UserService request = ManadoApiClient.retrofit.create(UserService.class);
        Call<User> call = request.getUser();
        call.enqueue(callback);
    }

    public static void hey() {
        Log.v("dddddddddaaaaa", "gggggg");
    }

}
