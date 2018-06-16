package com.example.asus.myapplication.v.interfaces;


import com.example.asus.myapplication.m.bean.HomeBean;
import com.example.base.mvp.IBaseView;

public interface HomeInterface extends IBaseView {
    void onHomeSuccess(HomeBean homeBean);

}
