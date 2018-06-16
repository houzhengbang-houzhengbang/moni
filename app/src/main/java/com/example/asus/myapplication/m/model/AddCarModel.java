package com.example.asus.myapplication.m.model;


import com.example.asus.myapplication.m.api.ApiService;
import com.example.asus.myapplication.m.bean.AddCarBean;
import com.example.asus.myapplication.m.bean.xiangqingBean;
import com.example.asus.myapplication.m.netUtil.RetrofitUtil;
import com.example.base.mvp.BaseModel;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AddCarModel extends BaseModel {

    public void AddCar(HashMap<String, String> map, final IAddCarmodelview iAddCarmodelview) {

        ApiService retrofitInterface = RetrofitUtil.getInstance().getRetrofitInterface();
        Observable<AddCarBean> getAddCar = retrofitInterface.getAddCar(map);
        getAddCar.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddCarBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(AddCarBean addCarBean) {
                if (addCarBean != null) {
                    iAddCarmodelview.AddCarm(addCarBean);

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


    public interface IAddCarmodelview {
        void AddCarm(AddCarBean addCarBean);
    }
}