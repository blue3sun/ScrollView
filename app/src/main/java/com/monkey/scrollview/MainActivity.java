package com.monkey.scrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListview;
    private ArrayList<String> mDatas;
    private InfoAdapter mInfoAdapter;
    private SlideScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for(int i=0;i<30;i++){
            mDatas.add("测试数据000"+i);
        }
    }

    private void initView() {
        mScrollView = (SlideScrollView)findViewById(R.id.sc);
        mListview = (ListView)findViewById(R.id.lv);
        mScrollView.setListView(mListview);
        mInfoAdapter = new InfoAdapter(mDatas,this);
        mListview.setAdapter(mInfoAdapter);
    }

}
