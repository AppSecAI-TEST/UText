package com.example.liu.utext.component;

import com.example.liu.utext.module.ForgetPasswordModule;
import com.example.liu.utext.view.activity.ForgetPasswordActivity;

import dagger.Component;

@ActivityScope
@Component(modules = ForgetPasswordModule.class, dependencies = AppComponent.class)
public interface ForgetPasswordComponent {
    void inject(ForgetPasswordActivity forgetPasswordActivity);
}