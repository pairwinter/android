package com.example.course;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: damon
 * Date: 5/27/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class LayoutTest extends Activity{
    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.layout_test);
        GridView gridView = (GridView)findViewById(R.id.layout_test_grid);
        List<Map<String,Object>> gridData = new ArrayList<Map<String, Object>>();
        for (int i=1;i<=10;i++){
            Map<String,Object> rowMap = new HashMap<String, Object>();
            int icon = 0;
            switch (i){
                case 1:icon = R.drawable.grid_item_icon1;break;
                case 2:icon = R.drawable.grid_item_icon2;break;
                case 3:icon = R.drawable.grid_item_icon3;break;
                case 4:icon = R.drawable.grid_item_icon4;break;
                case 5:icon = R.drawable.grid_item_icon5;break;
                case 6:icon = R.drawable.grid_item_icon6;break;
                case 7:icon = R.drawable.grid_item_icon7;break;
                case 8:icon = R.drawable.grid_item_icon8;break;
                case 9:icon = R.drawable.grid_item_icon9;break;
                case 10:icon = R.drawable.grid_item_icon10;break;

            }
            rowMap.put("layout_grid_item_imageview",icon);
            rowMap.put("layout_grid_item_textview",i+"");
            gridData.add(rowMap);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,gridData,R.layout.layout_grid_item,new String[]{"layout_grid_item_imageview","layout_grid_item_textview"},new int[]{R.id.layout_grid_item_imageview,R.id.layout_grid_item_textview});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new GridItemClickListener());
        Log.d("Damon's Log",gridView.getMeasuredHeight()+"");
        gridView.setMinimumHeight(gridView.getMeasuredHeight());
    }

    @Override
    protected void onDestroy() {
        if(toast!=null){
            toast.cancel();
        }
        super.onDestroy();    //To change body of overridden methods use File | Settings | File Templates.
        Log.d("Damon's Log","=============destroy============");
    }

    class GridItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(toast!=null){
                toast.cancel();
                toast.setText("You have pressed "+(position + 1));
                toast.show();
            }else{
                toast = Toast.makeText(getApplicationContext(),"You have pressed "+(position + 1),0);
                toast.show();
            }
        }
    }
}
