package com.example.liu.utext.model;


import android.util.Log;

import com.example.liu.utext.model.bean.Info;
import com.example.liu.utext.model.bean.Schedule;
import com.example.liu.utext.model.http.ApiService;

import io.reactivex.Observable;

public class ScheduleModel {

    private ApiService mApiService;

    public ScheduleModel(ApiService apiService) {
        mApiService = apiService;
    }

    public Observable<Info<Schedule>> getSchedule(){
        return mApiService.getSchedule();
    }

    public Observable<Info<Schedule>> addSchedule(String id, String date, String time, String place, String content){
        Log.d("111",id+date+time+place+content);
        return mApiService.addSchedule(id, date, time, place, content);
    }
}
