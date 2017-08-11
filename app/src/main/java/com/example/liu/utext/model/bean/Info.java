package com.example.liu.utext.model.bean;

import java.util.List;

public class Info<T> {
    private int code;
    private String message;
    private List<T> mData;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return mData;
    }

    public void setData(List<T> data) {
        mData = data;
    }
}
