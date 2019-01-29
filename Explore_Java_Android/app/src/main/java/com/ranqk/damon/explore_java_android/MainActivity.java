package com.ranqk.damon.explore_java_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.ranqk.damon.explore_java_android.extra.Extra;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        Intent gotoDisplayIntent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.messageText);
        gotoDisplayIntent.putExtra(Extra.CROSS_METHOD_INVOKE.getKey(), editText.getText().toString());
        startActivity(gotoDisplayIntent);
    }
}
