package com.example.liu.utext.model;


import com.example.liu.utext.model.bean.Info;
import com.example.liu.utext.model.bean.User;
import com.example.liu.utext.model.http.ApiService;

import io.reactivex.Observable;

public class RegisterModel {

    private ApiService mApiService;

    public RegisterModel(ApiService apiService) {
        mApiService = apiService;
    }

    public Observable<Info<User>> register(String phoneNumber, String password){
        return mApiService.register(phoneNumber, password);
    }
}
