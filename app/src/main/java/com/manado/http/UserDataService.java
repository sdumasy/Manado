package com.manado.http;

import com.manado.model.user.UserData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by macbookpro on 13-07-16.
 */
public interface UserDataService {

    @GET("user")
    Call<UserData> getUserData();

}
