package com.example.raj.movie;

import java.util.ArrayList;

/**
 * Created by RAJ on 2/25/2018.
 */

public class Singleton {
    static Singleton instance;
    ArrayList<UserData> list;
    Singleton(){
        list= getList();
    }
    static Singleton getInstance(){
     if(instance==null){
         instance=new Singleton();
     }
     return instance;
    }
    ArrayList<UserData> getList(){
        if (list==null){
            list=new ArrayList<>();
        }
        return list;
    }
}
