package com.manado.http;

import com.manado.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by macbookpro on 13-07-16.
 */
public interface UserService {

    @GET("user")
    Call<User> getUser();

}
