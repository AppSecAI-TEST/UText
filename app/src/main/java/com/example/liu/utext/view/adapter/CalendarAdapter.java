package com.example.liu.utext.view.adapter;

import android.graphics.Color;
import com.example.liu.utext.R;
import com.example.liu.utext.util.DateUtil;
import com.example.liu.utext.view.view.MyTextView;
import java.util.Date;
import java.util.List;

public class CalendarAdapter extends BaseAdapter<Date> {

    private boolean isTheMonth;

    public CalendarAdapter(List<Date> datas) {
        super(R.layout.item_calendar, datas);
        isTheMonth = false;
    }

    @Override
    protected void convert(BaseViewHolder holder, Date item) {
        MyTextView myTextView = (MyTextView) holder.getView(R.id.item_calendar_text);
        myTextView.setText(String.valueOf(getDay(item)));
        Date date = new Date();
        if (getDay(item) == 1) {
            isTheMonth = !isTheMonth;
        }
        if (isTheMonth) {
            myTextView.setTextColor(Color.BLACK);
        } else {
            myTextView.setTextColor(Color.GRAY);
        }
        if (getDay(date) == getDay(item) && getMonth(date) == getMonth(item)
                && getYear(date) == getYear(item)){
            myTextView.setToday(true);
            myTextView.setTextColor(Color.RED);
        }
    }

    private int getDay(Date date){
        return DateUtil.getDay("d", date);
    }

    private int getMonth(Date date){
        return DateUtil.getDay("M", date);
    }

    private int getYear(Date date){
        return DateUtil.getDay("yyyy", date);
    }
}
