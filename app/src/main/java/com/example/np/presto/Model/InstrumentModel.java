package com.example.np.presto.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.np.presto.Pojo.Book;
import com.example.np.presto.Pojo.Instrument;

import java.util.ArrayList;
import java.util.List;

public class InstrumentModel extends SQLiteOpenHelper {

    private Context context;


    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "marketdb";
    private static final String TABLE_NAME = "instruments";


    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_MODEL = "model";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_PRICE = "price";
    private static final String KEY_BRAND = "brand";
    private static final String KEY_TYPE = "type";
    private static final String KEY_MODELINFO = "modelinfo";
    private static final String KEY_BRANDINFO = "brandinfo";
    private static final String KEY_ADDRESS = "address";



    private static final String SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( " +
            KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            KEY_TITLE + " TEXT NOT NULL, " +
            KEY_MODELINFO + " TEXT NOT NULL," +
            KEY_IMAGE + " TEXT NOT NULL, " +
            KEY_CATEGORY + " TEXT NOT NULL," +
            KEY_PRICE + " TEXT NOT NULL," +
            KEY_BRANDINFO + " TEXT NOT NULL," +
            KEY_BRAND + " TEXT NOT NULL, " +
            KEY_MODEL + " TEXT NOT NULL," +
            KEY_TYPE + " TEXT," +
            KEY_ADDRESS+ " TEXT NOT NULL)";


    public InstrumentModel(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addInstrument(Instrument instrument){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( KEY_TITLE, instrument.getTitle() );
        values.put( KEY_IMAGE, instrument.getImage() );
        values.put( KEY_MODELINFO, instrument.getModelInfo() );
        values.put( KEY_CATEGORY, instrument.getCategory() );
        values.put( KEY_PRICE, instrument.getPrice() );
        values.put( KEY_BRANDINFO,instrument.getBrandInfo() );
        values.put( KEY_BRAND, instrument.getBrand() );
        values.put( KEY_MODEL, instrument.getModel() );
        values.put( KEY_TYPE, instrument.getType() );
        values.put( KEY_ADDRESS, instrument.getAddress() );
        db.insert( TABLE_NAME,null,values);
        db.close();
    }

    public Instrument getInstrument(int id){
        SQLiteDatabase db = getReadableDatabase();
        Instrument instrument = null;
        Cursor cursor = db.query(TABLE_NAME, null, KEY_ID + " = " + id, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
            instrument = new Instrument();
            instrument.setId(id);
            instrument.setTitle(cursor.getString(cursor.getColumnIndex(KEY_TITLE)));
            instrument.setModel(cursor.getString(cursor.getColumnIndex(KEY_MODEL)));
            instrument.setImage(cursor.getColumnIndex(KEY_IMAGE));
            instrument.setCategory(cursor.getString(cursor.getColumnIndex(KEY_CATEGORY)));
            instrument.setPrice(cursor.getString(cursor.getColumnIndex(KEY_PRICE)));
            instrument.setModelInfo(cursor.getString(cursor.getColumnIndex(KEY_MODELINFO)));
            instrument.setBrand(cursor.getString(cursor.getColumnIndex(KEY_BRAND)));
            instrument.setBrandInfo(cursor.getString(cursor.getColumnIndex(KEY_BRANDINFO)));
            instrument.setType(cursor.getString(cursor.getColumnIndex(KEY_TYPE)));
            instrument.setAddress(cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
        }
        return  instrument;
    }

    public List<Instrument> getAllInstruments(){
        SQLiteDatabase db = getReadableDatabase();
        List<Instrument> instruments = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                Instrument instrument = new Instrument();
                instrument.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                instrument.setTitle(cursor.getString(cursor.getColumnIndex(KEY_TITLE)));
                instrument.setModel(cursor.getString(cursor.getColumnIndex(KEY_MODEL)));
                instrument.setImage(cursor.getColumnIndex(KEY_IMAGE));
                instrument.setCategory(cursor.getString(cursor.getColumnIndex(KEY_CATEGORY)));
                instrument.setPrice(cursor.getString(cursor.getColumnIndex(KEY_PRICE)));
                instrument.setModelInfo(cursor.getString(cursor.getColumnIndex(KEY_MODELINFO)));
                instrument.setBrand(cursor.getString(cursor.getColumnIndex(KEY_BRAND)));
                instrument.setBrandInfo(cursor.getString(cursor.getColumnIndex(KEY_BRANDINFO)));
                instrument.setType(cursor.getString(cursor.getColumnIndex(KEY_TYPE)));
                instrument.setAddress(cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
                instruments.add(instrument);
            }while (cursor.moveToNext());
        }
        return instruments;
    }

    public int getBooksCount(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        return cursor.getCount();
    }

    public void updateInstrument(Instrument instrument,  int id){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( KEY_TITLE, instrument.getTitle() );
        values.put( KEY_IMAGE, instrument.getImage() );
        values.put( KEY_MODELINFO, instrument.getModelInfo() );
        values.put( KEY_CATEGORY, instrument.getCategory() );
        values.put( KEY_PRICE, instrument.getPrice() );
        values.put( KEY_BRANDINFO,instrument.getBrandInfo() );
        values.put( KEY_BRAND, instrument.getBrand() );
        values.put( KEY_MODEL, instrument.getModel() );
        values.put( KEY_TYPE, instrument.getType() );
        values.put( KEY_ADDRESS, instrument.getAddress() );
        db.update(TABLE_NAME,values,KEY_ID + "=" + id ,null);
        db.close();
    }

    public void deleteInstrument(int id){

        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,KEY_ID + "=" + id ,null);
        db.close();
    }

    public void deleteAllInstruments(){

        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,null ,null);
        db.close();
    }

    public List<Instrument> search(String keyword) {
        List<Instrument> instruments = null;
        try {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where " + KEY_TITLE + " like ?", new String[] { "%" + keyword + "%" });
            if (cursor.moveToFirst()) {
                instruments = new ArrayList<>();
                do {
                    Instrument instrument = new Instrument();
                    instrument.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                    instrument.setTitle(cursor.getString(cursor.getColumnIndex(KEY_TITLE)));
                    instrument.setModel(cursor.getString(cursor.getColumnIndex(KEY_MODEL)));
                    instrument.setImage(cursor.getColumnIndex(KEY_IMAGE));
                    instrument.setCategory(cursor.getString(cursor.getColumnIndex(KEY_CATEGORY)));
                    instrument.setPrice(cursor.getString(cursor.getColumnIndex(KEY_PRICE)));
                    instrument.setModelInfo(cursor.getString(cursor.getColumnIndex(KEY_MODELINFO)));
                    instrument.setBrand(cursor.getString(cursor.getColumnIndex(KEY_BRAND)));
                    instrument.setBrandInfo(cursor.getString(cursor.getColumnIndex(KEY_BRANDINFO)));
                    instrument.setType(cursor.getString(cursor.getColumnIndex(KEY_TYPE)));
                    instrument.setAddress(cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
                    instruments.add(instrument);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            instruments = null;
        }
        return instruments;
    }
}
