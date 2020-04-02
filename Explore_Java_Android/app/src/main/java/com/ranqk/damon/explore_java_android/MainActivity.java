package com.ranqk.damon.explore_java_android;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.ranqk.damon.explore_java_android.extra.Extra;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    private static String STATE_NAME = "name";
    private static String STATE_AGE = "age";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null){
            Log.d(TAG, "First time to create this activity!");
        } else {
            Gson gson = new Gson();
            Log.d(TAG, "savedInstanceState existing: " + gson.toJson(savedInstanceState.keySet()));
        }
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        Intent gotoDisplayIntent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.messageText);
        gotoDisplayIntent.putExtra(Extra.CROSS_METHOD_INVOKE.getKey(), editText.getText().toString());
        startActivity(gotoDisplayIntent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "onPostResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        Log.d(TAG, "onContentChanged");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyDown");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStateNotSaved() {
        super.onStateNotSaved();
        Log.d(TAG, "onStateNotSaved");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState");
        outState.putString(STATE_NAME, "Damon Liu");
        outState.putString(STATE_AGE, "35");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}
