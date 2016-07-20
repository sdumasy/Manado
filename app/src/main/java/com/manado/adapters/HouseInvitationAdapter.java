package com.manado.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manado.R;
import com.manado.listViewHolders.SearchUserViewHolder;
import com.manado.model.Invitation;
import com.manado.model.User;
import com.manado.onClickInterfaces.OnInvitationClicked;
import com.manado.onClickInterfaces.OnSearchUserClicked;

import java.util.ArrayList;

public class HouseInvitationAdapter extends RecyclerView.Adapter<SearchUserViewHolder>{
    private ArrayList<Invitation> invitationDataSet;
    private Context context;
    private OnInvitationClicked mListener;


    public HouseInvitationAdapter(ArrayList<Invitation> myDataset, Context cont) {
        invitationDataSet = myDataset;
        context = cont;
    }

    public void updateDataSet(ArrayList<Invitation> invitations) {
        invitationDataSet = invitations;
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
        holder.getProjectTitleView().setText(invitationDataSet.get(position).getHouseName());
        holder.getProjectImageView().setImageResource(R.drawable.placeholder);
        if (context instanceof OnSearchUserClicked) {
            mListener = (OnInvitationClicked) context;
            holder.getParentView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.clickInvitation(invitationDataSet.get(position));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return invitationDataSet.size();
    }
}
