package com.example.liu.utext.view.activity;

import android.widget.Button;
import android.widget.EditText;

import com.example.liu.utext.R;
import com.example.liu.utext.util.BindView;

public class ForgetPasswordActivity extends BaseActivity {

    @BindView(R.id.fg_phoneNumber)
    private EditText mEditText1;
    @BindView(R.id.fg_password)
    private EditText mEditText2;
    @BindView(R.id.fg_verificationCode)
    private EditText mEditText3;
    @BindView(R.id.fg_getVerificationCode)
    private Button mButton1;
    @BindView(R.id.fg_verify)
    private Button mButton2;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_forget_password;
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
}
