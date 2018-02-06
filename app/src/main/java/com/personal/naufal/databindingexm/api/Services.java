package com.personal.naufal.databindingexm.api;

import com.personal.naufal.databindingexm.ui.main.UserModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Naufal on 03/02/2018.
 */

public interface Services {
    @GET("/posts")
    Observable<List<UserModel>> getPost();
}
