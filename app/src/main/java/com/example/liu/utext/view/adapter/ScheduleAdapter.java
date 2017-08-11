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
        holder.getTextView(R.id.schedule_date).setText(item.getDate());
        holder.getTextView(R.id.schedule_time).setText(item.getTime());
        holder.getTextView(R.id.schedule_place).setText(item.getPlace());
        holder.getTextView(R.id.schedule_content).setText(item.getContent());
    }
}
