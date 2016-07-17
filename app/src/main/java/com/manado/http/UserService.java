package com.manado.http;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by macbookpro on 13-07-16.
 */
public interface UserService {

    @GET("user")
    Call<UserData> getUserData();

}
