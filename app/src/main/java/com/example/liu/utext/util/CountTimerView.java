package com.example.liu.utext.util;

import android.os.CountDownTimer;
import android.widget.TextView;

public class CountTimerView extends CountDownTimer {

    private static final int TIME_COUNT = 61000;//时间防止从59s开始显示（以倒计时60s为例子）
    private TextView btn;
    private int endStrRid;

    public CountTimerView(TextView btn, int endStrRid) {
        super(TIME_COUNT, 1000);
        this.btn = btn;
        this.endStrRid = endStrRid;
    }

    @Override
    public void onFinish() {

        btn.setText(endStrRid);
        btn.setEnabled(true);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        btn.setEnabled(false);
        String text = millisUntilFinished / 1000 + " 秒后可重新发送";
        btn.setText(text);
    }
}
