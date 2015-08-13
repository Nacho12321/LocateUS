package com.example.nachiketvatkar.locateus;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.content.Context;
import android.content.ContentValues;

public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper sInstance;

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME= "JapanTrip";
    private static final String TABLE_ASSORTMENT= "GroupMemberMaster";
    private static final String DATABASE_CREATE = "create table " + TABLE_ASSORTMENT + "(" +
            "MemberId  char(2)," +
            "MemberName char(20)," +
            "_id integer" +
            ");";


    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public DBHelper(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }



    public static synchronized DBHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DBHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ASSORTMENT);
        onCreate(db);
    }

//    public boolean Val(DBHelper dbh1) {
//        boolean a;
//        if (dbh1.getWritableDatabase() == null) {
//            a= false;
//            dbh1.close();
//        }
//        else{
//            a=true;
//        }
//        return  a;
//    }
//    //    Add new row to the table
//    public void addDetails(Grouper grouper){
//        ContentValues values = new ContentValues();
//        ContentValues values1 = new ContentValues();
//        ContentValues values2 = new ContentValues();
//        values.put(COLUMN_GID, grouper._gid);
//        values1.put(COLUMN_MID, grouper._mid);
//        values2.put(COLUMN_MNAME, grouper._mnam);
//
//        SQLiteDatabase db = getWritableDatabase();
//        db.insert(TABLE_ASSORTMENT,null,values);
//        db.insert(TABLE_ASSORTMENT,null,values1);
//        db.insert(TABLE_ASSORTMENT, null, values2);
//        db.close();
//
//    }

//    //    Sorting database in terms of group id
//    public String[] sorting(int grpr){
//        String[] dbString;
//        int count = 0;
//        SQLiteDatabase db = getWritableDatabase();
//        String query = "SELECT * FROM" + TABLE_ASSORTMENT + "WHERE " + COLUMN_GID+ "=\""+grpr+"\";";
//
////        Cursor points to a location in your results
//        Cursor c= db.rawQuery(query,null);
////        Move to first row of results
//        c.moveToFirst();
//
//        while (!c.isAfterLast()){
//            if(c.getString(c.getColumnIndex("_mName"))!=null)
//                count++;
//        }
//        dbString= new String[count];
//        int a=0;
//        while (!c.isAfterLast()&& a<dbString.length) {
//            if (c.getString(c.getColumnIndex("_mName")) != null) {
//                dbString[a] += c.getString(c.getColumnIndex("_mName"));
//                a++;
//            }
//        }
//        db.close();
//        return dbString;
//    }

}

