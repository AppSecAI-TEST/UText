package com.example.liu.utext.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.liu.utext.R;
import com.example.liu.utext.util.BindView;
import com.example.liu.utext.util.CountTimerView;
import com.example.liu.utext.util.SMSEventHandle;
import com.example.liu.utext.util.ToastUtils;
import cn.smssdk.SMSSDK;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.register_phoneNumber)
    private EditText mEditText1;
    @BindView(R.id.register_password)
    private EditText mEditText2;
    @BindView(R.id.verificationCode)
    private EditText mEditText3;
    @BindView(R.id.getVerificationCode)
    private Button mButton1;
    @BindView(R.id.verify)
    private Button mButton2;
    private MyEventHandle mMyEventHandle;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void setPresenter() {

    }

    @Override
    protected void init() {
        mMyEventHandle = new MyEventHandle(this);
        SMSSDK.registerEventHandler(mMyEventHandle);
    }

    @Override
    protected void ViewOnClick() {
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkPhoneNum(mEditText1.getText().toString())) {
                    SMSSDK.getVerificationCode("+86", mEditText1.getText().toString());
                }
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SMSSDK.submitVerificationCode("+86",
                        mEditText1.getText().toString(), mEditText3.getText().toString());
            }
        });
    }

    private boolean checkPhoneNum(String phone) {
        if (TextUtils.isEmpty(phone)) {
            ToastUtils.show(this, "请输入手机号码");
            return false;
        }
        if (phone.length() != 11) {
            ToastUtils.show(this, "手机号码长度不对");
            return false;
        }
        return true;
    }

    private void AddNewUser() {

    }

    private void returnMainActivity() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        intent.putExtra("phoneNumber", mEditText1.getText().toString());
        intent.putExtra("password", mEditText2.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(mMyEventHandle);
    }

    private class MyEventHandle extends SMSEventHandle{

        private MyEventHandle(Activity activity) {
            super(activity);
        }

        @Override
        public void afterGetCode() {
            CountTimerView timerView = new CountTimerView(mButton1, R.string.resend_code);
            timerView.start();
            Toast.makeText(RegisterActivity.this, "短信已发送", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void afterSubmitCode() {
            AddNewUser();
            returnMainActivity();
        }
    }
}
