package com.manado;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.manado.controllers.UserController;
import com.manado.fragments.DatePickerFragment;
import com.manado.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//date picker imports
import java.util.Calendar;

import android.widget.DatePicker;

import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    EditText regUserEditText;
    EditText regPassEditText;
    EditText regEmailEditText;
    TextView regBirthDate;
    TextView alreadyMember;
    Button regButton;

    //date picker inits
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();

        setRegisterButtonListener();
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void initViews() {
        regUserEditText = (EditText)findViewById(R.id.input_name);
        regEmailEditText = (EditText)findViewById(R.id.input_email);
        regPassEditText = (EditText)findViewById(R.id.input_password);
        regBirthDate = (TextView)findViewById(R.id.input_dateofbirth);
        alreadyMember = (TextView)findViewById(R.id.already_member);
        regButton = (Button) findViewById(R.id.btn_signup);

        alreadyMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void setRegisterButtonListener() {
       // final User tempUser = new User(regEmailEditText.getText().toString(), regUserEditText.getText().toString(), 2);

        regButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                final User tempUser = new User(regUserEditText.getText().toString(),
                        regEmailEditText.getText().toString(), regBirthDate.getText().toString(), 0);

                UserController.postUserLogin(tempUser, regPassEditText.getText().toString(), new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.code() == 200) {
                            finish();
                        } else {
                                Snackbar snack = Snackbar.make(RegisterActivity.this.findViewById(R.id.registerMainContent),
                                    response.message() , Snackbar.LENGTH_LONG);
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
            }
        });
    }
}
