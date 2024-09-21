package com.example.np.presto.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.np.presto.Pojo.Book;

import java.util.ArrayList;
import java.util.List;

public class BookModel extends SQLiteOpenHelper {

    private Context context;


    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "marketdb";
    private static final String TABLE_NAME = "books";


    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_PRICE = "price";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_PUBLICATION = "publication";
    private static final String KEY_YEAR = "year";
    private static final String KEY_TYPE = "type";
    private static final String KEY_LEVEL = "level";
    private static final String KEY_ADDRESS = "address";


    private static final String SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( " +
            KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            KEY_TITLE + " TEXT NOT NULL, " +
            KEY_DESCRIPTION + " TEXT NOT NULL," +
            KEY_IMAGE + " TEXT NOT NULL, " +
            KEY_CATEGORY + " TEXT NOT NULL," +
            KEY_PRICE + " TEXT NOT NULL," +
            KEY_AUTHOR + " TEXT NOT NULL," +
            KEY_PUBLICATION + " TEXT NOT NULL, " +
            KEY_YEAR + " TEXT NOT NULL," +
            KEY_TYPE + " TEXT ," +
            KEY_LEVEL + " TEXT ," +
            KEY_ADDRESS + " TEXT NOT NULL)";


    public BookModel(Context context) {
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

    public void addBook(Book book) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, book.getTitle());
        values.put(KEY_IMAGE, book.getImage());
        values.put(KEY_DESCRIPTION, book.getDescription());
        values.put(KEY_CATEGORY, book.getCategory());
        values.put(KEY_PRICE, book.getPrice());
        values.put(KEY_AUTHOR, book.getAuthor());
        values.put(KEY_PUBLICATION, book.getPublication());
        values.put(KEY_YEAR, book.getYear());
        values.put(KEY_TYPE, book.getType());
        values.put(KEY_LEVEL, book.getLevel());
        values.put(KEY_ADDRESS, book.getAddress());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Book getBook(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Book book = null;
        Cursor cursor = db.query(TABLE_NAME, null, KEY_ID + " = " + id, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            book = new Book();
            book.setId(id);
            book.setTitle(cursor.getString(cursor.getColumnIndex(KEY_TITLE)));
            book.setDescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));
            book.setImage(cursor.getColumnIndex(KEY_IMAGE));
            book.setCategory(cursor.getString(cursor.getColumnIndex(KEY_CATEGORY)));
            book.setPrice(cursor.getString(cursor.getColumnIndex(KEY_PRICE)));
            book.setAuthor(cursor.getString(cursor.getColumnIndex(KEY_AUTHOR)));
            book.setPublication(cursor.getString(cursor.getColumnIndex(KEY_PUBLICATION)));
            book.setYear(cursor.getString(cursor.getColumnIndex(KEY_YEAR)));
            book.setType(cursor.getString(cursor.getColumnIndex(KEY_TYPE)));
            book.setLevel(cursor.getColumnIndex(KEY_LEVEL));
            book.setAddress(cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
        }
        return book;
    }

    public List<Book> getAllBooks() {
        SQLiteDatabase db = getReadableDatabase();
        List<Book> books = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                book.setTitle(cursor.getString(cursor.getColumnIndex(KEY_TITLE)));
                book.setImage(cursor.getColumnIndex(KEY_IMAGE));
                book.setDescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));
                book.setCategory(cursor.getString(cursor.getColumnIndex(KEY_CATEGORY)));
                book.setPrice(cursor.getString(cursor.getColumnIndex(KEY_PRICE)));
                book.setAuthor(cursor.getString(cursor.getColumnIndex(KEY_AUTHOR)));
                book.setPublication(cursor.getString(cursor.getColumnIndex(KEY_PUBLICATION)));
                book.setYear(cursor.getString(cursor.getColumnIndex(KEY_YEAR)));
                book.setType(cursor.getString(cursor.getColumnIndex(KEY_TYPE)));
                book.setImage(cursor.getColumnIndex(KEY_IMAGE));
                book.setLevel(cursor.getColumnIndex(KEY_LEVEL));
                book.setAddress(cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
                books.add(book);
            } while (cursor.moveToNext());
        }
        return books;
    }

    public int getBooksCount() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        return cursor.getCount();
    }

    public void updateBook(Book book, int id) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, book.getTitle());
        values.put(KEY_IMAGE, book.getImage());
        values.put(KEY_DESCRIPTION, book.getDescription());
        values.put(KEY_CATEGORY, book.getCategory());
        values.put(KEY_PRICE, book.getPrice());
        values.put(KEY_AUTHOR, book.getAuthor());
        values.put(KEY_PUBLICATION, book.getPublication());
        values.put(KEY_YEAR, book.getYear());
        values.put(KEY_TYPE, book.getType());
        values.put(KEY_LEVEL, book.getLevel());
        values.put(KEY_ADDRESS, book.getAddress());
        db.update(TABLE_NAME, values, KEY_ID + "=" + id, null);
        db.close();
    }

    public void deleteBook(int id) {

        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + "=" + id, null);
        db.close();
    }

    public void deleteAllBooks() {

        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

    public List<Book> search(String keyword) {
        List<Book> books = null;
        try {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where " + KEY_TITLE + " like ?", new String[]{"%" + keyword + "%"});
            if (cursor.moveToFirst()) {
                books = new ArrayList<>();
                do {
                    Book book = new Book();
                    book.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                    book.setTitle(cursor.getString(cursor.getColumnIndex(KEY_TITLE)));
                    book.setImage(cursor.getColumnIndex(KEY_IMAGE));
                    book.setDescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)));
                    book.setCategory(cursor.getString(cursor.getColumnIndex(KEY_CATEGORY)));
                    book.setPrice(cursor.getString(cursor.getColumnIndex(KEY_PRICE)));
                    book.setAuthor(cursor.getString(cursor.getColumnIndex(KEY_AUTHOR)));
                    book.setPublication(cursor.getString(cursor.getColumnIndex(KEY_PUBLICATION)));
                    book.setYear(cursor.getString(cursor.getColumnIndex(KEY_YEAR)));
                    book.setType(cursor.getString(cursor.getColumnIndex(KEY_TYPE)));
                    book.setImage(cursor.getColumnIndex(KEY_IMAGE));
                    book.setLevel(cursor.getColumnIndex(KEY_LEVEL));
                    book.setAddress(cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
                    books.add(book);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            books = null;
        }
        return books;
    }

}
