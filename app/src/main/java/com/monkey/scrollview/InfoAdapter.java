package com.monkey.scrollview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Description:
 * Author: lanjing
 * Time: 2017/4/5 13:55
 */

public class InfoAdapter extends BaseAdapter {
    private ArrayList<String> mDatas;
    private Context mContext;

    public InfoAdapter(ArrayList<String> mDatas, Context mContext) {
        this.mDatas = mDatas;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        if(mDatas!=null){
            return mDatas.size();
        }else{
            return 0;
        }
    }

    @Override
    public String getItem(int position) {
        if(position>=0&&mDatas!=null&&mDatas.size()>position){
            return mDatas.get(position);
        }else{
            return null;
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InfoViewHolder infoViewHolder = null;
        if(convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_info,null);
            infoViewHolder = new InfoViewHolder();
            infoViewHolder.ivInfo = (ImageView)convertView.findViewById(R.id.iv_img);
            infoViewHolder.tvInfo = (TextView)convertView.findViewById(R.id.tv_info);
            convertView.setTag(infoViewHolder);
        }else{
            infoViewHolder = (InfoViewHolder)convertView.getTag();
        }
        String info = mDatas.get(position);
        infoViewHolder.tvInfo.setText(info);
        if(position%2==0){
            infoViewHolder.ivInfo.setImageResource(android.support.v7.appcompat.R.drawable.abc_ic_menu_share_mtrl_alpha);
        }else{
            infoViewHolder.ivInfo.setImageResource(android.support.v7.appcompat.R.drawable.abc_ic_star_black_36dp);
        }


        return convertView;
    }

    public class InfoViewHolder{
        private TextView tvInfo;
        private ImageView ivInfo;
    }
}
