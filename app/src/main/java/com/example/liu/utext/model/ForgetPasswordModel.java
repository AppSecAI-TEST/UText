package com.example.liu.utext.model;


import com.example.liu.utext.model.bean.Info;
import com.example.liu.utext.model.bean.User;
import com.example.liu.utext.model.http.ApiService;
import io.reactivex.Observable;

public class ForgetPasswordModel {

    private ApiService mApiService;

    public ForgetPasswordModel(ApiService apiService) {
        mApiService = apiService;
    }

    public Observable<Info<User>> updatePassword(String phoneNumber, String password){
        return mApiService.updatePassword(phoneNumber, password);
    }
}
