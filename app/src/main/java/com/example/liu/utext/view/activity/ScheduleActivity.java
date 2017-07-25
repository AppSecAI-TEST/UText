package com.example.liu.utext.view.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.liu.utext.R;
import com.example.liu.utext.util.BindView;
import com.example.liu.utext.util.ToastUtils;
import com.example.liu.utext.view.BaseView;
import java.util.List;

public class ScheduleActivity extends BaseActivity implements BaseView {

    @BindView(R.id.recyclerView)
    private RecyclerView mRecyclerView;
    @BindView(R.id.information)
    private TextView mTextView;
    @BindView(R.id.build)
    private Button mButton;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_schedule;
    }

    @Override
    protected void setPresenter() {

    }

    @Override
    protected void init() {

    }

    @Override
    protected void ViewOnClick() {

    }

    @Override
    public void showData(int id, List mData) {
        if (mData == null){
            mRecyclerView.setVisibility(View.GONE);
            mTextView.setVisibility(View.VISIBLE);
            mButton.setVisibility(View.VISIBLE);
        }else{
            mRecyclerView.setVisibility(View.VISIBLE);
            mTextView.setVisibility(View.GONE);
            mButton.setVisibility(View.GONE);
        }
    }

    @Override
    public void showErrorMessage(int id, String message) {
        ToastUtils.show(this, message);
    }
}
