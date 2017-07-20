package com.example.liu.utext.util;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public class ToastUtils {

    public static void show(Context context, CharSequence text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void show(Fragment fragment, CharSequence text) {
        Toast.makeText(fragment.getActivity(), text, Toast.LENGTH_SHORT).show();
    }
}
