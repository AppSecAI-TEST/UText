package com.example.liu.utext.view.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.liu.utext.R;
import com.example.liu.utext.util.BindView;
import com.example.liu.utext.util.CountTimerView;
import org.json.JSONObject;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;


public class RegisterActivity extends BaseActivity {

    @BindView(R.id.register_phoneNumber)
    private EditText mEditText1;
    @BindView(R.id.register_password)
    private EditText mEditText2;
    @BindView(R.id.verificationCode)
    private EditText mEditText3;
    @BindView(R.id.getVerificationCode)
    private Button mButton1;
    @BindView(R.id.registered)
    private Button mButton2;
    private SMSEventHandle mSMSEventHandle;
    private CountTimerView timerView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void setPresenter() {

    }

    @Override
    protected void init() {
        mSMSEventHandle = new SMSEventHandle();
        SMSSDK.registerEventHandler(mSMSEventHandle);
    }

    @Override
    protected void ViewOnClick() {
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SMSSDK.getVerificationCode("+86", mEditText1.getText().toString());
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

    private void returnMainActivity() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("phoneNumber", mEditText1.getText().toString());
        intent.putExtra("password", mEditText2.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(mSMSEventHandle);
    }

    private class SMSEventHandle extends EventHandler {
        @Override
        public void afterEvent(final int event, final int result, final Object data) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (result == SMSSDK.RESULT_COMPLETE) {
                        if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                            timerView = new CountTimerView(mButton1, R.string.resend_code);
                            timerView.start();
                        }else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE){
                            returnMainActivity();
                        }
                    } else {
                        try {
                            ((Throwable) data).printStackTrace();
                            Throwable resId = (Throwable) data;
                            JSONObject object = new JSONObject(resId.getMessage());
                            String des = object.optString("detail");
                            if (!TextUtils.isEmpty(des)) {
                                Toast.makeText(RegisterActivity.this, des, Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception var5) {
                            SMSLog.getInstance().w(var5);
                        }
                    }
                }
            });
        }
    }
}
