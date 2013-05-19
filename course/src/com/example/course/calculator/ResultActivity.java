package com.example.course.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.course.R;

/**
 * Created with IntelliJ IDEA.
 * User: pairwinter
 * Date: 13-5-19
 * Time: 下午7:37
 * To change this template use File | Settings | File Templates.
 */
public class ResultActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        this.setContentView(R.layout.calculator_result);
        Intent intent = getIntent();
        TextView firstValue = (TextView)findViewById(R.id.calculator_result_firstValue);
        TextView secondValue = (TextView)findViewById(R.id.calculator_result_secondValue);
        TextView operator = (TextView)findViewById(R.id.calculator_result_operator);
        firstValue.setText(intent.getStringExtra("one"));
        secondValue.setText(intent.getStringExtra("two"));
        operator.setText(intent.getStringExtra("operator"));
    }
}
