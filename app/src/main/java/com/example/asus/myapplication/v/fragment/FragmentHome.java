package com.example.asus.myapplication.v.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.myapplication.R;
import com.example.asus.myapplication.m.bean.HomeBean;
import com.example.asus.myapplication.m.model.HomeModel;
import com.example.asus.myapplication.p.HomePresenter;
import com.example.asus.myapplication.v.activity.ProductListActivity;
import com.example.asus.myapplication.v.customview.customView;
import com.example.asus.myapplication.v.interfaces.HomeInterface;
import com.example.base.BaseFragment;
import com.example.base.mvp.BaseModel;

public class FragmentHome extends BaseFragment<HomePresenter> implements HomeInterface, View.OnClickListener  {

    String[] name={"手机","电脑","玩具","手机","电脑","苹果手机"};
    private EditText mSearchInputSearch;
    private TextView mResultSearch;
    private customView mSearchFlowlayout;
    private Button mSearchClear;
    private TextView textView;

    @Override
    protected int bindLayoutId() {
        return R.layout.fragmenthome;
    }
    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected BaseModel initModel() {
        return new HomeModel();
    }

    @Override
    protected void initView(View view) {
        mSearchInputSearch = (EditText) view.findViewById(R.id.search_input_search);
        mResultSearch = (TextView) view.findViewById(R.id.result_search);
        mSearchFlowlayout = (customView) view.findViewById(R.id.search_flowlayout);
        mSearchClear = (Button) view.findViewById(R.id.search_clear);
        mSearchClear.setOnClickListener(this);
    }


    @Override
    protected void initData() {
        for (int i = 0; i < name.length; i++) {
            textView = new TextView(getActivity());
            textView.setText(name[i]);
            textView.setBackgroundResource(R.drawable.addatten_edit);
            textView.setPadding(5,5,5,5);
            textView.setTextSize(20);
            textView.setTextColor(Color.RED);
            mSearchFlowlayout.addView(textView);
        }
        //点击搜索添加
        mResultSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mSearchInputSearch.getText().toString();
                textView = new TextView(getActivity());
                textView.setBackgroundResource(R.drawable.addatten_edit);
                textView.setPadding(5,5,5,5);
                textView.setTextSize(20);
                textView.setText(s);
                mSearchFlowlayout.addView(textView);
                Toast.makeText(getActivity(),""+s,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ProductListActivity.class);
                intent.putExtra("123",s);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onHomeSuccess(HomeBean homeBean) {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.search_clear:
                mSearchFlowlayout.removeAllViews();
                break;
        }
    }

}
