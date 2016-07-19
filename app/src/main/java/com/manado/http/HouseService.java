package com.manado.http;

import com.manado.model.House;
import com.manado.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by macbookpro on 19-07-16.
 */
public interface HouseService {

    @FormUrlEncoded
    @POST("houses")
    Call<House> postHouse(@Field("houseName") String houseName, @Field("houseAddress") String houseAddress);
}
