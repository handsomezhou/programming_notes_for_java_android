package com.handsomezhou.databasedemo.helper;

import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.handsomezhou.databasedemo.application.DataBaseDemoApplication;
import com.handsomezhou.databasedemo.database.MonitorContactsDatabase;
import com.handsomezhou.databasedemo.model.CallContacts;
import com.handsomezhou.databasedemo.model.CallRecord;

public class MonitorContactsDatabaseHelper {
    private static final String TAG="MonitorContactsDatabaseHelper";
    private static MonitorContactsDatabaseHelper mInstance;
    private MonitorContactsSQLiteOpenHelper mMonitorContactsSQLiteOpenHelper;
    
    public static MonitorContactsDatabaseHelper getInstance(){
        if(null==mInstance){
            mInstance= new MonitorContactsDatabaseHelper();
        }
        
        return mInstance;
    }
    
    private MonitorContactsDatabaseHelper(){
        initMonitorContactsDatabaseHelper();
    }
    
    private void initMonitorContactsDatabaseHelper(){
       mMonitorContactsSQLiteOpenHelper=new MonitorContactsSQLiteOpenHelper(DataBaseDemoApplication.getContext(), MonitorContactsDatabase.DB_NAME, null, MonitorContactsDatabase.DB_VERSION);
    }
    
    /*Start: create database*/
    public void createDatabase(){
        mMonitorContactsSQLiteOpenHelper.getWritableDatabase();
    }
    /*End: create database*/

