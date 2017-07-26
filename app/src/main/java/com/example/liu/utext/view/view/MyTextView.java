package com.example.liu.utext.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class MyTextView extends android.support.v7.widget.AppCompatTextView{

    private boolean isToday;
    private Paint mPaint = new Paint();

    public void setToday(boolean today) {
        isToday = today;
    }

    public MyTextView(Context context) {
        super(context);
        init();
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        isToday = false;
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isToday){
            canvas.translate(getWidth()/2, getHeight()/2);
            canvas.drawCircle(0, 0, getWidth()/3, mPaint);
        }
    }
}
