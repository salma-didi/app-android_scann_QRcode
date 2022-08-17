package com.example.qrgenerator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class dataBase extends SQLiteOpenHelper {


    public static  final String DATABASE_NAME="register";
    public static  final String TABLE_NAME="user";
    public static  final String col1="id";
    public static  final String col2="name";
    public static  final String col3="password";
    public dataBase( Context context) {
        super(context, DATABASE_NAME,null,1);
    }



    public void queryData(String sql){
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }

    public  void insertData(String name,String password){
        SQLiteDatabase database=this.getWritableDatabase();
        String sql="INSERT INTO USER VALUES (Null,?,?)";

        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,name);
        statement.bindString(2,password);


        statement.executeInsert();

    }



    public Cursor getData(String sql){
        SQLiteDatabase database=getReadableDatabase();
        return  database.rawQuery(sql,null);

    }

   /* public  String  search(String name){
        SQLiteDatabase database=this.getReadableDatabase();
       String query="select name,password from User";
       Cursor cursor=database.rawQuery(query,null);

       String a,b;
       b="not found";
       if(cursor.moveToFirst()){
           do{
               a=cursor.getString(0);

               if(a.equals(name)){
                   b=cursor.getString(1);
                   break;
               }
           } while (cursor.moveToNext());
       }
       return b;
    }*/


   public boolean checkUser(String name,String password){
       String[] columns={col1};
       SQLiteDatabase db=getReadableDatabase();
       String selection=col2+"=?"+"and"+col3+"=?";
       String[] selectionArg={name,password};
       Cursor cursor=db.query(TABLE_NAME,columns,selection,selectionArg,null,null,null);
       int count=cursor.getCount();
       cursor.close();
       db.close();
       if(count>0)
           return true;
       else
           return false;

   }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE IF NOT EXISTS USER (ID INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,password VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
   db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
   onCreate(db);
    }
}
