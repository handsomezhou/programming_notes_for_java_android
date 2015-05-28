package com.handsomezhou.databasedemo.model;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class CallRecord implements Cloneable{
    private static final String TAG="CallRecord";
    private String mId;           
    private int mCallType;       
    private long mStartTime;   
    private long mEndTime;  
    private CallContacts mMonitorContacts;  //only one contacts
    private List<CallContacts> mNonMonitorContacts;// maybe more than one contacts
    
    public CallRecord() {
        super();
        mMonitorContacts=new CallContacts();
        mNonMonitorContacts=new ArrayList<CallContacts>();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        CallRecord obj=(CallRecord)super.clone();
        obj.mMonitorContacts=(CallContacts) mMonitorContacts.clone();
        for(CallContacts cc:mNonMonitorContacts){
            obj.mNonMonitorContacts.add((CallContacts) cc.clone());
        }
        
        return obj;
    }

    public String getId() {
        return mId;
    }
    
    public void setId(String id) {
        mId = id;
    }
    
    public int getCallType() {
        return mCallType;
    }
    
    public void setCallType(int callType) {
        mCallType = callType;
    }
    
    public long getStartTime() {
        return mStartTime;
    }
    
    public void setStartTime(long startTime) {
        mStartTime = startTime;
    }
    
    public long getEndTime() {
        return mEndTime;
    }
    
    public void setEndTime(long endTime) {
        mEndTime = endTime;
    }
    
    public CallContacts getMonitorContacts() {
        return mMonitorContacts;
    }
    
    public void setMonitorContacts(CallContacts monitorContacts) {
        mMonitorContacts = monitorContacts;
    }
    
    public List<CallContacts> getNonMonitorContacts() {
        return mNonMonitorContacts;
    }
    
    public void setNonMonitorContacts(List<CallContacts> nonMonitorContacts) {
        mNonMonitorContacts = nonMonitorContacts;
    }
    
    public void show(){     
        Log.i(TAG,"mId["+mId+"]");
        Log.i(TAG,"mCallType["+mCallType+"]");
        Log.i(TAG,"mStartTime["+mStartTime+"]");
        Log.i(TAG,"mEndTime["+mEndTime+"]");
        Log.i(TAG, "mMonitorContacts:Name["+mMonitorContacts.getName()+"]PhoneNumber["+mMonitorContacts.getPhoneNumber()+"]");
        for(CallContacts cc:mNonMonitorContacts){
            Log.i(TAG, "mNonMonitorContacts name["+cc.getName()+"]PhoneNumber["+cc.getPhoneNumber()+"]");
        }
        Log.i(TAG, "++++++++++++++++++++++++++++++++++");
    }
}
