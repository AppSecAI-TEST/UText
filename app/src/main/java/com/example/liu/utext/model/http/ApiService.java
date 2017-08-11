package com.example.liu.utext.model.http;

import com.example.liu.utext.model.bean.Info;
import com.example.liu.utext.model.bean.Schedule;
import com.example.liu.utext.model.bean.User;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String BaseUrl = "http://119.29.100.16:8080/Utext/";

    @GET("register.php")
    Observable<Info<User>> register(@Query("phoneNumber") String phoneNumber, @Query("password") String password);
    @GET("login.php")
    Observable<Info<User>> login(@Query("phoneNumber") String phoneNumber, @Query("password") String password);
    @GET("update_password.php")
    Observable<Info<User>> updatePassword(@Query("phoneNumber") String phoneNumber, @Query("password") String password);
    @GET("get_schedule.php")
    Observable<Info<Schedule>> getSchedule();
    @GET("add_schedule.php")
    Observable<Info<Schedule>> addSchedule(@Query("id") String id, @Query("date") String date, @Query("time") String time, @Query("place") String place, @Query("content") String content);

}
