package com.manado;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.manado.adapters.SearchUserAdapter;
import com.manado.controllers.HouseController;
import com.manado.controllers.UserController;
import com.manado.model.House;
import com.manado.model.Login;
import com.manado.model.User;
import com.manado.onClickInterfaces.OnSearchUserClicked;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuildHouseActivity extends AppCompatActivity {

    Button addUsersToHouseButton;
    Button homePageButton;
    EditText houseName;
    EditText houseAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_house);
        initViews();
        addOnClickListeners();
    }

    public void initViews() {
        addUsersToHouseButton = (Button) findViewById(R.id.addUserToHouseButton);
        homePageButton = (Button) findViewById(R.id.toHomePageButton);
        houseName = (EditText)findViewById(R.id.houseName);
        houseAddress = (EditText) findViewById(R.id.houseAddress);
    }

    public void addOnClickListeners() {
        addUsersToHouseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addHouse(houseName.getText().toString(), houseAddress.getText().toString());
            }
        });

        homePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BuildHouseActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addHouse(String houseName, String houseAddress) {
        HouseController.postNewHouse(houseName, houseAddress, new Callback<House>() {
            @Override
            public void onResponse(Call<House> call, Response<House> response) {
                if (response.code() == 200) {
                    Intent intent = new Intent(BuildHouseActivity.this, AddUsersToHouseActivity.class);
                    startActivity(intent);
                } else {
                    Snackbar snack = Snackbar.make(BuildHouseActivity.this.findViewById(R.id.mainContent), R.string.failLoginSnackbar, Snackbar.LENGTH_LONG);
                    View sbView = snack.getView();
                    sbView.setBackgroundColor(Color.RED);
                    snack.show();
                }
            }

            @Override
            public void onFailure(Call<House> call, Throwable t) {
                Snackbar snack = Snackbar.make(BuildHouseActivity.this.findViewById(R.id.mainContent), R.string.failLoginSnackbar, Snackbar.LENGTH_LONG);
                View sbView = snack.getView();
                sbView.setBackgroundColor(Color.RED);
                snack.show();
            }
        });
    }


}
