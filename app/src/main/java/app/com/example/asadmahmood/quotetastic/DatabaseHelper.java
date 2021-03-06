package app.com.example.asadmahmood.quotetastic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asad Mahmood on 01-06-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="quote.db";
    public static final String TABLE_NAME="quote_table";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( " create table " + TABLE_NAME + " ( id INTEGER PRIMARY KEY AUTOINCREMENT,quote TEXT,by TEXT,description TEXT ) " );
        ContentValues contentValues = new ContentValues();
        contentValues.put("quote","Sweat is weakness leaving the body");
        contentValues.put("by","Asad ahmood");
        contentValues.put("description","--");
        db.insert(TABLE_NAME , null , contentValues);
        contentValues.put("quote","Light enters where the wound is.");
        contentValues.put("by","Runi");
        contentValues.put("description","--");
        db.insert(TABLE_NAME , null , contentValues);

        contentValues.put("quote","One SMALL step for man, One giant lEAP for MANKIND.");
        contentValues.put("by","Daniyal Dar");
        contentValues.put("description","--");
        db.insert(TABLE_NAME , null , contentValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String quote) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("quote",quote);
        long result = db.insert(TABLE_NAME , null , contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery( " select * from " + TABLE_NAME , null );
        return res;
    }

    public Cursor getDataForIndex(int index)
    {
        index++;
        SQLiteDatabase db = this.getWritableDatabase();
        String q = " SELECT * FROM " + TABLE_NAME + " WHERE id = " + index  ;
        Cursor res = db.rawQuery(q, null);
        //Cursor res = db.rawQuery( " select * from " + TABLE_NAME + " where id = 1 " , null );
        return res;
    }
}
