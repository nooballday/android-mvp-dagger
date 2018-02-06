package com.personal.naufal.databindingexm.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.personal.naufal.databindingexm.R;
import com.personal.naufal.databindingexm.ui.adapter.OnRecyclerObjectClickListener;
import com.personal.naufal.databindingexm.ui.adapter.user.UserAdapter;
import com.personal.naufal.databindingexm.ui.BaseActivity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMVP.View, OnRecyclerObjectClickListener<UserModel> {

    private ProgressBar progressBar;

    private Presenter presenter;

    private UserAdapter adapter;

    private RecyclerView mRv;

    public MainActivity() {
        this.presenter = new Presenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progressBar = findViewById(R.id.loadingSpinner);
        presenter.fetchData("data");

        mRv = findViewById(R.id.rvUsers);
        adapter = new UserAdapter(this);
        adapter.setListener(this);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(adapter);

    }

    @OnClick(R.id.showBtn)
    public void submit(View v){
        Toast.makeText(this, "okay", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void displayData(List<UserModel> users) {
        adapter.setItems(users);
    }

    @Override
    public void showSpinner() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideSpinner() {
        progressBar.setVisibility(View.GONE);
    }

    /**
     * Handle click from recyclerview
     * @param item
     */

    @Override
    public void onItemClicked(UserModel item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
