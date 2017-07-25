package com.example.liu.utext.view.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import com.example.liu.utext.R;
import com.example.liu.utext.util.BindView;
import com.example.liu.utext.view.BaseView;
import com.example.liu.utext.view.adapter.FragmentAdapter;
import com.example.liu.utext.view.fragment.AppointmentCircleFragment;
import com.example.liu.utext.view.fragment.GroupFragment;
import com.example.liu.utext.view.fragment.ScheduleFragment;
import java.util.ArrayList;
import java.util.List;

public class ScheduleMainActivity extends BaseActivity implements BaseView {

    @BindView(R.id.viewPager)
    private ViewPager viewPager;
    @BindView(R.id.tabLayout)
    private TabLayout tabLayout;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_schedule_main;
    }

    @Override
    protected void setPresenter() {

    }

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void init() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ScheduleFragment());
        fragments.add(new GroupFragment());
        fragments.add(new AppointmentCircleFragment());
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorHeight(0);
        tabLayout.setTabTextColors(Color.GRAY, Color.GREEN);
        tabLayout.getTabAt(0).setIcon(R.drawable.icon_schedule).setText(R.string.schedule);
        tabLayout.getTabAt(1).setIcon(R.drawable.icon_group).setText(R.string.group);
        tabLayout.getTabAt(2).setIcon(R.drawable.icon_appointment_circle).setText(R.string.appointment_circle);
    }

    @Override
    protected void ViewOnClick() {

    }

    @Override
    public void showData(int id, List mData) {

    }

    @Override
    public void showErrorMessage(int id, String message) {

    }
}
