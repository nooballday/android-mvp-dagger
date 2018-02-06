package com.personal.naufal.databindingexm.ui.adapter.user;

import android.content.Context;
import android.view.ViewGroup;

import com.personal.naufal.databindingexm.ui.adapter.GenericRecyclerViewAdapter;
import com.personal.naufal.databindingexm.ui.adapter.OnRecyclerObjectClickListener;
import com.personal.naufal.databindingexm.ui.main.UserModel;

/**
 * Created by Naufal on 03/02/2018.
 */

public class UserAdapter extends GenericRecyclerViewAdapter<UserModel, OnRecyclerObjectClickListener<UserModel>, UserViewHolder> {

    public UserAdapter(Context _context) {
        super(_context);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(inflate(android.R.layout.simple_list_item_1, parent));
    }
}
