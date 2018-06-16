package com.example.asus.myapplication.v.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.myapplication.R;
import com.example.asus.myapplication.m.bean.CarBean;
import com.example.asus.myapplication.m.netUtil.FrescoUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class Car_RecyAdapter extends RecyclerView.Adapter {
    private Context context;

    public Car_RecyAdapter(Context context) {
        this.context = context;
    }

    private List<CarBean.DataBean.ListBean> list = new ArrayList<>();

    public void setData(List<CarBean.DataBean.ListBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.Car_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;

        String images = list.get(position).getImages();
        String s = images;
        int i = images.indexOf("|");
        if (i != -1) {
            s = images.substring(0, i);
        }
        FrescoUtil.setJianJin(s, viewHolder.sdv_product_list_item);
        viewHolder.tv_product_list_item1.setText(list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView sdv_product_list_item;
        private TextView tv_product_list_item1;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv_product_list_item = itemView.findViewById(R.id.Car_img);
            tv_product_list_item1 = itemView.findViewById(R.id.Car_tex);
        }

    }
}
