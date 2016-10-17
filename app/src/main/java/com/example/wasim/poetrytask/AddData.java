package com.example.wasim.poetrytask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddData extends AppCompatActivity {
    PoetryDBHelper dbHelper;
    EditText etitle, etype, edescription;
    Spinner spinner;
    String spinnervalue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);


        etitle = (EditText) findViewById(R.id.editText);
       // etype = (EditText) findViewById(R.id.editText2);
        edescription = (EditText) findViewById(R.id.editText3);





    }

    public void SaveData(View view) {
        spinner= (Spinner) findViewById(R.id.spinner1);
        spinnervalue=spinner.getSelectedItem().toString();
        dbHelper = new PoetryDBHelper(this);
        String etitle1= etitle.getText().toString();
       // String etype1= typealue1;
        Toast.makeText(AddData.this,spinnervalue,Toast.LENGTH_SHORT).show();
        String edescription1= edescription.getText().toString();
        Poetry poetry = new Poetry();

        poetry.setTitle(etitle1);
        poetry.setType(spinnervalue);
        poetry.setDescription(edescription1);
        if(dbHelper.insertData(poetry)){
            Toast.makeText(AddData.this,"Data Inserted",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(AddData.this,"Data not inserted",Toast.LENGTH_SHORT).show();
        }
    }
}
