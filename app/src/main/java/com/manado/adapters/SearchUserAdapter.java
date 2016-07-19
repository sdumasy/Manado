package com.manado.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manado.R;
import com.manado.listViewHolders.SearchUserViewHolder;
import com.manado.model.User;
import com.manado.onClickInterfaces.OnSearchUserClicked;

import java.util.ArrayList;


public class SearchUserAdapter extends RecyclerView.Adapter<SearchUserViewHolder>{
    private ArrayList<User> userDataSet;
    private Context context;
    private OnSearchUserClicked mListener;


    public SearchUserAdapter(ArrayList<User> myDataset, Context cont) {
        userDataSet = myDataset;
        context = cont;
    }

    public void updateDataSet(ArrayList<User> users) {
        userDataSet = users;
        this.notifyDataSetChanged();
    }

    @Override
    public SearchUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_user_view, parent, false);
        SearchUserViewHolder vh = new SearchUserViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(SearchUserViewHolder holder, final int position) {
        holder.getProjectTitleView().setText(userDataSet.get(position).getUsername());
        holder.getProjectImageView().setImageResource(R.drawable.placeholder);
        if (context instanceof OnSearchUserClicked) {
            mListener = (OnSearchUserClicked) context;
            holder.getParentView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.clickSearchUser(userDataSet.get(position));
                }
            });
        }
    }

//    public void onButtonPressed(Project project) {
//        if (mListener != null) {
//            mListener.clickProject(project);
//        }
//    }

    @Override
    public int getItemCount() {
        return userDataSet.size();
    }
}
