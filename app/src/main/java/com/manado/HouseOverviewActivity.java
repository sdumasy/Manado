package com.manado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HouseOverviewActivity extends AppCompatActivity {
    private Button createHouseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_overview);
        initViews();
        setOnClickListeners();
    }

    public void initViews() {
        createHouseButton = (Button)findViewById(R.id.buildHouseButton);
    }

    public void setOnClickListeners() {
        createHouseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HouseOverviewActivity.this, BuildHouseActivity.class);
                startActivity(intent);
            }
        });
    }
}
