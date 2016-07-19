package com.manado.listViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.manado.R;

/**
 * Created by macbookpro on 19-07-16.
 */
public class SearchUserViewHolder extends RecyclerView.ViewHolder{

    private View parentView;
    private ImageView searchUserImageView;
    private TextView searchUserTitleView;

    public SearchUserViewHolder(View v) {
        super(v);
        parentView = v;
        searchUserImageView = (ImageView) v.findViewById(R.id.userCardImageView);
        searchUserTitleView = (TextView) v.findViewById(R.id.userCardText);
    }

    public View getParentView() {
        return parentView;
    }

    public ImageView getProjectImageView() {
        return searchUserImageView;
    }

    public TextView getProjectTitleView() {
        return searchUserTitleView;
    }
}


