package com.example.liu.utext.util;

import com.example.liu.utext.view.activity.BaseActivity;

import java.lang.reflect.Field;

public class ButterKnife {

    public static void bind(BaseActivity baseActivity) throws Exception {
        Class<? extends BaseActivity> clazz = baseActivity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            BindView bindView = field.getAnnotation(BindView.class);
            field.set(baseActivity, baseActivity.findViewById(bindView.value()));
        }
    }
}
