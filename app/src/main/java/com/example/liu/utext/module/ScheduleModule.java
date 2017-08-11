package com.example.liu.utext.module;

import com.example.liu.utext.model.ScheduleModel;
import com.example.liu.utext.model.http.ApiService;
import com.example.liu.utext.view.activity.ScheduleActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class ScheduleModule {

    private ScheduleActivity mScheduleActivity;
    public ScheduleModule(ScheduleActivity scheduleActivity) {
        mScheduleActivity = scheduleActivity;
    }

    @Provides
    public ScheduleActivity provideScheduleActivity(){
        return mScheduleActivity;
    }

    @Provides
    public ScheduleModel provideScheduleModel(ApiService apiService){
        return new ScheduleModel(apiService);
    }
}
