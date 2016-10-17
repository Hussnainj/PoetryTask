package com.example.wasim.poetrytask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wasim on 10/8/2016.
 */
public class PoetryDBHelper  extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "poetry";
    private static final int DATABASE_VERSION = 3;
    SQLiteDatabase database;

    private static final String CREATE_TABLE = "create table poetry (id integer primary key autoincrement, title text, type text, description text )";
   // "create table fruit (fid integer primary key autoincrement, fpic text, fname text, fcal int, fval int, fintro text, fdetail text, fgrams int,ftype text )";

    public PoetryDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        Log.d("database", "Table created successfully");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS poetry");
        onCreate(db);
    }

    public boolean insertData(Poetry poetry){
        database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title", poetry.getTitle());
        cv.put("type", poetry.getType());
        cv.put("description", poetry.getDescription());


        long result = database.insert("poetry",null,cv);
        poetry.setId((int) result);
        return (result!=-1);
    }



    public List<Poetry> retreiveAll(String condition){
        database = this.getWritableDatabase();
        List<Poetry> poetryList = new ArrayList<>();
        String query = "select * from poetry where title = '"+condition+"'";
        Cursor cursor = database.rawQuery(query, null);
        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
               Poetry poetry = new Poetry();

                poetry.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                poetry.setType(cursor.getString(cursor.getColumnIndex("type")));
                Log.i("myvalue",poetry.getType());
               poetry.setDescription(cursor.getString(cursor.getColumnIndex("description")));
                poetryList.add(poetry);
            }
        }

        return poetryList;
    }

    public List<String> getTitle (){
        database = this.getReadableDatabase();
        String title = "SELECT DISTINCT type FROM poetry" ;
        List<String> Title = new ArrayList<>();
        Cursor cursor =database.rawQuery(title,null);
        if(cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do {
                String  t = cursor.getString(cursor.getColumnIndex("type"));
                Title.add(t);
            }while (cursor.moveToNext());
        }
        return Title;
    }
    public List<String> getFamily (String ite){
       database = this.getReadableDatabase();
        String title = "SELECT * FROM poetry WHERE type = '"+ite+"' " ;
        List<String> Title = new ArrayList<>();
        Cursor cursor = database.rawQuery(title,null);
        if(cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do {
                String  t = cursor.getString(cursor.getColumnIndex("description"));
                Title.add(t);
            }while (cursor.moveToNext());
        }
        return Title;
    }
    public int countData(String title){
        String query = "SELECT * FROM poetry WHERE type = '"+title+"' " ;
        //List<String> Title = new ArrayList<>();
        Cursor cursor = database.rawQuery(query,null);

        int num = cursor.getCount();
        Log.i("countData","Testing");
        return num;
    }
    public int newcountData(){
        String match = "Stanza";
        String query = "SELECT * FROM poetry WHERE type = '"+match+"' ";
        //List<String> Title = new ArrayList<>();
        Log.e("error","showing this text");
        Cursor cursor = database.rawQuery(query,null);

        int num = cursor.getCount();
        Log.e("error"," My Error message ");
        return num;
    }

    public int countData1(String title){
        String query = "SELECT * FROM poetry WHERE description = '"+title+"' " ;
        List<String> Title = new ArrayList<>();
        Cursor cursor = database.rawQuery(query,null);

        int num = cursor.getCount();
        return num;
    }


    public List<String> getData(String title){
       database = this.getReadableDatabase();
        List<String> data = new ArrayList<>();
        String qurre = "SELECT * FROM poetry WHERE title = '"+title+"'";
        Cursor cursor=database.rawQuery(qurre,null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                String d = cursor.getString(cursor.getColumnIndex("type"));
                data.add(d);
            }while (cursor.moveToNext());
        }
        return data;
    }
    public String gettype (String tt ){
      database = this.getReadableDatabase();
        String title = "SELECT * FROM poetry WHERE type = '"+tt+"'";
        String t = "";
        Cursor cursor = database.rawQuery(title,null);
        if(cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do {
                t = cursor.getString(cursor.getColumnIndex("title"));
            }while (cursor.moveToNext());
        }
        return t;
    }

    public String getDescription ( String tit){
        database = this.getReadableDatabase();
        String title = "SELECT * FROM poetry WHERE type = '"+tit+"' ";
        String t = "";
        Cursor cursor = database.rawQuery(title,null);
        if(cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do {
                t = cursor.getString(cursor.getColumnIndex("type"));
            }while (cursor.moveToNext());
        }
        return t;
    }
    /*public void deleteData(String  d){
        db = this.getWritableDatabase();
        String q = "DELETE FROM entery WHERE description == '"+d+"'";
        db.execSQL(q);
        db.close();
    }*/

    public void open(){
        database = this.getWritableDatabase();
    }
}

