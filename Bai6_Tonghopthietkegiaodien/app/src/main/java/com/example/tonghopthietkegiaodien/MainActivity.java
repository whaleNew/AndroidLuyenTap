package com.example.tonghopthietkegiaodien;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edthoten, edtcccd, edtbosung;
    Button btngui;
    RadioGroup idgroup;
    CheckBox chkdocbao, chkdocsach, chkcoding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    // ánh xạ id
        edthoten = findViewById(R.id.edthoten);
        edtcccd = findViewById(R.id.edtcccd);
        edtbosung = findViewById(R.id.edtbosung);
        btngui  = findViewById(R.id.btngui);
        idgroup = findViewById(R.id.idgroup);
        chkdocsach = findViewById(R.id.chkdocsach);
        chkdocbao = findViewById(R.id.chkdocbao);
        chkcoding = findViewById(R.id.chkcoding);
        // xử lý click
        btngui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edthoten.getText().toString();
                if(hoten.length()<3)
                {
                    Toast.makeText(MainActivity.this, "Họ và tên >= 3 ký tự", Toast.LENGTH_LONG).show();
                    edthoten.requestFocus();
                    edthoten.selectAll();
                    return;
                }
                // lấy thông tin cmnd
                String cccd = edtcccd.getText().toString();
                if(cccd.length()!=9)
                {
                    Toast.makeText(MainActivity.this, "CCCD phải đúng 9 số", Toast.LENGTH_LONG).show();
                    edtcccd.requestFocus();
                    edtcccd.selectAll();
                    return;
                }
                // lấy thông tin bằng cấp
                int idselect = idgroup.getCheckedRadioButtonId();
                RadioButton radselect = findViewById(idselect);
                String bangcap = radselect.getText().toString();
                // lấy thông tin sở thích
                String sothich = "";
                if(chkdocsach.isChecked())
                    sothich += chkdocsach.getText().toString()+"-";
                if(chkdocbao.isChecked())
                    sothich += chkdocbao.getText().toString()+"-";
                if(chkcoding.isChecked())
                    sothich += chkcoding.getText().toString()+"-";
                // lấy thông tin bổ sung
                String bosung = edtbosung.getText().toString();
                String tonghop = "";
                tonghop += "Họ và tên:" + hoten + "\n";
                tonghop += "CCCD:" + cccd + "\n";
                tonghop += "Bằng cấp:" + cccd + "\n";
                tonghop += "Sở thích:" + sothich + "\n";
                tonghop += "-----THÔNG TIN BỔ SUNG-----\n";
                tonghop +=bosung+"\n";
                // tạo dialog và hiển thị thông tin tổng hợp
                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("THÔNG TIN CÁ NHÂN");
                mydialog.setMessage(tonghop);
                mydialog.setPositiveButton("ĐÓNG", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                    mydialog.create().show();
            }

        });
    }
}