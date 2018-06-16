package com.example.asus.myapplication.v.interfaces;


import com.example.asus.myapplication.m.bean.AddCarBean;
import com.example.asus.myapplication.m.bean.xiangqingBean;
import com.example.base.mvp.IBaseView;

public interface XiangQingInterface extends IBaseView {
    void onXQSuccess(xiangqingBean xiangqingBean);

    void onAddCarSuccess2(AddCarBean productListBean);

}
