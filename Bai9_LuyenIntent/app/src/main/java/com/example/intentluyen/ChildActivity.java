package com.example.intentluyen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChildActivity extends AppCompatActivity {
    EditText edtnhan;
    Button btngoc, btnbinh;
    // khai báo intent
    Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_child);
        // ánh xạ
        edtnhan = findViewById(R.id.edtnhan);
        btngoc = findViewById(R.id.btngoc);
        btnbinh = findViewById(R.id.btnbinh);
        // nhận intent
        myintent = getIntent();
        int a = myintent.getIntExtra("soa", 0);
        edtnhan.setText(a+"");
        btngoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myintent.putExtra("kq",a);
                setResult(33, myintent);
                finish();
            }
        });
        btnbinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myintent.putExtra("kq", a*a);
                setResult(55, myintent);
                finish();
            }
        });
    }
}