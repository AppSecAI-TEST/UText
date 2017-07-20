package com.example.liu.utext.util;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;
import org.json.JSONObject;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;

public abstract class SMSEventHandle extends EventHandler {

    private Activity mActivity;

    public SMSEventHandle(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void afterEvent(final int event, final int result, final Object data) {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        afterGetCode();
                    } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        afterSubmitCode();
                    }
                } else {
                    try {
                        ((Throwable) data).printStackTrace();
                        Throwable resId = (Throwable) data;
                        JSONObject object = new JSONObject(resId.getMessage());
                        String des = object.optString("detail");
                        if (!TextUtils.isEmpty(des)) {
                            Toast.makeText(mActivity, des, Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception var5) {
                        SMSLog.getInstance().w(var5);
                    }
                }
            }
        });
    }

    public abstract void afterGetCode();

    public abstract void afterSubmitCode();
}
