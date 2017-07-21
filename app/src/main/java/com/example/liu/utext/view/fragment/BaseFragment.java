package com.example.liu.utext.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liu.utext.App;
import com.example.liu.utext.component.AppComponent;
import com.example.liu.utext.presenter.BasePresenter;

import javax.inject.Inject;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    public App mApp;

    @Inject
    T presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setLayoutId(), container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mApp = (App) getActivity().getApplication();
        setActivityComponent(mApp.getAppComponent());
        init();
    }

    protected abstract int setLayoutId();

    protected abstract void setActivityComponent(AppComponent appComponent);

    protected abstract void init();
}
