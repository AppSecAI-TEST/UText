package com.example.liu.utext.module;

import com.example.liu.utext.model.RegisterModel;
import com.example.liu.utext.model.http.ApiService;
import com.example.liu.utext.view.activity.RegisterActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class RegisterModule {

    private RegisterActivity mRegisterActivity;

    public RegisterModule(RegisterActivity registerActivity) {
        mRegisterActivity = registerActivity;
    }

    @Provides
    public RegisterActivity provideRegisterActivity(){
        return mRegisterActivity;
    }

    @Provides
    public RegisterModel provideRegisterModel(ApiService apiService){
        return new RegisterModel(apiService);
    }
}
