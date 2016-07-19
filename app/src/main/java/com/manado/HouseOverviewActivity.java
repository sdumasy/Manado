package com.manado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.manado.adapters.HouseInvitationAdapter;
import com.manado.adapters.SearchUserAdapter;
import com.manado.model.User;

import java.util.ArrayList;

public class HouseOverviewActivity extends AppCompatActivity {
    private Button createHouseButton;
    private RecyclerView interViewRecycler;
    private TextView invitationTitle;
    private TextView createHouseTitle;
    private HouseInvitationAdapter houseAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_overview);
        initViews();
        setOnClickListeners();
    }

    public void initViews() {
        createHouseButton = (Button)findViewById(R.id.buildHouseButton);

        interViewRecycler = (RecyclerView) findViewById(R.id.invitationRecyclerView);
        interViewRecycler.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        interViewRecycler.setLayoutManager(mLayoutManager);
        houseAdapter = new HouseInvitationAdapter(new ArrayList<User>(), HouseOverviewActivity.this);
        interViewRecycler.setAdapter(houseAdapter);
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
