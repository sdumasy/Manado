package com.manado.http;

import com.manado.model.Login;
import com.manado.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @GET("users")
    Call<ArrayList<User>> getUserData();

    @FormUrlEncoded
    @POST("users/login")
    Call<Login> getUserLogin(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("users")
    Call<User> postUser(@Field("username") String username, @Field("password") String password, @Field("email") String email);

}
