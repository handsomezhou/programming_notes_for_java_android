
package com.handsomezhou.databasedemo.helper;

import com.handsomezhou.databasedemo.database.MonitorContactsDatabase.CallContacts;
import com.handsomezhou.databasedemo.database.MonitorContactsDatabase.CallRecordColumns;
import com.handsomezhou.databasedemo.database.MonitorContactsDatabase.MonitorConfigurationColumns;
import com.handsomezhou.databasedemo.database.MonitorContactsDatabase.Table;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MonitorContactsSQLiteOpenHelper extends SQLiteOpenHelper {
    private Context mContext;
    private static final String CREATE_MONITOR_CONFIGURATION_TABLE = "create table "
            + Table.MONITOR_CONFIGURATION_TABLE
            + "("
            + MonitorConfigurationColumns._ID + " integer primary key autoincrement,"
            + MonitorConfigurationColumns.PHONE_NUMBER + " text,"
            + MonitorConfigurationColumns.MONITOR + " integer "
            + ")";

    private static final String CREATE_CALL_RECORD_TABLE = "create table "
            + Table.CALL_RECORD_TABLE
            + "("
            + CallRecordColumns._ID + " integer primary key autoincrement,"
            + CallRecordColumns.CALL_RECORD_ID + " integer unique,"
            + CallRecordColumns.MONITOR_PHONE_NUMBER + " text,"
            + CallRecordColumns.CALL_TYPE + " integer,"
            + CallRecordColumns.START_TIME + " text,"
            + CallRecordColumns.END_TIME + " text "
            + ")";

    private static final String CREATE_CALL_CONTACTS = "create table " + Table.CALL_CONTACTS
            + "("
            + CallContacts._ID + " integer primary key autoincrement,"
            + CallContacts.CALL_RECORD_ID + " integer,"
            + CallContacts.NAME + " text,"
            + CallContacts.PHONE_NUMBER + " text "
            + ")";

    public MonitorContactsSQLiteOpenHelper(Context context, String name, CursorFactory factory,
            int version) {
        super(context, name, factory, version);
        mContext=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MONITOR_CONFIGURATION_TABLE);
        db.execSQL(CREATE_CALL_RECORD_TABLE);
        db.execSQL(CREATE_CALL_CONTACTS);
        Toast.makeText(mContext, "create success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("drop table if exists "+Table.MONITOR_CONFIGURATION_TABLE);
       db.execSQL("drop table if exists "+Table.CALL_RECORD_TABLE);
       db.execSQL("drop table if exists "+Table.CALL_CONTACTS);
       
       onCreate(db);
    }

}
