package com.manado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.manado.controllers.UserController;
import com.manado.http.ManadoApiClient;
import com.manado.model.user.User;
import com.manado.model.user.UserData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ManadoApiClient.setup();

        UserController.getUserData(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                if (response.isSuccessful()) {
                    String mail = response.body().getData().get(0).getAttributes().getEmail();
                    Log.v("dddddddd", mail);
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                Log.d("Error", t.getMessage());
                Log.v("aaaaaa", "qqq");
//                Snackbar snackbar = Snackbar
//                        .make(getActivity().findViewById(R.id.main_content), getActivity().getString(R.string.error), Snackbar.LENGTH_LONG);
            }
        });
    }
}
