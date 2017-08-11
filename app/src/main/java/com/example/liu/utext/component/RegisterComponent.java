package com.example.liu.utext.component;

import com.example.liu.utext.module.RegisterModule;
import com.example.liu.utext.view.activity.RegisterActivity;

import dagger.Component;

@ActivityScope
@Component(modules = RegisterModule.class, dependencies = AppComponent.class)
public interface RegisterComponent {
    void inject(RegisterActivity registerActivity);
}