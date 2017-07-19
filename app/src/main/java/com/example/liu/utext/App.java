package com.example.liu.utext;

import com.example.liu.utext.component.AppComponent;
import com.example.liu.utext.component.DaggerAppComponent;
import com.mob.MobApplication;

public class App extends MobApplication {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }
}
