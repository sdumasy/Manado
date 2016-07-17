package com.manado.controllers;

import android.util.Log;

import com.manado.http.ManadoApiClient;
import com.manado.http.UserDataService;
import com.manado.model.User;
import com.manado.model.UserData;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by macbookpro on 15-07-16.
 */
public class UserController {

    public static void getUserData(Callback<UserData> callback) {

        UserDataService request = ManadoApiClient.retrofit.create(UserDataService.class);
        Call<UserData> call = request.getUserData();
        call.enqueue(callback);
    }

    public static void hey() {
        Log.v("dddddddddaaaaa", "gggggg");
    }

}
