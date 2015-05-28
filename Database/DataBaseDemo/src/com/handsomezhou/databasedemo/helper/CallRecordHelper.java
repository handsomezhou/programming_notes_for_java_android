package com.handsomezhou.databasedemo.helper;

import java.util.ArrayList;
import java.util.List;

import com.handsomezhou.databasedemo.model.CallRecord;

public class CallRecordHelper {
    private static CallRecordHelper mInstance;
    private List<CallRecord> mCallRecords;
    
    public static CallRecordHelper getInstance(){
        if(null==mInstance){
            mInstance=new CallRecordHelper();
        }
        
        return mInstance;
    }
    
    private CallRecordHelper(){
        initCallRecordHelper();
    }
    
    private void initCallRecordHelper(){
        if(null==mCallRecords){
            mCallRecords=new ArrayList<CallRecord>();
        }
        mCallRecords.clear();
    }

    public List<CallRecord> getCallRecords() {
        return mCallRecords;
    }

    public void setCallRecords(List<CallRecord> callRecords) {
        mCallRecords = callRecords;
    }
    
    
}
