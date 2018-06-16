package com.example.asus.myapplication.v.interfaces;


import com.example.asus.myapplication.m.bean.AddCarBean;
import com.example.asus.myapplication.m.bean.ProductListBean;
import com.example.base.mvp.IBaseView;

public interface AddCarInterface extends IBaseView {
    void onAddCarSuccess2(AddCarBean addCarBean);
}
