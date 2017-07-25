package com.example.liu.utext.view.adapter;

import android.content.Context;

import com.example.liu.utext.R;
import com.example.liu.utext.model.bean.Schedule;

import java.util.List;

public class ScheduleAdapter extends BaseAdapter<Schedule>{

    private Context mContext;
    public ScheduleAdapter(Context context, List<Schedule> datas) {
        super(R.layout.item_schedual, datas);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, Schedule item) {

    }
}
