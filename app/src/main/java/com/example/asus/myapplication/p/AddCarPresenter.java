package com.example.asus.myapplication.p;

import com.example.asus.myapplication.m.bean.AddCarBean;
import com.example.asus.myapplication.m.bean.ProductListBean;
import com.example.asus.myapplication.m.bean.xiangqingBean;
import com.example.asus.myapplication.m.model.AddCarModel;
import com.example.asus.myapplication.m.model.XiangQingModel;
import com.example.asus.myapplication.v.interfaces.AddCarInterface;
import com.example.asus.myapplication.v.interfaces.XiangQingInterface;
import com.example.base.mvp.BasePresenter;

import java.util.HashMap;

public class AddCarPresenter extends BasePresenter<AddCarModel, AddCarInterface> {


    public void AddCarp(HashMap<String, String> map) {

        model.AddCar(map, new AddCarModel.IAddCarmodelview() {
            @Override
            public void AddCarm(AddCarBean addCarBean) {
                view.onAddCarSuccess2(addCarBean);
            }
        });

    }


    public interface AddCarp {
        void AddCarm(HashMap<String, String> map);
    }


}
