package com.example.asus.myapplication.p;


import android.util.Log;

import com.example.asus.myapplication.m.bean.ProductListBean;
import com.example.asus.myapplication.m.model.ProductListModel;
import com.example.asus.myapplication.v.interfaces.ProductListInterface;
import com.example.base.mvp.BasePresenter;

import java.util.HashMap;

public class ProductListPresenter extends BasePresenter<ProductListModel, ProductListInterface> {


    public void productlistp(HashMap<String, String> map) {
       // Log.e("123", "productlistp1: "+map );
        model.productlist(map, new ProductListModel.Imodelview() {
            @Override
            public void productm(ProductListBean productListBean) {
              //  Log.e("123", "productlistp2: "+productListBean );

                view.onHomeSuccess2(productListBean);
            }
        });

    }


    public interface productp {
        void productm(HashMap<String, String> map,ProductListBean productListBean);
    }

}
