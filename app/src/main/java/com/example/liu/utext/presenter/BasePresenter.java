package com.example.liu.utext.presenter;

import com.example.liu.utext.view.BaseView;

public abstract class BasePresenter<M,V extends BaseView> {

    protected M mModel;
    protected V mView;

    public BasePresenter(M model, V view) {
        mModel = model;
        mView = view;
    }

    public abstract void requestData(int id, String... info);
}
