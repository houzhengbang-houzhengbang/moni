package com.example.asus.myapplication.v.interfaces;


import com.example.base.mvp.IBaseView;

public interface MainInterface extends IBaseView {
    void onSuccess(String s);
    void onFailed();
}
