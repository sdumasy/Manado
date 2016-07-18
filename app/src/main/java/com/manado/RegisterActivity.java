package com.manado;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.manado.controllers.UserController;
import com.manado.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText regUserEditText;
    EditText regPassEditText;
    EditText regEmailEditText;
    Button regButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
        setRegisterButtonListener();
    }

    public void initViews() {
        regUserEditText = (EditText)findViewById(R.id.regUserEditText);
        regPassEditText = (EditText)findViewById(R.id.regPassEditText);
        regEmailEditText = (EditText)findViewById(R.id.regEmailEditText);
        regButton = (Button) findViewById(R.id.regButton);

    }

    public void setRegisterButtonListener() {
        regButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                UserController.postUserLogin(regUserEditText.getText().toString(), regPassEditText.getText().toString(),
                        regEmailEditText.getText().toString(), new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.code() == 200) {
                            finish();
                        } else {
                                Snackbar snack = Snackbar.make(RegisterActivity.this.findViewById(R.id.mainContent),
                                    R.string.failLoginSnackbar, Snackbar.LENGTH_LONG);
                            View sbView = snack.getView();
                            sbView.setBackgroundColor(Color.RED);
                            snack.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Snackbar.make(getParent().findViewById(R.id.registerMainContent), R.string.failLoginSnackbar, Snackbar.LENGTH_LONG)
                                .show();
                    }
                });
                finish();
            }
        });
    }
}
