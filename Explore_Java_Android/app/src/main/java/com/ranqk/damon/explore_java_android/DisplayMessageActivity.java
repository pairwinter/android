package com.ranqk.damon.explore_java_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ranqk.damon.explore_java_android.extra.Extra;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Extra.CROSS_METHOD_INVOKE.getKey());
        TextView textView = findViewById(R.id.messageView);
        textView.setText(message);
    }
}
