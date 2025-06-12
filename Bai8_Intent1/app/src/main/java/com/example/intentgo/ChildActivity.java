package com.example.intentgo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChildActivity extends AppCompatActivity {
    TextView txtkq;
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_child);
    // ánh xạ
        txtkq = findViewById(R.id.txtkq);
        btnback = findViewById(R.id.btnback);
        // nhận intent
        Intent myintent = getIntent();
        // lấy bundle
        Bundle mybundle = myintent.getBundleExtra("mypackage");
        int a = mybundle.getInt("soa");
        int b = mybundle.getInt("sob");
        // Giải pt và hiển thị kq
        String nghiem = "";
        if (a == 0 & b == 0)
        {
            nghiem = "PT vô số nghiệm";
        }
        else if(a == 0 & b != 0)
        {
            nghiem = "PT vô nghiệm";
        }
        else
        {
            nghiem = "Nghiệm PT bằng: " + (-1.0)*b/a;
        }
        txtkq.setText(nghiem);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}