package com.example.liu.utext.component;

import com.example.liu.utext.module.ScheduleModule;
import com.example.liu.utext.view.activity.ScheduleActivity;

import dagger.Component;

@ActivityScope
@Component(modules = ScheduleModule.class, dependencies = AppComponent.class)
public interface ScheduleComponent {
    void inject(ScheduleActivity scheduleActivity);
}