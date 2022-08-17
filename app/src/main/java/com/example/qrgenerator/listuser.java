package com.example.qrgenerator;


import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class listuser extends AppCompatActivity {

    GridView gridView;
    ArrayList<user> list;
    userListAdapter adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listuser);


        gridView=(GridView) findViewById(R.id.gridView);
        list =new ArrayList<>();
        adapter=new userListAdapter(this,R.layout.user,list);
        gridView.setAdapter(adapter);

        Cursor cursor=compte.data.getData("SELECT * FROM user");
        list.clear();
        while(cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
           // byte[] image=cursor.getBlob(2);

            list.add(new user(id,name));
        }
        adapter.notifyDataSetChanged();
    }
}
