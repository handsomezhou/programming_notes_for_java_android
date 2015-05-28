package com.handsomezhou.databasedemo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.databasedemo.R;
import com.handsomezhou.databasedemo.helper.CallRecordHelper;
import com.handsomezhou.databasedemo.helper.MonitorContactsDatabaseHelper;
import com.handsomezhou.databasedemo.model.CallContacts;
import com.handsomezhou.databasedemo.model.CallRecord;

public class MainFragment extends BaseFragment {

    private Button mCreateDataBaseBtn;
    private Button mAddDataBtn;
    private Button mUpdateDataBtn;
    private Button mDeleteDataBtn;
    private Button mQueryDataBtn;
    @Override
    protected void initData() {
       setContext(getActivity());
      
        
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_main, container, false);
        mCreateDataBaseBtn=(Button)view.findViewById(R.id.create_data_base_btn);
        mAddDataBtn=(Button)view.findViewById(R.id.add_data_btn);
        mUpdateDataBtn=(Button)view.findViewById(R.id.update_data_btn);
        mDeleteDataBtn=(Button)view.findViewById(R.id.delete_data_btn);
        mQueryDataBtn=(Button)view.findViewById(R.id.query_data_btn);
        return view;
    }

    @Override
    protected void initListener() {
        mCreateDataBaseBtn.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                createDataBase();  
            }
        });
        
        mAddDataBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				addData();
				
			}
		});
        
        mUpdateDataBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updateData();
				
			}
		});
 
        mDeleteDataBtn.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			deleteData();
			
		}
        });
        
        mQueryDataBtn.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                queryData();
                
            }
            });
        
    }

    private void createDataBase(){
        MonitorContactsDatabaseHelper.getInstance().createDatabase();
    }
    
    private void addData(){
    	Toast.makeText(getContext(), "addData", Toast.LENGTH_SHORT).show();
        CallRecord callRecord=new CallRecord();
        long currentTimeMillis=System.currentTimeMillis();
        callRecord.setId(String.valueOf(currentTimeMillis));
        callRecord.setCallType(1);
        callRecord.setStartTime(currentTimeMillis);
        callRecord.setEndTime(currentTimeMillis+1000);
        callRecord.getMonitorContacts().setId("0");
        callRecord.getMonitorContacts().setName("handsomezhou");
        callRecord.getMonitorContacts().setPhoneNumber("10000000000");
        
        CallContacts callContacts1=new CallContacts();
        callContacts1.setId("0");
        callContacts1.setName("handsomezhou1");
        callContacts1.setPhoneNumber("10000000001");
        
        CallContacts callContacts2=new CallContacts();
        callContacts2.setId("0");
        callContacts2.setName("handsomezhou2");
        callContacts2.setPhoneNumber("10000000002");
          
        callRecord.getNonMonitorContacts().add(callContacts1);
        callRecord.getNonMonitorContacts().add(callContacts2);
        
        MonitorContactsDatabaseHelper.getInstance().insert(callRecord);
    }
    
    private void updateData(){
    	Toast.makeText(getContext(), "updateData", Toast.LENGTH_SHORT).show();
    	String callRecordId="1432793798984";
    	String endTime=String.valueOf(System.currentTimeMillis());
    	MonitorContactsDatabaseHelper.getInstance().updateEndTime(callRecordId, endTime);

    }
    
    private void deleteData(){
    	Toast.makeText(getContext(), "deleteData", Toast.LENGTH_SHORT).show();
    	String callRecordId="1432793798984";
    	MonitorContactsDatabaseHelper.getInstance().deleteCallRecord(callRecordId);
    }
    
    private void queryData(){
        Toast.makeText(getContext(), "queryData", Toast.LENGTH_SHORT).show();
        MonitorContactsDatabaseHelper.getInstance().queryAllCallRecord(CallRecordHelper.getInstance().getCallRecords());
        
        for(CallRecord cr:CallRecordHelper.getInstance().getCallRecords()){
            cr.show();
        }
    }
}
