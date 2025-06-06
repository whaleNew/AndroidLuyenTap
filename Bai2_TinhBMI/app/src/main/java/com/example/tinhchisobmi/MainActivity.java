package com.example.tinhchisobmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // khai báo các biến giao diện
    EditText edtW,edtH, edtbmi;
    Button btnkq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    // ánh xạ giao diện
        edtW    = findViewById(R.id.edtW); // cân nặng
        edtH    = findViewById(R.id.edtH); // chiều cao
        edtbmi  = findViewById(R.id.edtbmi);
        btnkq   = findViewById(R.id.btnkq);
    // xử lý click
        btnkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float cannang   = Float.parseFloat((edtW.getText().toString()));
                float chieucao  = Float.parseFloat((edtH.getText().toString()));
                float doi       = chieucao / 100;
                float bmi       = cannang / (doi*doi);
                edtbmi.setText(bmi+""); // kết quả BMI
                edtbmi.setText(String.format("%.1f", bmi));
            }
        });
    }
}