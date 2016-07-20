package com.manado.controllers;

import com.manado.http.HouseService;
import com.manado.http.ManadoApiClient;
import com.manado.http.UserService;
import com.manado.model.House;
import com.manado.model.User;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by macbookpro on 19-07-16.
 */
public class HouseController {

    public static void postNewHouse(String houseName, String houseAddres, Callback<House> callback) {
        HouseService request = ManadoApiClient.retrofit.create(HouseService.class);
        Call<House> call = request.postHouse(houseName, houseAddres);
        call.enqueue(callback);
    }

    public static void getHouseById(String id, Callback<House> callback) {
        HouseService request = ManadoApiClient.retrofit.create(HouseService.class);
        Call<House> call = request.getHouseById(id);
        call.enqueue(callback);
    }
}
