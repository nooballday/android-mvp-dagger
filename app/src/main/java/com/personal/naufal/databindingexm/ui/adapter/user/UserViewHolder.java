package com.personal.naufal.databindingexm.ui.adapter.user;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.personal.naufal.databindingexm.ui.adapter.BaseViewHolder;
import com.personal.naufal.databindingexm.ui.adapter.OnRecyclerObjectClickListener;
import com.personal.naufal.databindingexm.ui.main.UserModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Naufal on 03/02/2018.
 */

public class UserViewHolder extends BaseViewHolder<UserModel, OnRecyclerObjectClickListener<UserModel>> {

    @BindView(android.R.id.text1)
    TextView mText;

    public UserViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void onBind(UserModel item, @Nullable OnRecyclerObjectClickListener<UserModel> listener) {
        mText.setText(item.getTitle());

        /**
         * add listener to your itemView you can add anyview you wish to add click listener
         */
        if (listener != null){
            itemView.setOnClickListener(v -> listener.onItemClicked(item));
        }
    }
}
