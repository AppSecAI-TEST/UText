package com.example.liu.utext.view;

import java.util.List;

public interface BaseView<T> {
    void showData(int id, List<T> mData);
    void showErrorMessage(int id, String message);
}
