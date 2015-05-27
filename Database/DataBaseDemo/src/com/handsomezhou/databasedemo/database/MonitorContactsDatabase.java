package com.handsomezhou.databasedemo.database;

import android.provider.BaseColumns;

public class MonitorContactsDatabase{
    
    public static final String DB_NAME="ContactsMonitor.db";//contacts monitor database name
    public static final int DB_VERSION=1;
    
    public interface Table{
        public final String MONITOR_CONFIGURATION_TABLE="monitor_configuration";
        public final String CALL_RECORD_TABLE="call_record";
        public final String CALL_CONTACTS="call_contacts";
    }
    
    public interface MonitorConfigurationColumns extends BaseColumns{
        public final String PHONE_NUMBER="phone_number";    //record phone number
        public final String MONITOR="monitor";              //record whether Monitor
    }
    
    public interface CallRecordColumns extends BaseColumns{
        public final String CALL_RECORD_ID="call_record_id";
        public final String MONITOR_PHONE_NUMBER="monitor_phone_number";
        public final String CALL_TYPE="call_type";
        public final String START_TIME="start_time";
        public final String END_TIME="end_time";  
    }
    
    public interface CallContacts extends BaseColumns{
        public final String CALL_RECORD_ID="call_record_id";
        public final String NAME="name";
        public final String PHONE_NUMBER="phone_number";
    }
}
