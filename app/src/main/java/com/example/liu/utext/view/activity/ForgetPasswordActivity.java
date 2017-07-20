package com.example.liu.utext.view.activity;

import android.app.Activity;
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

public class ForgetPasswordActivity extends BaseActivity {

    @BindView(R.id.fg_phoneNumber)
    private EditText mEditText1;
    @BindView(R.id.fg_verificationCode)
    private EditText mEditText3;
    @BindView(R.id.fg_getVerificationCode)
    private Button mButton1;
    @BindView(R.id.fg_verify)
    private Button mButton2;
    private MyEventHandle mMyEventHandle;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_forget_password;
    }

    @Override
    protected void setPresenter() {

    }

    @Override
    protected void init() {
        mMyEventHandle = new MyEventHandle(this);
        SMSSDK.registerEventHandler(mMyEventHandle);
        mEditText1.setText(getIntent().getStringExtra("phoneNumber"));
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

    private void returnMainActivity() {
        Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(mMyEventHandle);
    }

    private class MyEventHandle extends SMSEventHandle {

        private MyEventHandle(Activity activity) {
            super(activity);
        }

        @Override
        public void afterGetCode() {
            CountTimerView timerView = new CountTimerView(mButton1, R.string.resend_code);
            timerView.start();
            Toast.makeText(ForgetPasswordActivity.this, "短信已发送", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void afterSubmitCode() {
            returnMainActivity();
        }
    }
}
