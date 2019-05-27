package com.lizujian.qrcode.sql.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lizujian.qrcode.sql.table.Table;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Table.T1);
        db.execSQL(Table.T2);
        db.execSQL(Table.T3);
        db.execSQL(Table.T4);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists T1");
        db.execSQL("drop table if exists T2");
        db.execSQL("drop table if exists T3");
        db.execSQL("drop table if exists T4");
        onCreate(db);
    }

    public static SQLiteDatabase GetDB(Context context){
        DBHelper dbHelper = new DBHelper(context,"lizujian.db",null,1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db;
    }
}
