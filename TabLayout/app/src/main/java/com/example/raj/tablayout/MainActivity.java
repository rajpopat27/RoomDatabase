package com.example.raj.tablayout;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SectionsPagerAdapter adapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.container1);
        setPagerView(viewPager);
       tabLayout=findViewById(R.id.tabs);
       tabLayout.setupWithViewPager(viewPager);
    }
    public void setPagerView (ViewPager viewPager){
        adapter= new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragments(new Fragment1(),"Tab1");
        adapter.addFragments(new Fragment2(),"Tab2");
        adapter.addFragments(new Fragment3(),"Tab3");
        viewPager.setAdapter(adapter);
    }
}
