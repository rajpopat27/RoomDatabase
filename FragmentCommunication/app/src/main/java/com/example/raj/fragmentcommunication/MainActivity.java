package com.example.raj.fragmentcommunication;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements communication{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendData(String data) {
      Fragment2 fragment2= (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);
      fragment2.changeText(data);
    }
}
