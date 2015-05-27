package com.handsomezhou.databasedemo.helper;

public class MonitorContactsDatabaseHelper {
    private static MonitorContactsDatabaseHelper mInstance;
    
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
        
    }
    
    
}
