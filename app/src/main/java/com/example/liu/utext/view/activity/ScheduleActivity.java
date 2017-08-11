package com.example.liu.utext.view.activity;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.liu.utext.App;
import com.example.liu.utext.R;
import com.example.liu.utext.component.DaggerScheduleComponent;
import com.example.liu.utext.model.bean.Schedule;
import com.example.liu.utext.module.ScheduleModule;
import com.example.liu.utext.presenter.SchedulePresenter;
import com.example.liu.utext.util.BindView;
import com.example.liu.utext.util.ToastUtils;
import com.example.liu.utext.view.BaseView;
import com.example.liu.utext.view.adapter.ScheduleAdapter;

import java.util.List;

public class ScheduleActivity extends BaseActivity<SchedulePresenter> implements BaseView<Schedule> {

    @BindView(R.id.recyclerView)
    private RecyclerView mRecyclerView;
    @BindView(R.id.information)
    private TextView mTextView;
    @BindView(R.id.fab_menu)
    private FloatingActionButton mButton;

    private PopupMenu popup;
    private TextView scheduleTime;
    private TextView scheduleDate;
    private EditText schedulePlace;
    private EditText scheduleContent;
    private String year;
    private String month;
    private String day;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_schedule;
    }

    @Override
    protected void setPresenter() {
        DaggerScheduleComponent.builder()
                .appComponent(((App) getApplication()).getAppComponent())
                .scheduleModule(new ScheduleModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void init() {
        popup = new PopupMenu(this, mButton);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_schedule, popup.getMenu());
        year = String.valueOf(getIntent().getIntExtra("year", 2000));
        int m = getIntent().getIntExtra("month", 1);
        int d = getIntent().getIntExtra("day", 1);
        month = m<10? "0"+m : ""+m;
        day = d<10? "0"+d : ""+d;
        presenter.requestData(0);
    }

    @Override
    protected void ViewOnClick() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.show();
            }
        });
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.create_schedule:
                        createSchedule();
                        break;
                }
                return true;
            }
        });
    }

    private void createSchedule() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_create_schedule, null);
        scheduleContent = (EditText) view.findViewById(R.id.dialog_schedule_content);
        schedulePlace = (EditText) view.findViewById(R.id.dialog_schedule_place);
        scheduleTime = (TextView) view.findViewById(R.id.dialog_schedule_time);
        scheduleDate = (TextView) view.findViewById(R.id.dialog_schedule_date);
        scheduleDate.setText(year+"年" +month+"月"+day+"日");
        new AlertDialog.Builder(this)
                .setTitle("创建行程")
                .setView(view)
                .setIcon(R.mipmap.icon)
                .setPositiveButton("创建", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (scheduleTime.getText().toString().equals("设置时间")){
                            ToastUtils.show(ScheduleActivity.this, "请设置时间");
                        }
                        if (schedulePlace.getText().toString().equals("")){
                            ToastUtils.show(ScheduleActivity.this, "请设置地点");
                        }
                        if (scheduleContent.getText().toString().equals("")){
                            ToastUtils.show(ScheduleActivity.this, "请设置内容");
                        }
                        presenter.requestData(1, year+month+day+scheduleTime.getText().toString().replace(":",""),
                                scheduleDate.getText().toString(),
                                scheduleTime.getText().toString(),
                                schedulePlace.getText().toString(),
                                scheduleContent.getText().toString());
                        presenter.requestData(0);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .create()
                .show();
        scheduleTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(ScheduleActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String h = hourOfDay<10 ? "0"+hourOfDay : ""+hourOfDay;
                        String m = minute<10 ? "0"+minute : ""+minute;
                        scheduleTime.setText(h+":"+m);
                    }
                }, 0, 0, true).show();
            }
        });
    }

    @Override
    public void showData(int id, String message, List<Schedule> mData) {
        if (id == 0) {
            if (mData == null) {
                mRecyclerView.setVisibility(View.GONE);
                mTextView.setVisibility(View.VISIBLE);
                mButton.setVisibility(View.VISIBLE);
            } else {
                mRecyclerView.setVisibility(View.VISIBLE);
                mTextView.setVisibility(View.GONE);
                mButton.setVisibility(View.GONE);
                mRecyclerView.setAdapter(new ScheduleAdapter(this, mData));
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
            }
        }
    }

    @Override
    public void showErrorMessage(int id, String message) {
        ToastUtils.show(this, message);
    }
}
