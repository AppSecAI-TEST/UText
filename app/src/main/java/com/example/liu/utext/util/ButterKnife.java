package com.example.liu.utext.util;

import android.view.View;

import com.example.liu.utext.view.activity.BaseActivity;
import com.example.liu.utext.view.fragment.BaseFragment;

import java.lang.reflect.Field;

public class ButterKnife {

    public static void bind(BaseActivity baseActivity) {
        Class<? extends BaseActivity> clazz = baseActivity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                field.setAccessible(true);
                BindView bindView = field.getAnnotation(BindView.class);
                if (bindView != null) {
                    try {
                        field.set(baseActivity, baseActivity.findViewById(bindView.value()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void bind(BaseFragment baseFragment) {
        Class<? extends BaseFragment> clazz = baseFragment.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                field.setAccessible(true);
                BindView bindView = field.getAnnotation(BindView.class);
                if (bindView != null) {
                    try {
                        field.set(baseFragment, baseFragment.mView.findViewById(bindView.value()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void bind(View view) {
        Class<? extends View> clazz = view.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                field.setAccessible(true);
                BindView bindView = field.getAnnotation(BindView.class);
                if (bindView != null) {
                    try {
                        field.set(view, view.findViewById(bindView.value()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
