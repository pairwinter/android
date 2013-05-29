package com.example.course;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.course.tool.ToastTool;

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
    private Map<Integer,String> checkboxs = new HashMap<Integer, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.layout_test);
        processGridView((GridView) findViewById(R.id.layout_test_gridview));
        processCheckbox();
        processRadioGroup();
    }

    private void processGridView(GridView gridView){
        List<Map<String,Object>> gridData = new ArrayList<Map<String, Object>>();
        for (int i=1;i<=3;i++){
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
                default:break;
            }
            rowMap.put("layout_grid_item_imageview",icon);
            rowMap.put("layout_grid_item_textview",i+"");
            gridData.add(rowMap);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,gridData,R.layout.layout_gridview_item,new String[]{"layout_grid_item_imageview","layout_grid_item_textview"},new int[]{R.id.layout_grid_item_imageview,R.id.layout_grid_item_textview});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new GridItemClickListener());
    }

    private void processCheckbox(){
        CheckBox checkBox1 = (CheckBox)findViewById(R.id.widgets_test_checkbox1);
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.widgets_test_checkbox2);
        CheckBox checkBox3 = (CheckBox)findViewById(R.id.widgets_test_checkbox3);
        checkBox1.setOnCheckedChangeListener(new OnCheckBoxChangeListener());
        checkBox2.setOnCheckedChangeListener(new OnCheckBoxChangeListener());
        checkBox3.setOnCheckedChangeListener(new OnCheckBoxChangeListener());
    }

    /**
     * process RadioGroup
     */
    private void processRadioGroup(){
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.widgets_test_radiogroup);
        radioGroup.setOnCheckedChangeListener(new OnRadioGroupChangeListener());
    }

    /**
     * GridView click listener
     */
    class GridItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ToastTool.showToast(getApplicationContext(),"You have pressed "+(position + 1));
        }
    }

    /**
     * Checkbox change listener
     */
    class OnCheckBoxChangeListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            //To change body of implemented methods use File | Settings | File Templates.
            if(isChecked){
                String selected="",tips = "";
                if(!checkboxs.containsKey(buttonView.getId())){
                    checkboxs.put(buttonView.getId(),buttonView.getText().toString());
                }
                for(Integer key : checkboxs.keySet()){
                    tips+=checkboxs.get(key)+" ";
                }
                if(buttonView.getId() == R.id.widgets_test_checkbox1){
                    selected = "You selected CheckBox 1";
                }else if(buttonView.getId() == R.id.widgets_test_checkbox2){
                    selected = "You selected CheckBox 2";
                }else if(buttonView.getId() == R.id.widgets_test_checkbox3){
                    selected = "You selected CheckBox 3";
                }
                if(tips.length()>0){
                    selected = selected + "\n" +tips;
                }
                ToastTool.showToast(getApplicationContext(),selected);
            }else{
                checkboxs.remove(buttonView.getId());
                String tips = "";
                for(Integer key : checkboxs.keySet()){
                    tips+=checkboxs.get(key)+" ";
                }
                if(tips.length()>0){
                    ToastTool.showToast(getApplicationContext(),tips);
                }
            }
        }
    }

    class OnRadioGroupChangeListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            //To change body of implemented methods use File | Settings | File Templates.
            if(checkedId == R.id.widgets_test_radio1){
                ToastTool.showToast(getApplicationContext(),"You selected Radio "+ "1");
            }else if(checkedId == R.id.widgets_test_radio2){
                ToastTool.showToast(getApplicationContext(),"You selected Radio "+ "2");
            }else if(checkedId == R.id.widgets_test_radio3){
                ToastTool.showToast(getApplicationContext(),"You selected Radio "+ "3");
            }
        }
    }

    @Override
    protected void onDestroy() {
        ToastTool.cancelToast();
        super.onDestroy();    //To change body of overridden methods use File | Settings | File Templates.
        Log.d("Damon's Log","=============destroy============");
    }


}
