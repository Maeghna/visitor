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
                Toast.makeText(getApplicationContext(),(getFirst+" "+getLast+" "+getPurpose+" "+getWhom),Toast.LENGTH_LONG).show();
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