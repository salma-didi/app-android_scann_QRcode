package com.example.qrgenerator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;


public class userListAdapter extends BaseAdapter {
  private Context context;
  private int layout;
  private ArrayList<user> userList;

    public userListAdapter(Context context, int layout, ArrayList<user> userList) {
        this.context = context;
        this.layout = layout;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class viewHolder{
    // ImageView imageView;
     TextView name;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View row=view;
       viewHolder holder=new viewHolder() ;

       if(row == null){
           LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
           row=inflater.inflate(layout,null);
           holder.name=(TextView) row.findViewById(R.id.nameUser);
         //  holder.imageView=(ImageView)  row.findViewById(R.id.imageUser);
           row.setTag(holder);

        } else {
           holder =(viewHolder) row.getTag();
       }

       user user=userList.get(position);

       holder.name.setText(user.getName());

       /*byte[] userImage=user.getImage();
        Bitmap bitmap= BitmapFactory.decodeByteArray(userImage,0,userImage.length);
        holder.imageView.setImageBitmap(bitmap);*/


        return row;
    }
}
