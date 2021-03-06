package com.example.liu.utext.model;

import com.example.liu.utext.model.bean.Info;
import com.example.liu.utext.model.bean.User;
import com.example.liu.utext.model.http.ApiService;

import io.reactivex.Observable;

public class MainModel {

    private ApiService mApiService;

    public MainModel(ApiService apiService) {
        mApiService = apiService;
    }

    public Observable<Info<User>> login(String phoneNumber, String password){
        return mApiService.login(phoneNumber, password);
    }
}
