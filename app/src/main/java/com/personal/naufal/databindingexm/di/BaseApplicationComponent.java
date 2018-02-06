package com.personal.naufal.databindingexm.di;

import com.personal.naufal.databindingexm.di.network.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Naufal on 05/02/2018.
 */

@Singleton
@Component(modules = {RetrofitModule.class})
public interface BaseApplicationComponent {

    Retrofit getRetrofitService();

}
