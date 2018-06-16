package com.example.asus.myapplication.m.api;


import com.example.asus.myapplication.m.bean.AddCarBean;
import com.example.asus.myapplication.m.bean.ProductListBean;
import com.example.asus.myapplication.m.bean.CarBean;
import com.example.asus.myapplication.m.bean.xiangqingBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    //https://www.zhaoapi.cn/product/searchProducts?keywords=%E5%9D%9A%E6%9E%9C&page=1
    @POST("product/searchProducts")
    @FormUrlEncoded
    Observable<ProductListBean> getProduct(@FieldMap HashMap<String, String> map);



    //https://www.zhaoapi.cn/product/getProductDetail?pid=2
    @GET("product/getProductDetail")
    Observable<xiangqingBean> getXiangQing(@Query("pid")String pid);




    //https://www.zhaoapi.cn/product/addCart?uid=15005&pid=2
    @POST("product/addCart")
    @FormUrlEncoded
    Observable<AddCarBean> getAddCar(@FieldMap HashMap<String, String> map);





    //https://www.zhaoapi.cn/product/getCarts?uid=15005
    @GET("product/addCart?uid=15005")
    Observable<CarBean> getCar();




}
