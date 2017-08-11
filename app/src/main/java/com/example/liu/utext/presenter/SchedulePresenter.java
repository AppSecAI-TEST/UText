package com.example.liu.utext.presenter;

import com.example.liu.utext.model.ScheduleModel;
import com.example.liu.utext.model.bean.Info;
import com.example.liu.utext.model.bean.Schedule;
import com.example.liu.utext.view.activity.ScheduleActivity;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SchedulePresenter extends BasePresenter<ScheduleModel, ScheduleActivity>{

    @Inject
    public SchedulePresenter(ScheduleModel model, ScheduleActivity view) {
        super(model, view);
    }

    @Override
    public void requestData(int id, String...info) {
        if (id == 0) {
            mModel.getSchedule()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Info<Schedule>>() {
                        @Override
                        public void accept(@NonNull Info<Schedule> scheduleInfo) throws Exception {
                            if (scheduleInfo.getCode() == 1){
                                mView.showData(0, scheduleInfo.getMessage(), scheduleInfo.getData());
                            }else {
                                mView.showErrorMessage(0, scheduleInfo.getMessage());
                            }
                        }
                    });
        }else if (id == 1){
            mModel.addSchedule(info[0], info[1], info[2], info[3], info[4])
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Info<Schedule>>() {
                        @Override
                        public void accept(@NonNull Info<Schedule> scheduleInfo) throws Exception {
                            if (scheduleInfo.getCode() == 1){
                                mView.showData(1, scheduleInfo.getMessage(), scheduleInfo.getData());
                            }else {
                                mView.showErrorMessage(1, scheduleInfo.getMessage());
                            }
                        }
                    });
        }
    }
}
