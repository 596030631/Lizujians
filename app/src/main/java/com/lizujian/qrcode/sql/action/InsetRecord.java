package com.lizujian.qrcode.sql.action;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.lizujian.qrcode.sql.util.DBHelper;

import java.util.List;

//添加数据
public class InsetRecord {

    public static void insertT1(Context context, List<String> list){

        SQLiteDatabase db = DBHelper.GetDB(context);
        ContentValues values = new ContentValues();
        values.put("lyfs",list.get(0));
        values.put("nnzk",list.get(1));
        values.put("czy",list.get(2));
        values.put("batch",list.get(3));
        db.insert("T1",null,values);
        values.clear();
    }

    public static void insertT2(Context context,List<String> list){

        SQLiteDatabase db = DBHelper.GetDB(context);
        ContentValues values = new ContentValues();
        values.put("jgcs",list.get(0));
        values.put("jgzq",list.get(1));
        values.put("glbz",list.get(2));
        values.put("sjfs",list.get(3));
        values.put("batch",list.get(4));
        db.insert("T2",null,values);
        values.clear();
    }

    public static void insertT3(Context context,List<String> list){

        SQLiteDatabase db = DBHelper.GetDB(context);
        ContentValues values = new ContentValues();
        values.put("ysy",list.get(0));
        values.put("cph",list.get(1));
        values.put("cnwd",list.get(2));
        values.put("batch",list.get(3));
        db.insert("T3",null,values);
        values.clear();
    }

    public static void insertT4(Context context,List<String> list){

        SQLiteDatabase db = DBHelper.GetDB(context);
        ContentValues values = new ContentValues();
        values.put("xsfs",list.get(0));
        values.put("bzrq",list.get(1));
        values.put("lsjg",list.get(2));
        values.put("batch",list.get(3));
        db.insert("T4",null,values);
        values.clear();
    }
}
