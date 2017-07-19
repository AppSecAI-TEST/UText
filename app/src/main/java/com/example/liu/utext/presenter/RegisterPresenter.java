package com.example.liu.utext.presenter;

import com.example.liu.utext.model.RegisterModel;
import com.example.liu.utext.view.activity.RegisterActivity;

import javax.inject.Inject;

public class RegisterPresenter extends BasePresenter<RegisterModel, RegisterActivity>{

    @Inject
    public RegisterPresenter(RegisterModel model, RegisterActivity view) {
        super(model, view);
    }

    @Override
    public void requestData(int id, String...info) {

    }
}
