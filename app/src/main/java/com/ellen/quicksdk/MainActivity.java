package com.ellen.quicksdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.ellen.sdk.SuperIntent;

public class MainActivity extends AppCompatActivity {

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
                        .build()
                        .startActivity(MainActivity.this,MainActivity2.class);
            }
        });

    }
}