package com.manado.controllers;

import com.manado.http.ManadoApiClient;
import com.manado.http.UserService;
import com.manado.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by macbookpro on 15-07-16.
 */
public class UserController {

    public static void getUserData(Callback<ArrayList<User>> callback) {

        UserService request = ManadoApiClient.retrofit.create(UserService.class);
        Call<ArrayList<User>> call = request.getUserData();
        call.enqueue(callback);
    }


}
