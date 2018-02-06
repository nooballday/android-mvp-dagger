package com.personal.naufal.databindingexm.di.network;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Naufal on 05/02/2018.
 */

@Module
public class OkHttpModule {

    @Provides @Singleton
    OkHttpClient okHttpClient(){
        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request req = chain.request().newBuilder().addHeader("Authorization", "").build();
                    return chain.proceed(req);
                })
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

}
