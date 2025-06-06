package com.example.demo_constraint;

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
    EditText edtA, edtB, edtKQ;
    Button btnTong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

            // ánh xạ giao diện
            edtA = findViewById(R.id.edtA);
            edtB = findViewById(R.id.edtB);
            edtKQ = findViewById(R.id.edtKQ);
            btnTong = findViewById(R.id.btnTong);
            // xử lý click
            btnTong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int a = Integer.parseInt(edtA.getText().toString()); // lấy dữ liệu từ edtA, ép sang kiểu int và gán vào biến a
                    int b = Integer.parseInt(edtB.getText().toString());
                    int c = a + b ;
                    edtKQ.setText(c+""); // hiển thị kết quả
                }
            });


    }
}