package com.example.liu.utext.module;

import com.example.liu.utext.model.ForgetPasswordModel;
import com.example.liu.utext.model.http.ApiService;
import com.example.liu.utext.view.activity.ForgetPasswordActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ForgetPasswordModule {

    private ForgetPasswordActivity mForgetPasswordActivity;

    public ForgetPasswordModule(ForgetPasswordActivity forgetPasswordActivity) {
        mForgetPasswordActivity = forgetPasswordActivity;
    }

    @Provides
    public ForgetPasswordActivity provideForgetPasswordActivity(){
        return mForgetPasswordActivity;
    }

    @Provides
    public ForgetPasswordModel provideForgetPasswordModel(ApiService apiService){
        return new ForgetPasswordModel(apiService);
    }
}
