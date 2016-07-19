package com.manado;

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

import com.manado.adapters.SearchUserAdapter;
import com.manado.controllers.UserController;
import com.manado.model.User;
import com.manado.onClickInterfaces.OnSearchUserClicked;

import java.util.ArrayList;

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

    }


}
