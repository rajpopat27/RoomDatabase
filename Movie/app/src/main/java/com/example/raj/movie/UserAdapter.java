package com.example.raj.movie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


class UserAdapter extends RecyclerView.Adapter<UserAdapter.Viewholder> {
    ArrayList<UserData> list;
    LayoutInflater layoutInflater;
    public UserAdapter(Context context) {
        list=Singleton.getInstance().getList();
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        UserData current = list.get(position);
        holder.textView.setText(current.getName());
        holder.textView1.setText(current.getEmail());
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView1;
        public Viewholder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text1);
            textView1=itemView.findViewById(R.id.text2);
        }
    }
}
