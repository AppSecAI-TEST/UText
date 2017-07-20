package com.example.liu.utext.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.liu.utext.App;
import com.example.liu.utext.R;
import com.example.liu.utext.component.DaggerMainComponent;
import com.example.liu.utext.module.MainModule;
import com.example.liu.utext.util.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.phoneNumber)
    private EditText mEditText1;
    @BindView(R.id.password)
    private EditText mEditText2;
    @BindView(R.id.login)
    private Button mButton1;
    @BindView(R.id.register)
    private Button mButton2;
    @BindView(R.id.forget_password)
    private TextView mTextView;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setPresenter() {
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .appComponent(((App)getApplication()).getAppComponent())
                .build()
                .inject(this);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void ViewOnClick() {
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.requestData(1, mEditText1.getText().toString(),
                        mEditText2.getText().toString());
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, RegisterActivity.class),0);
            }
        });
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
            mEditText1.setText(data.getStringExtra("phoneNumber"));
            mEditText2.setText(data.getStringExtra("password"));
        }
    }
}
