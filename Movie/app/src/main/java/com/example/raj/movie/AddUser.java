package com.example.raj.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUser extends AppCompatActivity {
    EditText name;
    EditText email;
    Button add;
   // ArrayList<UserData> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        add=findViewById(R.id.add);
        //arrayList=(ArrayList<UserData>) getIntent().getSerializableExtra("list");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData data=new UserData();
                data.setName(name.getText().toString());
                data.setEmail(email.getText().toString());
                Singleton.getInstance().getList().add(data);
                Toast.makeText(AddUser.this, "Added", Toast.LENGTH_SHORT).show();
                Toast.makeText(AddUser.this, "size"+Singleton.getInstance().getList().size(), Toast.LENGTH_SHORT).show();
                MainActivity.flag=true;
                Intent intent=new Intent(AddUser.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
