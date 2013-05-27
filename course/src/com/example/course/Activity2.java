package com.example.course;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: pairwinter
 * Date: 13-5-12
 * Time: 下午2:54
 * To change this template use File | Settings | File Templates.
 */
public class Activity2 extends Activity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.activity2_main);
        button = (Button)findViewById(R.id.back);
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra("extraData"));
        button.setOnClickListener(new BackButtonListener());
    }

    class BackButtonListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            //To change body of implemented methods use File | Settings | File Templates.
            Activity2.this.finish();
        }
    }
}
