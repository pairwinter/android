package com.example.course.calculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.*;
import com.example.course.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: pairwinter
 * Date: 13-5-19
 *  Time: 下午3:00
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorActivity extends Activity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private EditText editText1;
    private EditText editText2;
    private Spinner operateSpinner;
    private String[] operatorValues = new String[]{"+","-","*","/"};
    private String operateSpinnerValue="+";
    private Button runButton;
    private AlertDialog invalidAlertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.calculator);
        invalidAlertDialog = initInvalidAlertDialog();
        textView1 = (TextView)findViewById(R.id.calculator_tv_first_name);
        textView2 = (TextView)findViewById(R.id.calculator_tv_second_name);
        editText1 = (EditText)findViewById(R.id.calculator_et_first_value_id);
        editText2 = (EditText)findViewById(R.id.calculator_et_second_value_id);
        operateSpinner = (Spinner)findViewById(R.id.calculator_spinner_operator);
        operateSpinner.setSelection(0,true);
        runButton = (Button)findViewById(R.id.calculator_button_run);
        operateSpinner.setOnItemSelectedListener(new OperatorSpinnerChangeListener());
        runButton.setOnClickListener(new RunButtonClickListener());
    }

    private AlertDialog initInvalidAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.invalid_dialog_title);
        builder.setPositiveButton(R.string.ok,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //To change body of implemented methods use File | Settings | File Templates.

            }
        });
        return builder.create();
    }
    private boolean isNumber(String text){
        if(text == null || text.trim().length()==0) return false;
        Pattern pattern = Pattern.compile("^(([1-9]\\d*)|(0))$");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            return true;
        }
        return false;
    }

    class OperatorSpinnerChangeListener implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //To change body of implemented methods use File | Settings | File Templates.
            operateSpinnerValue = operatorValues[position];
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            //To change body of implemented methods use File | Settings | File Templates.
            operateSpinnerValue = operatorValues[0];
        }
    }

    class RunButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //To change body of implemented methods use File | Settings | File Templates.
            String val1 = editText1.getText().toString();
            String val2 = editText2.getText().toString();
            String invalidWidgetName = "";
            if(val1.trim().length()==0 || !isNumber(val1)){
                invalidWidgetName = textView1.getText().toString();
            }else if(val2.trim().length()==0 || !isNumber(val2)){
                invalidWidgetName = textView2.getText().toString();
            }else if(operateSpinnerValue.trim().length()==0){
                invalidWidgetName = textView3.getText().toString();
            }
            if(invalidWidgetName.length()>0){
                invalidAlertDialog.setMessage(getResources().getString(R.string.invalid_field).replace("{0}",invalidWidgetName));
                invalidAlertDialog.show();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("one",val1);
            intent.putExtra("two",val2);
            intent.putExtra("operator",operateSpinnerValue);
            intent.setClass(CalculatorActivity.this,ResultActivity.class);
            startActivity(intent);
        }
    }
}
