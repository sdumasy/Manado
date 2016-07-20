package com.manado.controllers;

import com.manado.http.HouseService;
import com.manado.http.InvitationService;
import com.manado.http.ManadoApiClient;
import com.manado.model.House;
import com.manado.model.Invitation;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by macbookpro on 19-07-16.
 */
public class InvitationController {

    public static void postNewInvitation(Invitation invitation, Callback<ArrayList<Invitation>> callback) {
        InvitationService request = ManadoApiClient.retrofit.create(InvitationService.class);
        Call<ArrayList<Invitation>> call = request.postInvitation(invitation.getRecUserName(), invitation.getSendUserName(),
                invitation.getHouseName(), invitation.getDate());
        call.enqueue(callback);
    }

}
