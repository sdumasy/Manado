package com.manado.http;

import com.manado.model.Invitation;
import com.manado.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by macbookpro on 20-07-16.
 */
public interface InvitationService {

    @FormUrlEncoded
    @POST("invitations")
    Call<ArrayList<Invitation>> postInvitation(@Field("houseName") String houseName, @Field("recUserId") String recUserId,
                                                     @Field("sendUserId") String sendUserId, @Field("date") String date);

    @GET("invitations")
    Call<Invitation> getSpecificInvitationByReceiveUserId(@Query("id") String id);

}
