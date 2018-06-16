package com.example.asus.myapplication.m.api;


import com.example.asus.myapplication.m.bean.ProductListBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    //https://www.zhaoapi.cn/product/searchProducts?keywords=%E5%9D%9A%E6%9E%9C&page=1
    @POST("product/searchProducts")
    @FormUrlEncoded
    Observable<ProductListBean> getProduct(@FieldMap HashMap<String, String> map);


}
