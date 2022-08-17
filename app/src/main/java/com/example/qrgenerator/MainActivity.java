package com.example.qrgenerator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {
EditText qrvalue;
Button generateBtn,scanBtn;
ImageView qrImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qrvalue=findViewById(R.id.editText);
        generateBtn=findViewById(R.id.generateBtn);
        scanBtn=findViewById(R.id.scanBtn);
        qrImage=findViewById(R.id.imageView);
        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=qrvalue.getText().toString();
                QRGEncoder qrgEncoder= new QRGEncoder(data,null, QRGContents.Type.TEXT,100);

              try{
                  Bitmap bitmap=qrgEncoder.encodeAsBitmap();
                  qrImage.setImageBitmap(bitmap);

              } catch (Exception e) {
                  e.printStackTrace();
              }

            }
        });

        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),scann.class));
            }
        });
    }
}
