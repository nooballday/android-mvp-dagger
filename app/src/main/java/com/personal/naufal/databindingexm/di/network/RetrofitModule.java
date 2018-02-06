package com.personal.naufal.databindingexm.di.network;

import com.personal.naufal.databindingexm.api.Services;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Naufal on 05/02/2018.
 */

@Module(includes = OkHttpModule.class)
public class RetrofitModule {

    @Provides @Singleton
    public Retrofit retrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
