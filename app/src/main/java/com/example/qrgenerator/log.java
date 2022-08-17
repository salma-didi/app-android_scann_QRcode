package com.example.qrgenerator;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class log extends AppCompatActivity {

    EditText name,password;
    TextView textView;
    Button logBtn;
    dataBase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

db=new dataBase(this);
        name=(EditText) findViewById(R.id.name2) ;
        password=(EditText) findViewById(R.id.password2) ;
        textView=(TextView) findViewById(R.id.text2) ;
        logBtn=(Button) findViewById(R.id.log) ;

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent=new Intent(log.this,compte.class);
                startActivity(registerIntent);
            }
        });


      /*  logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=name.getText().toString();
                String b=password.getText().toString();

                String pass=compte.data.search(a);

                if(b.equals(pass)){
                    Intent intent=new Intent(log.this,menus.class);
                    intent.putExtra("username",a);
                    startActivity(intent);

                } else {
                    Toast temp=Toast.makeText(log.this,"Username and password don't match",Toast.LENGTH_SHORT);
                    temp.show();
                }



            }
        });*/

      logBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String a=name.getText().toString();
              String b=password.getText().toString();
              Boolean res=db.checkUser(a,b);
              if(res == true){
                  Toast.makeText(log.this,"successfully log in",Toast.LENGTH_SHORT).show();
                  Intent intent=new Intent(log.this,menus.class);
                  startActivity(intent);
              }
              else {
                  Toast.makeText(log.this,"error log in",Toast.LENGTH_SHORT).show();
              }

          }
      });


    }
}
