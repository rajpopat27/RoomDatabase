package com.example.raj.bottomnavigation;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    FrameLayout frameLayout;
    FragmentA fragmentA;
    FragmentB fragmentB;
    FragmentC fragmentC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView=findViewById(R.id.nav_bar);
        frameLayout=findViewById(R.id.container1);
        fragmentA=new FragmentA();
        fragmentB=new FragmentB();
        fragmentC=new FragmentC();
        setFragment(fragmentA);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        setFragment(fragmentA);
                        return true;
                    case R.id.nav_account:
                        setFragment(fragmentB);
                        return true;
                    case R.id.nav_contact:
                        setFragment(fragmentC);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(android.support.v4.app.Fragment fragment) {
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container1,fragment);
        transaction.commit();
    }
}
