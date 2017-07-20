package com.example.liu.utext.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.liu.utext.presenter.BasePresenter;
import com.example.liu.utext.util.ButterKnife;

import javax.inject.Inject;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity{

    @Inject
    T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        setPresenter();
        try {
            ButterKnife.bind(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        init();
        ViewOnClick();
    }

    protected abstract int setLayoutId();

    protected abstract void setPresenter();

    protected abstract void init();

    protected abstract void ViewOnClick();

}
