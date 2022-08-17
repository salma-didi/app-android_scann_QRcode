package com.example.qrgenerator;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class menus extends AppCompatActivity {
    GridLayout gridLayout;
    CardView cardView1,cardView2,cardView3,cardView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        gridLayout =(GridLayout) findViewById(R.id.mainGrid);
        cardView1=(CardView) findViewById(R.id.item1);
        cardView2=(CardView) findViewById(R.id.item2);
        cardView3=(CardView) findViewById(R.id.item3);
        cardView4=(CardView) findViewById(R.id.item4);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),scann.class));
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),historique.class));
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menus.this,listuser.class);
                startActivity(intent);
            }
        });

    }
}
