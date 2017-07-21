package com.example.liu.utext.util;

import com.example.liu.utext.view.activity.BaseActivity;
import com.example.liu.utext.view.fragment.BaseFragment;

import java.lang.reflect.Field;

public class ButterKnife {

    public static void bind(BaseActivity baseActivity) throws Exception {
        Class<? extends BaseActivity> clazz = baseActivity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                field.setAccessible(true);
                BindView bindView = field.getAnnotation(BindView.class);
                if (bindView != null) {
                    field.set(baseActivity, baseActivity.findViewById(bindView.value()));
                }
            }
        }
    }

    public static void bind(BaseFragment baseFragment) throws Exception {
        Class<? extends BaseFragment> clazz = baseFragment.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                field.setAccessible(true);
                BindView bindView = field.getAnnotation(BindView.class);
                if (bindView != null) {
                    field.set(baseFragment, baseFragment.mView.findViewById(bindView.value()));
                }
            }
        }
    }
}
