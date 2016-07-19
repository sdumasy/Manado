package com.manado;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.manado.controllers.UserController;
import com.manado.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    User loggedInUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences prefs = this.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String userId = prefs.getString("userLoggedIn", null);
        lookForUsers(userId);
    }

    public void lookForUsers(String userId) {
        UserController.getSpecificUserById(userId, new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code() == 200) {
                    loggedInUser = response.body();
                    initInterface();

                } else {
                    Snackbar snack = Snackbar.make(HomeActivity.this.findViewById(R.id.mainContent), R.string.failLoginSnackbar, Snackbar.LENGTH_LONG);
                    View sbView = snack.getView();
                    sbView.setBackgroundColor(Color.RED);
                    snack.show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Snackbar snack = Snackbar.make(HomeActivity.this.findViewById(R.id.mainContent), R.string.failLoginSnackbar, Snackbar.LENGTH_LONG);
                View sbView = snack.getView();
                sbView.setBackgroundColor(Color.RED);
                snack.show();
            }
        });
    }

    public void initInterface() {
        initViews();
    }

    public void initViews() {

    }
}
