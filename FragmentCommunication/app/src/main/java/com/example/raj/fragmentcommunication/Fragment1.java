package com.example.raj.fragmentcommunication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment1 extends Fragment implements View.OnClickListener {
        Button b;
    public int count;
    communication c;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment1, container, false);
        b=(Button) view.findViewById(R.id.button1);
        b.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        c= (communication) getActivity();
    }

    @Override
    public void onClick(View v) {
        count++;
        String str = "The value of Count is : "+count;
        c.sendData(str);
    }
}
