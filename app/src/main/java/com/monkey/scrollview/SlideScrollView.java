package com.monkey.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Description:解决ScrollView内部放置确定高度的ListView后，ListView和ScrollView都可以滑动的问题
 * Author: lanjing
 * Time: 2017/5/3 9:59
 */

public class SlideScrollView extends ScrollView {
    private ListView listView;

    public SlideScrollView(Context context) {
        super(context);
    }

    public SlideScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlideScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(checkAreaInListView(listView,ev)){
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    /**
     * 判断当前事件触发的区域是不是ListView的区域
     * @param listView
     * @param ev
     * @return
     */
    public boolean checkAreaInListView(ListView listView,MotionEvent ev){
        if(listView==null){
            return false;
        }
        float eventX = ev.getRawX();
        float eventY = ev.getRawY();
        int[] location = new int[2];
        listView.getLocationOnScreen(location);
        int listViewWidth = listView.getWidth();
        int listViewHeight = listView.getHeight();

        int left = location[0];
        int top = location[1];
        int right = left+listViewWidth;
        int bottom = top + listViewHeight;
        Log.e("MyScrollView", "eventX: "+eventX+"  eventY:"+eventY);
        Log.e("MyScrollView", "left: "+left+"  top:"+top+"   right:"+right+"   bottom:"+bottom);
        if(eventX>=left && eventX<=right
                && eventY>=top && eventY<=bottom){
            return true;
        }
        return false;
    }

    public void setListView(ListView listView){
        this.listView = listView;
    }
}
