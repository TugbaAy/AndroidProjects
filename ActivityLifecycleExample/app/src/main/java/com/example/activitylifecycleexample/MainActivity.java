package com.example.activitylifecycleexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    int x = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("message", "onCreate() method");
        x = 1000;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("message", "onStart() method");
        x = 1002;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("message", "onStop() method");
        x = 1003;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("message", "onDestroy() method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("message", "onPause() method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("message", "onResume() method");
    }

}
