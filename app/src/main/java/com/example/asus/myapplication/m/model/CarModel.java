package com.example.asus.myapplication.m.model;

import android.util.Log;

import com.example.asus.myapplication.m.api.ApiService;
import com.example.asus.myapplication.m.bean.CarBean;
import com.example.asus.myapplication.m.bean.HomeBean;
import com.example.asus.myapplication.m.netUtil.RetrofitUtil;
import com.example.base.mvp.BaseModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class CarModel extends BaseModel {



    public void home(final ICarview hp) {
        ApiService retrofitInterface = RetrofitUtil.getInstance().getRetrofitInterface();

        Observable<CarBean> gethome = retrofitInterface.getCar();
        gethome.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CarBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CarBean carBean) {
                        if(carBean != null){
                            hp.Carm(carBean);
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

    public interface ICarview {
        void Carm(CarBean carBean);

    }
}