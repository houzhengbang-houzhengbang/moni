package com.example.asus.myapplication.v.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.myapplication.R;
import com.example.asus.myapplication.m.bean.CarBean;
import com.example.asus.myapplication.m.model.CarModel;
import com.example.asus.myapplication.p.CarPresenter;
import com.example.asus.myapplication.v.adapter.Car_RecyAdapter;
import com.example.asus.myapplication.v.interfaces.CarInterface;
import com.example.base.BaseFragment;
import com.example.base.mvp.BaseModel;

public class FragmentCar  extends BaseFragment<CarPresenter> implements CarInterface {


    RecyclerView recyHome;

    private  CarBean.DataBean.ListBean carbean;
    private Car_RecyAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }
    @Override
    protected int bindLayoutId() {
        Toast.makeText(getActivity(), "123", Toast.LENGTH_SHORT).show();
        return R.layout.fragmentcar;
    }
    @Override
    protected CarPresenter initPresenter() {
        return new CarPresenter();
    }

    @Override
    protected BaseModel initModel() {
        return new CarModel();
    }

    @Override
    protected void initView(View view) {
        recyHome = view.findViewById(R.id.Car_recy);
    }

    @Override
    protected void initData() {

        adapter = new Car_RecyAdapter(getActivity());
        recyHome.setAdapter(adapter);
        //布局管理器
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyHome.setLayoutManager(linearLayoutManager);
        f.Carp();

    }


    @Override
    public void onHomeSuccess(CarBean carBean) {
        adapter.setData(carBean.getData());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
