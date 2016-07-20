package com.manado;

import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.manado.adapters.SearchUserAdapter;
import com.manado.controllers.HouseController;
import com.manado.controllers.InvitationController;
import com.manado.controllers.UserController;
import com.manado.model.House;
import com.manado.model.Invitation;
import com.manado.model.User;
import com.manado.onClickInterfaces.OnSearchUserClicked;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUsersToHouseActivity extends AppCompatActivity implements OnSearchUserClicked {

    private RecyclerView searchUsersRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private EditText searchUsers;

    private ArrayList<User> userList = new ArrayList<>();
    private SearchUserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_users_to_house);
        initViews();
        addOnActionListener();
    }

    public void addOnActionListener() {
        searchUsers.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                        actionId == EditorInfo.IME_ACTION_DONE ||
                        event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if (!event.isShiftPressed()) {
                        lookForUsers(searchUsers.getText().toString());
                        return true; // consume.
                    }
                }
                return false; // pass on to other listeners.

            }
        });
    }

    public void initViews() {
        searchUsers = (EditText)findViewById(R.id.search_users_edit_text);
        searchUsersRecyclerView = (RecyclerView) findViewById(R.id.searchUserRecyclerView);
        searchUsersRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        searchUsersRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new SearchUserAdapter(userList, AddUsersToHouseActivity.this);
        searchUsersRecyclerView.setAdapter(mAdapter);
    }

    public void lookForUsers(String username) {
        UserController.getSpecificUser(username, new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                if (response.code() == 200) {
                    userList = response.body();
                    mAdapter.updateDataSet(userList);

                } else {
                    Snackbar snack = Snackbar.make(AddUsersToHouseActivity.this.findViewById(R.id.mainContent), R.string.failLoginSnackbar, Snackbar.LENGTH_LONG);
                    View sbView = snack.getView();
                    sbView.setBackgroundColor(Color.RED);
                    snack.show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                Snackbar snack = Snackbar.make(AddUsersToHouseActivity.this.findViewById(R.id.mainContent), R.string.failLoginSnackbar, Snackbar.LENGTH_LONG);
                View sbView = snack.getView();
                sbView.setBackgroundColor(Color.RED);
                snack.show();
            }
        });
    }

    @Override
    public void clickSearchUser(User user) {
        Log.v("dddd", "yyyyyyy");
        addInvitationToUser(user);
    }

    public void addInvitationToUser(User user) {

        SharedPreferences prefs = this.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String userJson = prefs.getString("userLoggedIn", null);

        User loggedInUs = gson.fromJson(userJson, User.class);
        prepareInvitation(user,loggedInUs);


    }

    public void prepareInvitation(final User recUser, final User sendUser) {

        HouseController.getHouseById(sendUser.getHouseId(), new Callback<House>() {
            @Override
            public void onResponse(Call<House> call, Response<House> response) {
                if (response.code() == 200) {
                    Calendar c = Calendar.getInstance();
                    int day = c.get(Calendar.DAY_OF_MONTH);
                    int month = c.get(Calendar.MONTH);
                    int year = c.get(Calendar.YEAR);
                    Invitation tempInvitation = new Invitation(response.body().getHouseName(), recUser.getUsername(), sendUser.getUsername(), day + "-" + month + "-" + year);
                    sendInvitation(tempInvitation);
                } else {

                }
            }

            @Override
            public void onFailure(Call<House> call, Throwable t) {

            }
        });

    }

    public void sendInvitation(Invitation invitation) {
        Log.v("ddd", "ddd");
        InvitationController.postNewInvitation(invitation, new Callback<ArrayList<Invitation>>() {
            @Override
            public void onResponse(Call<ArrayList<Invitation>> call, Response<ArrayList<Invitation>> response) {
                if (response.code() == 200) {

                } else {

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Invitation>> call, Throwable t) {

            }
        });

    }


}
