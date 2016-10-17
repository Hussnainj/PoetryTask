package com.example.wasim.poetrytask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewPoetry extends AppCompatActivity {
   PoetryDBHelper dbhelper;
    ListView listView;
    List<Poetry> poetry;
   public List<String> tit = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_poetry);
listView = (ListView) findViewById(R.id.listView1);
        dbhelper = new PoetryDBHelper(this);
       //String title ="Lyric";
       // poetry= dbhelper.retreiveAll(title);
        //Log.i("value",poetry.toString());
        tit = dbhelper.getTitle();

        Log.d("ddd" ,tit.toString());
        ArrayAdapter customarray = new customArrayAdapter(ViewPoetry.this,tit );
        listView.setAdapter(customarray);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ViewPoetry.this,jokesdetails.class);
                String ty = listView.getItemAtPosition(i).toString();

                intent.putExtra("type", ty);
                startActivity(intent);

            }
        });

    }

    public class customArrayAdapter extends ArrayAdapter<String> {
        PoetryDBHelper dbHelper ;
        Context context;
        List<String> objects;
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
            String title =tit.get(position);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.customview,null);
            TextView t2 = (TextView) view.findViewById(R.id.textView2);
            TextView t3 = (TextView) view.findViewById(R.id.textView3);
              //dbHelper.open();
            //  tv_name.setText(poetry.getType());
            //    String d = new String();
            // d = dbHelper.getDescription(title);
            ImageView imageView22 = (ImageView) view.findViewById(R.id.imageView2);
             int res = getResources().getIdentifier(title,"drawable",getPackageName());
            imageView22.setImageResource(res);
            //imageView.setImageResource(res);
            // Log.d("image" , d.toString());
            //  dbHelper.open();
            //  dbHelper.open();
            int count = dbhelper.countData(title);
            // String countdata = Integer.toString(count);
            t2.setText(objects.get(position));
            t3.setText(count+"");
            return view;
        }
}

}
