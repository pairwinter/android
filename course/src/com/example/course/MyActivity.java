package com.example.course;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
* 创建Activity的要点
* 1.一个Activity就是一个类，并且这个类要继承Activity
* 2.需要重写onCreate方法
* 3.每一个Activity都需要在AndroidManifest.xml文件中配置
* 4.为Activity添加必要的控件
* */
public class MyActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView textView = (TextView)findViewById(R.id.textView);
        Button button = (Button)findViewById(R.id.button);
        textView.setText("My first Activity TextView");
        button.setText("My first "+"\n"+ "Activity Button");
        Button forwardButton = (Button)findViewById(R.id.forward);
        forwardButton.setOnClickListener(new ForwardButtonListener());
    }

    class ForwardButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //To change body of implemented methods use File | Settings | File Templates.
            Intent intent = new Intent();
            intent.putExtra("extraData","abc");
            intent.setClass(MyActivity.this,Activity2.class);
            MyActivity.this.startActivity(intent);
        }
    }
}
