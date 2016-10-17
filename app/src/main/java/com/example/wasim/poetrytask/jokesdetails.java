package com.example.wasim.poetrytask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class jokesdetails extends AppCompatActivity {
    PoetryDBHelper dbHelper;
    ViewPoetry viewp;
    String it;
    List<String> title = new ArrayList<>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokesdetails);
        ImageView imageView22 = (ImageView) findViewById(R.id.imageView3);

        ListView listView32 = (ListView) findViewById(R.id.listView32);
        dbHelper = new PoetryDBHelper(this);
        viewp= new ViewPoetry();
        it = getIntent().getStringExtra("type");
        title = dbHelper.getFamily(it);
        int res = getResources().getIdentifier(it,"drawable",getPackageName());
        imageView22.setImageResource(res);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, title);
        listView32.setAdapter(adapter);
    }
}
