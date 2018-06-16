package com.example.asus.myapplication.v.interfaces;


import com.example.asus.myapplication.m.bean.CarBean;
import com.example.asus.myapplication.m.bean.HomeBean;
import com.example.base.mvp.IBaseView;

public interface CarInterface extends IBaseView {
    void onHomeSuccess(CarBean carBean);

}
