package com.example.asus.myapplication.v.activity;


import android.graphics.Color;

import com.example.asus.myapplication.R;
import com.example.asus.myapplication.m.model.AddCarModel;
import com.example.asus.myapplication.m.model.MainModel;
import com.example.asus.myapplication.p.MainPresenter;
import com.example.asus.myapplication.v.fragment.FragmentCar;
import com.example.asus.myapplication.v.fragment.FragmentHome;
import com.example.asus.myapplication.v.interfaces.AddCarInterface;
import com.example.base.BaseActivity;
import com.example.base.mvp.BaseModel;
import com.example.base.mvp.BasePresenter;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends BaseActivity<MainPresenter, BasePresenter<AddCarModel, AddCarInterface>> {


    private BottomTabBar bottombar;

    @Override
    protected BaseModel initModel() {
        return new MainModel();
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {


        bottombar = findViewById(R.id.bottombar);


    }

    @Override
    protected void initData() {

        bottombar.init(getSupportFragmentManager())
                .setImgSize(100,100)
                .setFontSize(0)
                //  .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem( "首页", R.drawable.home2,R.drawable.home,FragmentHome.class)
                .addTabItem( "购物车", R.drawable.car2, R.drawable.car,FragmentCar.class)
                .isShowDivider(false);



    }


}
