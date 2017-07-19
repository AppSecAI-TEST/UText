package com.example.liu.utext.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liu.utext.App;
import com.example.liu.utext.R;
import com.example.liu.utext.component.DaggerRegisterComponent;
import com.example.liu.utext.module.RegisterModule;
import com.example.liu.utext.presenter.RegisterPresenter;
import com.example.liu.utext.util.BindView;
import com.example.liu.utext.view.BaseView;

import java.util.List;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements BaseView {

    @BindView(R.id.register_phoneNumber)
    private EditText mEditText1;
    @BindView(R.id.register_password)
    private EditText mEditText2;
    @BindView(R.id.getVerificationCode)
    private Button mButton1;
    @BindView(R.id.registered)
    private Button mButton2;

    private EventHandler eventHandler;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void setPresenter() {
        DaggerRegisterComponent.builder()
                .registerModule(new RegisterModule(this))
                .appComponent(((App) getApplication()).getAppComponent())
                .build()
                .inject(this);
    }

    @Override
    protected void init() {
        eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (data instanceof Throwable) {
                    Throwable throwable = (Throwable)data;
                    String msg = throwable.getMessage();
                    Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
                } else {
                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        // 处理你自己的逻辑
                    }
                }
            }
        };
        SMSSDK.registerEventHandler(eventHandler);
    }

    @Override
    protected void ViewOnClick() {
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify();
                returnMainActivity();
            }
        });
    }

    private void verify() {

    }

    private void returnMainActivity() {
        Intent intent = new Intent();
        intent.putExtra("phoneNumber", mEditText1.getText().toString());
        intent.putExtra("password", mEditText2.getText().toString());
        setResult(RESULT_OK,intent);
    }

    @Override
    public void showData(int id, List mData) {

    }

    @Override
    public void showErrorMessage(int id, String message) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
    }
}
