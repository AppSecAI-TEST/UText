package com.example.liu.utext.view.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.liu.utext.R;
import com.example.liu.utext.util.BindView;
import com.example.liu.utext.util.ButterKnife;
import com.example.liu.utext.util.DateUtil;
import com.example.liu.utext.view.activity.ScheduleActivity;
import com.example.liu.utext.view.adapter.BaseAdapter;
import com.example.liu.utext.view.adapter.CalendarAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MyCalendarView extends LinearLayout {

    @BindView(R.id.lastMonth)
    private ImageView mImageView1;
    @BindView(R.id.nextMonth)
    private ImageView mImageView2;
    @BindView(R.id.date)
    private TextView mTextView;
    @BindView(R.id.recyclerView_calendar)
    private RecyclerView mRecyclerView;

    private Calendar mCalendar;
    private String dateFormat;

    public MyCalendarView(Context context) {
        super(context);
        init(context, null);
    }

    public MyCalendarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MyCalendarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        mCalendar = Calendar.getInstance();
        bindView(context);
        bindEvent();
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs,
                    R.styleable.MyCalendarView);
            try {
                dateFormat = typedArray.getString(R.styleable.MyCalendarView_dateFormat);
                if (dateFormat == null){
                    dateFormat = "yyyy年M月";
                }
            } finally {
                typedArray.recycle();
            }
        }
        renderCalendar();
    }

    private void bindView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.calendar_view, this);
        ButterKnife.bind(this);
    }

    private void bindEvent() {
        mImageView1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendar.add(Calendar.MONTH, -1);
                renderCalendar();
            }
        });
        mImageView2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendar.add(Calendar.MONTH, 1);
                renderCalendar();
            }
        });
    }

    private void renderCalendar() {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) SimpleDateFormat.getInstance();
        simpleDateFormat.applyPattern(dateFormat);
        mTextView.setText(simpleDateFormat.format(mCalendar.getTime()));
        ArrayList<Date> dates = new ArrayList<>();
        Calendar calendar = (Calendar) mCalendar.clone();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int previousDays = calendar.get(Calendar.DAY_OF_WEEK)-1;
        calendar.add(Calendar.DAY_OF_MONTH, -previousDays);
        int maxDateCount = 6*7;
        while (dates.size() < maxDateCount){
            dates.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        final CalendarAdapter adapter = new CalendarAdapter(dates);
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Date date = adapter.getItem(position);
                Intent intent = new Intent(getContext(), ScheduleActivity.class);
                intent.putExtra("year", DateUtil.getYear("yyyy", date));
                intent.putExtra("month", DateUtil.getMonth("M", date));
                intent.putExtra("day", DateUtil.getDay("d", date));
                getContext().startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 7));
    }
}
