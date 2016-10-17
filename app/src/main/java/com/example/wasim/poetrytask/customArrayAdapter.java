/*
package com.example.wasim.poetrytask;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

*/
/**
 * Created by HP on 10/3/2016.
 *//*

public class customArrayAdapter extends ArrayAdapter<String> {
    PoetryDBHelper dbHelper = new PoetryDBHelper(getContext());
    Context context;
    List<String> objects= dbHelper.getTitle();
    Poetry poetry;
    ImageView iv;
    ViewPoetry viewPoetry = new ViewPoetry();
    public customArrayAdapter(Context context, List<String> tit) {
        super(context,R.layout.customview, tit);
        this.context = context;
        this.objects = tit;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String title = objects.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.customview,null);
        ImageView imageView22 = (ImageView) view.findViewById(R.id.imageView2);
        TextView t2 = (TextView) view.findViewById(R.id.textView2);
        TextView t3 = (TextView) view.findViewById(R.id.textView3);
        dbHelper.open();
      //  tv_name.setText(poetry.getType());String d = new String();
        String d = new String();
        d = dbHelper.getDescription(title);
       // int res = g
     //  int res = getResources().getIdentifier(d.toString(),"drawable",getPackageName());
    //    imageView22.setImageResource(res);
       // Log.d("image" , d.toString());

      //  dbHelper.open();
   int count = dbHelper.countData(title);
   // String countdata = Integer.toString(count);
        t2.setText(objects.get(position));
        t3.setText(count+"");
        return view;
    }

}
*/
