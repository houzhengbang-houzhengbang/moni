package com.example.asus.myapplication.v.activity;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.asus.myapplication.R;
import com.example.asus.myapplication.m.model.MainModel;
import com.example.asus.myapplication.p.ProductListPresenter;
import com.example.asus.myapplication.v.adapter.ProductList_RecyAdapter;
import com.example.base.BaseActivity;
import com.example.base.mvp.BaseModel;

public class ProductListActivity extends BaseActivity<ProductListPresenter> {

    private ProductList_RecyAdapter adapter;

    @Override
    protected BaseModel initModel() {
        return new MainModel();
    }

    @Override
    protected ProductListPresenter initPresenter() {
        return new ProductListPresenter();
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_product_list;
    }

    @Override
    protected void initView() {Intent intent = getIntent();
        RecyclerView recyHome = findViewById(R.id.recy_home);
        adapter = new ProductList_RecyAdapter(ProductListActivity.this);
        recyHome.setAdapter(adapter);
        //布局管理器
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ProductListActivity.this);
        recyHome.setLayoutManager(linearLayoutManager);
        String a = intent.getStringExtra("123");
        presenter.productlistp(a);

    }

    @Override
    protected void initData() {
    }
}
