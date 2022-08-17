package com.example.qrgenerator;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class compte extends AppCompatActivity {

    EditText name,password,passwordCon;
    Button AddUser;
    TextView accountEx;
    dataBase db;



    public static dataBase data;

    final int REQUEST_CODE_GALLERY=999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compte);


        init();
       /* data= new dataBase(this,"dataBase",null,1);

        data.queryData("CREATE TABLE IF NOT EXISTS USER (ID INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,password VARCHAR)");*/


  db=new dataBase(this);

        AddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                try{

                    data.insertData(name.getText().toString(),password.getText().toString());

                    Toast.makeText(getApplicationContext(),"Add successfully",Toast.LENGTH_SHORT).show();

                    name.setText("");
                    password.setText("");

                } catch (Exception e) {
                    e.printStackTrace();
                }*/
                String user=name.getText().toString().trim();
                String pwd=password.getText().toString();
                String pwd_cf=passwordCon.getText().toString();

                if(pwd.equals(pwd_cf)){
                    db.insertData(user,pwd);
                    Toast.makeText(compte.this,"enregistred successfully",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(compte.this,menus.class);
                    startActivity(intent);
                }  else{
                    Toast.makeText(compte.this,"password is not matching",Toast.LENGTH_SHORT).show();
                }

            }
        });

        passwordCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent=new Intent(compte.this,log.class);
                startActivity(registerIntent);
            }
        });
    }


  /*  private byte[] imageViewToByte(ImageView image) {

        Bitmap bitmap=((BitmapDrawable) image.getDrawable() ).getBitmap();
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray=stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode  == REQUEST_CODE_GALLERY){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_GALLERY);
            } else {
                Toast.makeText(getApplicationContext(),"you don't have permission to access file location",Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode  == REQUEST_CODE_GALLERY && requestCode == RESULT_OK && data!= null){
            Uri uri=data.getData();
            try {
                InputStream inputStream=getContentResolver().openInputStream(uri);

                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);

                imageUser.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }



        super.onActivityResult(requestCode, resultCode, data);
    }*/

    private void init(){
        name= (EditText) findViewById(R.id.name);
        password= (EditText) findViewById(R.id.password);
        passwordCon= (EditText) findViewById(R.id.password3);
        accountEx=(TextView) findViewById(R.id.text3);
        AddUser= (Button) findViewById(R.id.addUser);
    }
}
