package com.example.liu.utext.module;

import com.example.liu.utext.model.MainModel;
import com.example.liu.utext.model.http.ApiService;
import com.example.liu.utext.view.activity.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainActivity mMainActivity;

    public MainModule(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Provides
    public MainActivity provideMainActivity(){
        return mMainActivity;
    }

    @Provides
    public MainModel provideMainModel(ApiService apiService){
        return new MainModel(apiService);
    }
}
