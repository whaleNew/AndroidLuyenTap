package com.example.intentluyen;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edta, edtb;
    Button btnchild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // ánh xạ
        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        btnchild = findViewById(R.id.btnchild);
        btnchild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, ChildActivity.class);
                int a = Integer.parseInt(edta.getText().toString());
                // đưa data vào intent
                myintent.putExtra("soa", a);
                startActivityForResult(myintent, 99);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode == 33)
        {
            int kq = data.getIntExtra("kq", 0);
            edtb.setText("giá trị gốc :" + kq);
        }
        if (requestCode == 99 && resultCode == 55)
        {
            int kq = data.getIntExtra("kq", 0);
            edtb.setText("giá trị bình phương là: " +kq);
        }
    }
}