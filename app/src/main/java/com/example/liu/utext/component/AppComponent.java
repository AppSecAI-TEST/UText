package com.example.liu.utext.component;

import com.example.liu.utext.model.http.ApiService;
import com.example.liu.utext.module.AppModule;
import com.example.liu.utext.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    public ApiService getApiService();
}
