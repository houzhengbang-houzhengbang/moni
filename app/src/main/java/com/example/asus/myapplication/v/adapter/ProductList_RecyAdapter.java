package com.example.asus.myapplication.v.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.myapplication.R;
import com.example.asus.myapplication.m.bean.HomeBean;
import com.example.asus.myapplication.m.bean.ProductListBean;
import com.example.asus.myapplication.m.netUtil.FrescoUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class ProductList_RecyAdapter extends RecyclerView.Adapter {
    private Context context;

    public ProductList_RecyAdapter(Context context) {
        this.context = context;
    }

    private List<ProductListBean.DataBean> list = new ArrayList<>();

    public void setData(List<ProductListBean.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.productlist_recy_item, parent, false);
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
        viewHolder.tv_product_list_item1.setText(list.get(position).getTitle());
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
            sdv_product_list_item = itemView.findViewById(R.id.sdv_product_list_item);
            tv_product_list_item1 = itemView.findViewById(R.id.tv_product_list_item1);
        }

    }
}
