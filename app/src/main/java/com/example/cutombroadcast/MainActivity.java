package com.example.cutombroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MyReceiver myReceiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);



        this.registerReceiver(myReceiver,intentFilter);
    }

//To save system resources and avoid leaks, dynamic receivers must be unregistered when they are no longer needed or
// before the corresponding activity or app is destroyed,
// depending on the context used.

// but static receiver dont need that...they are always onLine

    @Override
    protected void onDestroy() {

        this.unregisterReceiver(myReceiver);
        super.onDestroy();
    }
}