package com.example.chuyendoinhietdo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // khai báo các biến giao diện
    EditText edtF, edtC;
    Button btnFC, btnCF, btnclear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    // ánh xạ Id
        edtF = findViewById(R.id.edtF);
        edtC = findViewById(R.id.edtC);
        btnFC = findViewById(R.id.btnFC);
        btnCF = findViewById(R.id.btnCF);
        btnclear = findViewById(R.id.btnclear);
    // xử lý tương tác
        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c = Integer.parseInt(edtC.getText().toString());
                double f = c*1.8 + 32;
                edtF.setText(f+"");
                edtF.setText(String.format("%.1f",f));
            }
        });
        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int f = Integer.parseInt(edtF.getText().toString());
                double c = (f-32) / 1.8;
                edtC.setText(c+"");
                edtC.setText(String.format("%.1f",c));
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtF.setText("");
                edtC.setText("");
            }
        });
    }
}