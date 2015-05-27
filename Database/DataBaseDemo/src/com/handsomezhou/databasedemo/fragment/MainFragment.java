package com.handsomezhou.databasedemo.fragment;

import com.handsomezhou.databasedemo.R;
import com.handsomezhou.databasedemo.database.MonitorContactsDatabase;
import com.handsomezhou.databasedemo.helper.MonitorContactsSQLiteOpenHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainFragment extends BaseFragment {
    private MonitorContactsSQLiteOpenHelper mMonitorContactsSQLiteOpenHelper;
    private Button mCreateDataBaseBtn;
    private Button mAddDataBtn;
    private Button mUpdateDataBtn;
    private Button mDeleteDataBtn;
    @Override
    protected void initData() {
       setContext(getActivity());
       mMonitorContactsSQLiteOpenHelper=new MonitorContactsSQLiteOpenHelper(getContext(), MonitorContactsDatabase.DB_NAME, null, MonitorContactsDatabase.DB_VERSION);
        
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_main, container, false);
        mCreateDataBaseBtn=(Button)view.findViewById(R.id.create_data_base_btn);
        mAddDataBtn=(Button)view.findViewById(R.id.add_data_btn);
        mUpdateDataBtn=(Button)view.findViewById(R.id.update_data_btn);
        mDeleteDataBtn=(Button)view.findViewById(R.id.delete_data_btn);
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
        
    }

    private void createDataBase(){
        mMonitorContactsSQLiteOpenHelper.getWritableDatabase();
    }
    
    private void addData(){
    	Toast.makeText(getContext(), "addData", Toast.LENGTH_SHORT).show();
    }
    
    private void updateData(){
    	Toast.makeText(getContext(), "updateData", Toast.LENGTH_SHORT).show();

    }
    
    private void deleteData(){
    	Toast.makeText(getContext(), "deleteData", Toast.LENGTH_SHORT).show();

    }
}
