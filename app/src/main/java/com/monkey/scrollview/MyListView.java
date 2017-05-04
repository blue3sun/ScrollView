package com.monkey.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Description:解决ListView放在ScrollView里面高度显示不全（只显示一行的高度）的问题
 * Author: lanjing
 * Time: 2017/5/3 9:28
 */

public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>> 2,MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }
}
