package com.neilcastellino.bon;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user.db";
    private static final String TABLE_NAME = "USER";
    private static final String COL_1 = "UID";
    private static final String COL_2 = "UNAME";
    private static final String COL_3 = "EMAIL";
    private static final String COL_4 = "PASSWORD";
    private static final String COL_5 = "FNAME";
    private static final String COL_6 = "LNAME";
    private static final String COL_7 = "AGE";
    private static final String COL_8 = "GENDER";
    private static final String COL_9 = "CONTACT";
//    public DatabaseHelper dbHelper;

    public UserDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_2 + " TEXT, " + COL_3 + " TEXT, " + COL_4 + " TEXT, " + COL_5 + " TEXT, "
                + COL_6 + " TEXT, " + COL_7 + " TEXT, " + COL_8 + " TEXT, " + COL_9 + " TEXT );");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertDataR(String uname, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, uname);
        contentValues.put(COL_4, password);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1)
                return false;
        else
                return true;
    }

    public boolean insertDataED(String uname , String email, String password, String fname, String lname, String age, String gender, String contact ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, uname);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, password);
        contentValues.put(COL_5, fname);
        contentValues.put(COL_6, lname);
        contentValues.put(COL_7, age);
        contentValues.put(COL_8, gender);
        contentValues.put(COL_9, contact);

        db.update(TABLE_NAME, contentValues, " UNAME = ? ", new String[] {uname});
        return true;
    }

    public void LoginVerify(String user, String pass){
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        db.execSQL("SELECT EXISTS ( SELECT * FROM " + TABLE_NAME + " WHERE ");
    }


}
