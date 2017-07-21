package com.example.liu.utext.view.fragment;

import android.widget.TextView;
import com.example.liu.utext.R;
import com.example.liu.utext.component.AppComponent;
import com.example.liu.utext.util.BindView;
import net.frakbot.jumpingbeans.JumpingBeans;

public class ScheduleFragment extends BaseFragment {

    @BindView(R.id.schedule)
    private TextView mTextView;

    private JumpingBeans mJumpingBeans;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_schedule;
    }

    @Override
    protected void setActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void init() {
        mJumpingBeans = JumpingBeans.with(mTextView)
                .makeTextJump(0, mTextView.getText().length())
                .setLoopDuration(1000)
                .setIsWave(true)
                .build();
    }

    @Override
    protected void ViewOnClick() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mJumpingBeans.stopJumping();
    }
}
