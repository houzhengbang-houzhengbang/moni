package com.example.asus.myapplication.v.activity;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.asus.myapplication.R;
import com.example.asus.myapplication.m.bean.ProductListBean;
import com.example.asus.myapplication.m.model.AddCarModel;
import com.example.asus.myapplication.m.model.ProductListModel;
import com.example.asus.myapplication.p.ProductListPresenter;
import com.example.asus.myapplication.v.adapter.ProductList_RecyAdapter;
import com.example.asus.myapplication.v.interfaces.AddCarInterface;
import com.example.asus.myapplication.v.interfaces.ProductListInterface;
import com.example.base.BaseActivity;
import com.example.base.mvp.BaseModel;
import com.example.base.mvp.BasePresenter;

import java.util.HashMap;

public class ProductListActivity extends BaseActivity<ProductListPresenter, BasePresenter<AddCarModel, AddCarInterface>> implements ProductListInterface {

    private ProductList_RecyAdapter adapter;
    private RecyclerView recyHome;

    @Override
    protected BaseModel initModel() {
        return new ProductListModel();
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
    protected void initView() {


        recyHome = findViewById(R.id.recy_home);

    }
    @Override
    protected void initData() {

        adapter = new ProductList_RecyAdapter(ProductListActivity.this);
        recyHome.setAdapter(adapter);
        //布局管理器
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ProductListActivity.this);
        recyHome.setLayoutManager(linearLayoutManager);
        Intent intent = getIntent();
        String a = intent.getStringExtra("123");

        HashMap<String, String> map = new HashMap<>();
        int b=1;
        map.put("keywords",a);
        map.put("page",b+"");
        Toast.makeText(ProductListActivity.this,""+map,Toast.LENGTH_SHORT).show();
       // Log.e("123", a+"---initView: ---"+map);

        presenter.productlistp(map);
    }


    @Override
    public void onHomeSuccess2(ProductListBean productListBean) {
    //    Log.e("123", "onHomeSuccess2: "+productListBean );

        adapter.setData(productListBean.getData());

    }
}
