package com.example.liu.utext.component;

import com.example.liu.utext.module.MainModule;
import com.example.liu.utext.view.activity.MainActivity;

import dagger.Component;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
