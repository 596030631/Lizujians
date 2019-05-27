package com.lizujian.qrcode.sql.action;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.lizujian.qrcode.bean.MilkInfo;
import com.lizujian.qrcode.sql.util.DBHelper;

import java.util.List;

//查找数据
public class SelectRecord {

    public static List<MilkInfo.T1Bean> selectT1(Context context ,List<MilkInfo.T1Bean> mlist){
        SQLiteDatabase db = DBHelper.GetDB(context);
        Cursor cursor = db.rawQuery("select  *  from  T1",null);
        if(cursor.moveToFirst()) {
            do {
                String lyfs = cursor.getString(cursor.getColumnIndex("lyfs"));
                String nnzk = cursor.getString(cursor.getColumnIndex("nnzk"));
                String czy = cursor.getString(cursor.getColumnIndex("czy"));
                String batch = cursor.getString(cursor.getColumnIndex("batch"));
                Log.e("TAG",batch+"---");
                mlist.add(new MilkInfo.T1Bean());
                mlist.get(mlist.size()-1).setLyfs(lyfs);
                mlist.get(mlist.size()-1).setNnzk(nnzk);
                mlist.get(mlist.size()-1).setCzy(czy);
                mlist.get(mlist.size()-1).setBatch(batch);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mlist;
    }


    public static List<MilkInfo.T2Bean> selectT2(Context context ,List<MilkInfo.T2Bean> mlist){
        SQLiteDatabase db = DBHelper.GetDB(context);
        Cursor cursor = db.rawQuery("select  *  from  T2",null);
        if(cursor.moveToFirst()) {
            do {
                String jgcs = cursor.getString(cursor.getColumnIndex("jgcs"));
                String jgzq = cursor.getString(cursor.getColumnIndex("jgzq"));
                String glbz = cursor.getString(cursor.getColumnIndex("glbz"));
                String sjfs = cursor.getString(cursor.getColumnIndex("sjfs"));
                String batch = cursor.getString(cursor.getColumnIndex("batch"));
                mlist.add(new MilkInfo.T2Bean());
                mlist.get(mlist.size()-1).setJgcs(jgcs);
                mlist.get(mlist.size()-1).setJgzq(jgzq);
                mlist.get(mlist.size()-1).setGlbz(glbz);
                mlist.get(mlist.size()-1).setSjfs(sjfs);
                mlist.get(mlist.size()-1).setBatch(batch);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mlist;
    }


    public static List<MilkInfo.T3Bean> selectT3(Context context ,List<MilkInfo.T3Bean> mlist){
        SQLiteDatabase db = DBHelper.GetDB(context);
        Cursor cursor = db.rawQuery("select  *  from  T3",null);
        if(cursor.moveToFirst()) {
            do {
                String ysy = cursor.getString(cursor.getColumnIndex("ysy"));
                String cph = cursor.getString(cursor.getColumnIndex("cph"));
                String cnwd = cursor.getString(cursor.getColumnIndex("cnwd"));
                String batch = cursor.getString(cursor.getColumnIndex("batch"));
                mlist.add(new MilkInfo.T3Bean());
                mlist.get(mlist.size()-1).setYsy(ysy);
                mlist.get(mlist.size()-1).setCph(cph);
                mlist.get(mlist.size()-1).setCnwd(cnwd);
                mlist.get(mlist.size()-1).setBatch(batch);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mlist;
    }


    public static List<MilkInfo.T4Bean> selectT4(Context context ,List<MilkInfo.T4Bean> mlist){
        SQLiteDatabase db = DBHelper.GetDB(context);
        Cursor cursor = db.rawQuery("select  *  from  T4",null);
        if(cursor.moveToFirst()) {
            do {
                String xsfs = cursor.getString(cursor.getColumnIndex("xsfs"));
                String bzrq = cursor.getString(cursor.getColumnIndex("bzrq"));
                String lsjg = cursor.getString(cursor.getColumnIndex("lsjg"));
                String batch = cursor.getString(cursor.getColumnIndex("batch"));
                mlist.add(new MilkInfo.T4Bean());
                mlist.get(mlist.size()-1).setXsfs(xsfs);
                mlist.get(mlist.size()-1).setBzrq(bzrq);
                mlist.get(mlist.size()-1).setLsjg(lsjg);
                mlist.get(mlist.size()-1).setBatch(batch);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mlist;
    }

}
