package com.example.securityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class details extends AppCompatActivity {
EditText e1,e2,e3,e4;
String getFirst,getLast,getPurpose,getWhom;
Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        e1=(EditText)findViewById(R.id.first);
        e2=(EditText)findViewById(R.id.last);
        e3=(EditText)findViewById(R.id.purpose);
        e4=(EditText)findViewById(R.id.whomtomeet);
        b1=(Button)findViewById(R.id.sub);
        b2=(Button)findViewById(R.id.bm);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFirst=e1.getText().toString();
                getLast=e2.getText().toString();
                getPurpose=e3.getText().toString();
                getWhom=e4.getText().toString();
                if(getFirst.isEmpty()||getLast.isEmpty()||getPurpose.isEmpty()||getWhom.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"all fields are mandatory",Toast.LENGTH_LONG).show();
                }
                else
                {
                    callApi();
                }
            }

            private void callApi() {
                String apiurl="https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data=new JSONObject();
                try {
                    data.put("firstname",getFirst);
                    data.put("lastname",getLast);
                    data.put("purpose",getPurpose);
                    data.put("whomToMeet",getWhom);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                JsonObjectRequest request=new JsonObjectRequest(
                        Request.Method.POST,
                        apiurl,
                        data,
                        response -> Toast.makeText(getApplicationContext(),"successfully added",Toast.LENGTH_LONG).show(),
                        error -> Toast.makeText(getApplicationContext(),"successfully added",Toast.LENGTH_LONG).show()
                );
                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                queue.add(request);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}