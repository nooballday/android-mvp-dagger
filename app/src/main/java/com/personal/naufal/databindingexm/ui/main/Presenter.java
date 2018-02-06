package com.personal.naufal.databindingexm.ui.main;

import com.personal.naufal.databindingexm.api.Services;
import com.personal.naufal.databindingexm.di.BaseApplicationComponent;
import com.personal.naufal.databindingexm.di.DaggerBaseApplicationComponent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Naufal on 03/02/2018.
 */

public class Presenter implements MainMVP.Presenter {

    private final MainMVP.View view;

    private final CompositeDisposable disposable;

    private BaseApplicationComponent component;

    public Presenter(MainMVP.View view) {
        this.view = view;
        this.disposable = new CompositeDisposable();
    }

    @Override
    public void fetchData(String data) {
        component = DaggerBaseApplicationComponent.builder().build();

        view.showSpinner();
        disposable.add(component.getRetrofitService()
                .create(Services.class)
                .getPost()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::setModels, this::setError));
    }

    @Override
    public void onDestroy() {
        disposable.clear();
    }

    private void setModels(List<UserModel> models) {
        view.displayData(models);
        view.hideSpinner();
    }

    private void setError(Throwable t){

    }
}
