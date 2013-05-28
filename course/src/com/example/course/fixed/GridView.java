package com.example.course.fixed;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created with IntelliJ IDEA.
 * User: damon
 * Date: 5/28/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class GridView extends android.widget.GridView {
    public GridView(Context context) {
        super(context);
    }

    public GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
