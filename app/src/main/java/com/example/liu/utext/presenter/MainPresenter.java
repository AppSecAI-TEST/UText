package com.example.liu.utext.presenter;

import com.example.liu.utext.model.MainModel;
import com.example.liu.utext.view.activity.MainActivity;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainModel, MainActivity>{

    @Inject
    public MainPresenter(MainModel model, MainActivity view) {
        super(model, view);
    }

    @Override
    public void requestData(int id, String...info) {

    }
}
