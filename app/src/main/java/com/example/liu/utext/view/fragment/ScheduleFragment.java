package com.example.liu.utext.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.widget.TextView;
import com.example.liu.utext.R;
import com.example.liu.utext.component.AppComponent;
import com.example.liu.utext.util.BindView;
import com.example.liu.utext.view.activity.ScheduleActivity;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

public class ScheduleFragment extends BaseFragment {

    @BindView(R.id.materialCalendarView)
    private MaterialCalendarView mMaterialCalendarView;
    @BindView(R.id.dateText)
    private TextView mTextView;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_schedule;
    }

    @Override
    protected void setActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void init() {
        mTextView.setText("来创建你的行程吧");
        mMaterialCalendarView.setSelectionColor(Color.GREEN);
    }

    @Override
    protected void ViewOnClick() {
        mMaterialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Intent intent = new Intent(getActivity(), ScheduleActivity.class);
                intent.putExtra("year", date.getYear());
                intent.putExtra("month", date.getMonth());
                intent.putExtra("day", date.getDay());
                getActivity().startActivity(intent);
            }
        });
    }
}
