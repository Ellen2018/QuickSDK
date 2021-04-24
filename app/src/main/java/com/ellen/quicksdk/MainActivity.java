package com.ellen.quicksdk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.ellen.sdk.SuperHandler;
import com.ellen.sdk.SuperIntent;

public class MainActivity extends AppCompatActivity {

    private int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SuperIntent
                        .Builder()
                        .putData("a",1)
                        .putData("b","b")
                        .putData("c", new int[]{2, 3, 4, 5})
                        .build()
                        .startActivity(MainActivity.this,MainActivity2.class);
            }
        });

        SuperHandler<MainActivity> superHandler = new SuperHandler<>(this);
        superHandler.setHandlerMessageCallback(new SuperHandler.HandlerMessageCallback<MainActivity>() {
            @Override
            public void handleMessage(MainActivity activity, @NonNull Message msg) {
                activity.a++;
                Log.e("Ellen2021",String.valueOf(activity.a));
            }
        });

        superHandler.sendEmptyMessage(0);
    }
}