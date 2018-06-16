package com.example.asus.myapplication.p;

import android.util.Log;

import com.example.asus.myapplication.m.bean.CarBean;
import com.example.asus.myapplication.m.bean.HomeBean;
import com.example.asus.myapplication.m.model.CarModel;
import com.example.asus.myapplication.m.model.HomeModel;
import com.example.asus.myapplication.v.interfaces.CarInterface;
import com.example.asus.myapplication.v.interfaces.HomeInterface;
import com.example.base.mvp.BasePresenter;

public class CarPresenter  extends BasePresenter<CarModel, CarInterface> {


    public void Carp() {


        model.home(new CarModel.ICarview() {
            @Override
            public void Carm(CarBean carBean) {
                view.onHomeSuccess(carBean);
            }
        });

    }


    public  interface hp{
        void onhp(CarBean carBean);
    }


}
