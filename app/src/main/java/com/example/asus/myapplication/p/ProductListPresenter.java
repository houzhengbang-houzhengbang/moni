package com.example.asus.myapplication.p;


import com.example.asus.myapplication.m.bean.ProductListBean;
import com.example.asus.myapplication.m.model.ProductListModel;
import com.example.asus.myapplication.v.interfaces.ProductListInterface;
import com.example.base.mvp.BasePresenter;

public class ProductListPresenter extends BasePresenter<ProductListModel, ProductListInterface> {


    public void productlistp(String a) {

        model.productlist(new ProductListModel.Imodelview(){
            @Override
            public void productm(ProductListBean productListBean) {
                view.onHomeSuccess(productListBean);
            }
        });
 //model.productlist(new ProductListPresenter());
    }
}