    /*Start: insert*/
    public void insert(final CallRecord callRecord){
        if(null==callRecord){
            return;
        }
        
        SQLiteDatabase db=mMonitorContactsSQLiteOpenHelper.getWritableDatabase();
        ContentValues callRecordValues=new ContentValues();
  
        callRecordValues.put(MonitorContactsDatabase.CallRecordColumns.CALL_RECORD_ID, callRecord.getId());
        callRecordValues.put(MonitorContactsDatabase.CallRecordColumns.MONITOR_PHONE_NUMBER, callRecord.getMonitorContacts().getPhoneNumber());
        callRecordValues.put(MonitorContactsDatabase.CallRecordColumns.CALL_TYPE, callRecord.getCallType());
        callRecordValues.put(MonitorContactsDatabase.CallRecordColumns.START_TIME, String.valueOf(callRecord.getStartTime()));
        callRecordValues.put(MonitorContactsDatabase.CallRecordColumns.END_TIME, String.valueOf(callRecord.getEndTime()));
        
        db.insert(MonitorContactsDatabase.Table.CALL_RECORD_TABLE, null, callRecordValues);
        ContentValues callContactsValues=new ContentValues();
        
        callContactsValues.clear();
        callContactsValues.put(MonitorContactsDatabase.CallContacts.CALL_RECORD_ID, callRecord.getId());
        callContactsValues.put(MonitorContactsDatabase.CallContacts.NAME, callRecord.getMonitorContacts().getName());
        callContactsValues.put(MonitorContactsDatabase.CallContacts.PHONE_NUMBER, callRecord.getMonitorContacts().getPhoneNumber());
        db.insert(MonitorContactsDatabase.Table.CALL_CONTACTS_TABLE, null, callContactsValues);
        
        for(CallContacts cc:callRecord.getNonMonitorContacts()){
            callContactsValues.clear();
            callContactsValues.put(MonitorContactsDatabase.CallContacts.CALL_RECORD_ID, callRecord.getId());
            callContactsValues.put(MonitorContactsDatabase.CallContacts.NAME, cc.getName());
            callContactsValues.put(MonitorContactsDatabase.CallContacts.PHONE_NUMBER, cc.getPhoneNumber());
            db.insert(MonitorContactsDatabase.Table.CALL_CONTACTS_TABLE, null, callContactsValues);
        }
                
        db.close();
    }
    /*End: insert*/
    

    
    /*Start: delete*/
    public void deleteCallRecord(String callRecordId){
        if(null==callRecordId){
            return;
        }
        
        SQLiteDatabase db=mMonitorContactsSQLiteOpenHelper.getWritableDatabase();
        String callRecordWhereClause=MonitorContactsDatabase.CallRecordColumns.CALL_RECORD_ID+" = ?";
        String[] whereArgs=new String[]{callRecordId};
        db.delete(MonitorContactsDatabase.Table.CALL_RECORD_TABLE, callRecordWhereClause, whereArgs);

        String callContactsWhereClause=MonitorContactsDatabase.CallContacts.CALL_RECORD_ID+" = ?";
        db.delete(MonitorContactsDatabase.Table.CALL_CONTACTS_TABLE, callContactsWhereClause, whereArgs);
        db.close();
    }
    /*End: delete*/
    
    
    /*Start: query*/
    public List<CallRecord> queryAllCallRecord(List<CallRecord> callRecords){
        do{
            if(null==callRecords){
                break;
            }
            callRecords.clear();
            SQLiteDatabase db=mMonitorContactsSQLiteOpenHelper.getWritableDatabase();
            if(null==db){
                break;
            }
            String[] callRecordColumns={
                    MonitorContactsDatabase.CallRecordColumns.CALL_RECORD_ID,
                    MonitorContactsDatabase.CallRecordColumns.MONITOR_PHONE_NUMBER,
                    MonitorContactsDatabase.CallRecordColumns.CALL_TYPE,
                    MonitorContactsDatabase.CallRecordColumns.START_TIME,
                    MonitorContactsDatabase.CallRecordColumns.END_TIME,
                    };
            
            /*Start: callContacts*/
            String[] callContactsColumns={
                    MonitorContactsDatabase.CallContacts._ID,
                    MonitorContactsDatabase.CallContacts.NAME,
                    MonitorContactsDatabase.CallContacts.PHONE_NUMBER,
                    
            };
           
            /*End: callContacts*/
            
            String callRecordOrderBy=MonitorContactsDatabase.CallRecordColumns.START_TIME+" DESC";
            Cursor callRecordCursor=db.query(MonitorContactsDatabase.Table.CALL_RECORD_TABLE, callRecordColumns, null, null, null, null, callRecordOrderBy);
            if(null!=callRecordCursor){
                int callRecordIdColumnIndex=callRecordCursor.getColumnIndex(callRecordColumns[0]);
                int monitorPhoneNumberColumnIndex=callRecordCursor.getColumnIndex(callRecordColumns[1]);
                int callTypeColumnIndex=callRecordCursor.getColumnIndex(callRecordColumns[2]);
                int startTimeColumnIndex=callRecordCursor.getColumnIndex(callRecordColumns[3]);
                int endTimeColumnIndex=callRecordCursor.getColumnIndex(callRecordColumns[4]);
                while(callRecordCursor.moveToNext()){
                    CallRecord callRecord=new CallRecord();
                    String callRecordId=callRecordCursor.getString(callRecordIdColumnIndex);
                    String monitorPhoneNumber=callRecordCursor.getString(monitorPhoneNumberColumnIndex);
                    int callType=Integer.valueOf(callRecordCursor.getString(callTypeColumnIndex));
                    long startTime=Long.valueOf(callRecordCursor.getString(startTimeColumnIndex));
                    long endTime=Long.valueOf(callRecordCursor.getString(endTimeColumnIndex));
                    Log.i(TAG, "callRecordId["+callRecordId+"]monitorPhoneNumber["+monitorPhoneNumber+"]callType["+callType+"]startTime["+startTime+"]endTime["+endTime+"]");
                    callRecord.setId(callRecordId);
                    callRecord.setCallType(callType);
                    callRecord.setStartTime(startTime);
                    callRecord.setEndTime(endTime);
                    
                    String callContactsSelection=MonitorContactsDatabase.CallContacts.CALL_RECORD_ID+" = "+callRecordId;
                    Cursor callContactsCursor=db.query(MonitorContactsDatabase.Table.CALL_CONTACTS_TABLE, callContactsColumns, callContactsSelection, null, null, null, null);
                    if(null!=callContactsCursor){
                       while(callContactsCursor.moveToNext()){
                            int idColumnIndex=callContactsCursor.getColumnIndex(callContactsColumns[0]);
                            int nameColumnIndex=callContactsCursor.getColumnIndex(callContactsColumns[1]);
                            int phoneNumberColumnIndex=callContactsCursor.getColumnIndex(callContactsColumns[2]);
                            String id=callContactsCursor.getString(idColumnIndex);
                            String name=callContactsCursor.getString(nameColumnIndex);
                            String phoneNumber=callContactsCursor.getString(phoneNumberColumnIndex);
                            if(monitorPhoneNumber.equals(phoneNumber)){
                                callRecord.getMonitorContacts().setId(id);
                                callRecord.getMonitorContacts().setName(name);
                                callRecord.getMonitorContacts().setPhoneNumber(phoneNumber);
                            }else{
                                CallContacts callContacts=new CallContacts();
                                callContacts.setId(id);
                                callContacts.setName(name);
                                callContacts.setPhoneNumber(phoneNumber);
                                
                                callRecord.getNonMonitorContacts().add(callContacts);
                            }
                           
                            Log.i(TAG, "name["+name+"]phoneNumber["+phoneNumber+"]");
                       }
                    }
                    
                    callRecords.add(callRecord);
                }
            }
        }while(false);
        
        return callRecords;
    }
    
    /*End: query*/
    
    /*Start: update*/
    public void updateEndTime(String callRecordId, String endTime){
        if((null==callRecordId)||(null==endTime)){
            return;
        }
        
        SQLiteDatabase db=mMonitorContactsSQLiteOpenHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(MonitorContactsDatabase.CallRecordColumns.END_TIME, endTime);
        
        db.update(MonitorContactsDatabase.Table.CALL_RECORD_TABLE, values, MonitorContactsDatabase.CallContacts.CALL_RECORD_ID+" = ?", new String[]{callRecordId});
        db.close();
    }
    /*End: update*/
    
    
}
