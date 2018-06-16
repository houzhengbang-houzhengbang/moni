package com.example.asus.myapplication.v.activity;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.asus.myapplication.R;
import com.example.asus.myapplication.m.bean.AddCarBean;
import com.example.asus.myapplication.m.bean.xiangqingBean;
import com.example.asus.myapplication.m.model.ProductListModel;
import com.example.asus.myapplication.p.XiangQingPresenter;
import com.example.asus.myapplication.v.fragment.FragmentCar;
import com.example.asus.myapplication.v.interfaces.XiangQingInterface;
import com.example.base.BaseActivity;
import com.example.base.mvp.BaseModel;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;

public class XiangQingActivity extends BaseActivity<XiangQingPresenter> implements XiangQingInterface {

    private Button xq_add;
    private SimpleDraweeView xq_img;
    private TextView xq_tex;
    private xiangqingBean xiangqingBean1;
    private String images;
    private int price;
    private String pid;
    private String pida;

    @Override
    protected BaseModel initModel() {
        return new ProductListModel();
    }

    @Override
    protected XiangQingPresenter initPresenter() {
        return new XiangQingPresenter();
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_xiang_qing;
    }

    @Override
    protected void initView() {

        xq_add = findViewById(R.id.XQ_add);
        xq_img = findViewById(R.id.XQ_img);
        xq_tex = findViewById(R.id.XQ_tex);

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        pida = intent.getStringExtra("pid");
        Log.e("123", "initView: "+ pida);

        presenter.XiangQingp(""+59);

        images = xiangqingBean1.getData().getImages();
        price = xiangqingBean1.getData().getPrice();

        xq_tex.setText(price);
        xq_img.setImageURI(images);

        xq_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> map = new HashMap<>();
                int b=15005;
                int o = 5;
                map.put("pid",o+"");
                map.put("uid",b+"");
                presenter.AddCarp(map);
                Intent intent1 = new Intent(XiangQingActivity.this, FragmentCar.class);
                startActivity(intent1);
            }
        });

    }


    @Override
    public void onXQSuccess(xiangqingBean xiangqingBean) {
        Log.e("123", "onXQSuccess: "+xiangqingBean );
        xiangqingBean1 = xiangqingBean;
    }

    @Override
    public void onAddCarSuccess2(AddCarBean productListBean) {

    }
}
