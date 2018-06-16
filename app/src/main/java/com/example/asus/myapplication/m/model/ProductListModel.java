package com.example.asus.myapplication.m.model;




import com.example.asus.myapplication.m.api.ApiService;
import com.example.asus.myapplication.m.bean.ProductListBean;
import com.example.asus.myapplication.m.netUtil.RetrofitUtil;
import com.example.base.mvp.BaseModel;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProductListModel extends BaseModel {


   public void productlist(HashMap<String, String> map,final Imodelview hp) {
        ApiService retrofitInterface = RetrofitUtil.getInstance().getRetrofitInterface();
        Observable<ProductListBean> getproductlist = retrofitInterface.getProduct(map);
       getproductlist.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductListBean productListBean) {
                        if(productListBean != null){
                            hp.productm(productListBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public interface Imodelview {
        void productm(ProductListBean productListBean);
    }
}