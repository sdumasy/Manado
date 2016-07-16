package com.manado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;

import com.manado.controllers.UserController;
import com.manado.http.ManadoApiClient;
import com.manado.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("dadada", "develop");
        UserController.getUser(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (3 ==2 ) {
                    User user = response.body();
                    Log.v("dddddddd", user.getName());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Error", t.getMessage());
//                Snackbar snackbar = Snackbar
//                        .make(getActivity().findViewById(R.id.main_content), getActivity().getString(R.string.error), Snackbar.LENGTH_LONG);
            }
        });
    }
}
