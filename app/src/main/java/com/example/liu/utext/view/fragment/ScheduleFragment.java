package com.example.liu.utext.view.fragment;

import android.widget.TextView;

import com.example.liu.utext.R;
import com.example.liu.utext.component.AppComponent;
import com.example.liu.utext.util.BindView;

public class ScheduleFragment extends BaseFragment {

    @BindView(R.id.dateText)
    private TextView mTextView;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_schedule;
    }

    @Override
    protected void setActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void init() {
        mTextView.setText("来创建你的行程吧");
    }

    @Override
    protected void ViewOnClick() {

    }
}
