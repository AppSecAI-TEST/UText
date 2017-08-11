package com.example.liu.utext.view;

import java.util.List;

public interface BaseView<T> {
    void showData(int id, String message, List<T> mData);
    void showErrorMessage(int id, String message);
}
