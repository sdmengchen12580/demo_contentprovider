package com.example.yunwen.myselfweblist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// TODO: 2017/9/26 这个类，专门调用系统的
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(MainActivity.this,MyService.class));
    }

 }
