package com.chrs.iit.android.greg.joberfied;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by greg on 7/31/16.
 */
public class DBSqliteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_LOGIN="DB_login";

    private static final String TABLE_LOGIN="table_login";

    private static final String PK_USER="pk_user";
    private static final String USER_PIN="user_pin";
    private static final String USER_PASS="user_pass";

    SQLiteDatabase db;
    public DBSqliteHelper(Context context) {
        super(context,DATABASE_LOGIN,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USER_TABLE="CREATE TABLE "+ TABLE_LOGIN + "("
                                + USER_PIN+ " TEXT, "
                                + USER_PASS+ " TEXT"+")";
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        onCreate(sqLiteDatabase);
    }

    public void addAccount(JobSeeker_LoginClass jobSeeker_loginClass){
        db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(USER_PIN,jobSeeker_loginClass.getUser_pin());
        values.put(USER_PASS,jobSeeker_loginClass.getUser_pass());

        db.insert(TABLE_LOGIN,null,values);
        db.close();
    }

    public void logoutAccount(){
        db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_LOGIN);
        db.close();
    }

    public boolean checkLoginAccount(){
        boolean Empty;
        db=this.getWritableDatabase();
        String count="SELECT COUNT(*) FROM "+TABLE_LOGIN;
        Cursor c=db.rawQuery(count,null);
        c.moveToFirst();
        int icount=c.getInt(0);
        if(icount>0){
         Empty=true;
        }
        else {
            Empty=false;
        }
        return Empty;
    }
}
