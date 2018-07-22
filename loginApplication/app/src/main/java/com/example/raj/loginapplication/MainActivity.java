package com.example.raj.loginapplication;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button button;
    ProgressBar progressBar;
    String url="http://192.168.2.5/login/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        button=findViewById(R.id.button);
        progressBar=findViewById(R.id.progressbar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    login();
            }
        });

    }
    public void login(){
        progressBar.setVisibility(View.VISIBLE);
        button.setVisibility(View.GONE);
        final String userName= username.getText().toString();
        final String passWord= password.getText().toString();
        StringRequest request = new StringRequest(Request.Method.POST,url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               try {
                    JSONObject jsonObject= new JSONObject(response);
                    if(jsonObject.getBoolean("message")){
                        Toast.makeText(MainActivity.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        button.setVisibility(View.VISIBLE);
                        startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Login UnSuccessfull", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        button.setVisibility(View.VISIBLE);
                    }
                }catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Json Object Error"+response, Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    button.setVisibility(View.VISIBLE);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(MainActivity.this, "Server Error"+error, Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
            }
        })

        {
             @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("username",username.getText().toString().trim());
                params.put("password",password.getText().toString().trim());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
