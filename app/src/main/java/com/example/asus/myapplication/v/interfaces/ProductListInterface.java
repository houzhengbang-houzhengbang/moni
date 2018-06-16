package com.example.asus.myapplication.v.interfaces;


import com.example.asus.myapplication.m.bean.ProductListBean;
import com.example.base.mvp.IBaseView;

public interface ProductListInterface extends IBaseView {
    void onHomeSuccess(ProductListBean productListBean);

}
