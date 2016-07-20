package com.manado;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.manado.controllers.UserController;
import com.manado.http.ManadoApiClient;
import com.manado.model.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button registerButton;
    Button loginButton;
    EditText userTextField;
    EditText passTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ManadoApiClient.setup();
        initViews();
        setOnClickListeners();
    }

    public void initViews() {
        registerButton = (Button)findViewById(R.id.registerButton);
        loginButton = (Button)findViewById(R.id.loginButton);
        userTextField = (EditText)findViewById(R.id.editUserNameBox);
        passTextField = (EditText)findViewById(R.id.editPasswordBox);
    }

    public void setOnClickListeners() {

        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                validateLogin(userTextField.getText().toString(), passTextField.getText().toString());

            }
        });
    }

    public void validateLogin(String us, String pass) {
        UserController.getUserLogin(us, pass, new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.code() == 200) {
                    Intent intent = new Intent(MainActivity.this, HouseOverviewActivity.class);
                    startActivity(intent);
                } else {
                    Snackbar snack = Snackbar.make(MainActivity.this.findViewById(R.id.mainContent), R.string.failLoginSnackbar, Snackbar.LENGTH_LONG);
                    View sbView = snack.getView();
                    sbView.setBackgroundColor(Color.RED);
                    snack.show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Snackbar snack = Snackbar.make(MainActivity.this.findViewById(R.id.mainContent), R.string.failLoginSnackbar, Snackbar.LENGTH_LONG);
                View sbView = snack.getView();
                sbView.setBackgroundColor(Color.RED);
                snack.show();
            }
        });
    }
}
