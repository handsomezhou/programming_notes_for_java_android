
package com.handsomezhou.telephonelistener.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.handsomezhou.telephonelistener.R;
import com.handsomezhou.telephonelistener.service.TelephoneListenerService;

public class MainActivity extends Activity {
    private Button mStartServiceBtn;
    private Button mStopServiceBtn;
    private Intent  intent=null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initListener();
    }

    private void initData(){
        mStartServiceBtn=(Button) findViewById(R.id.start_service_btn);
        mStopServiceBtn=(Button) findViewById(R.id.stop_service_btn);
      
        return;
    }
    
    private void initView(){
        
        return;
    }
    
    private void initListener(){
        mStartServiceBtn.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                startService();
                
            }
        });
        
        mStopServiceBtn.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                stopService();
            }
        });
        
        startService();
        
        return;
    }
    
    private void startService(){
        intent=new Intent(MainActivity.this, TelephoneListenerService.class);
        intent.setAction(TelephoneListenerService.ACTION_TELEPHONE_LISTENER__SERVICE);
        startService(intent);
    }
    
    private void stopService(){
        intent=new Intent(MainActivity.this, TelephoneListenerService.class);
        intent.setAction(TelephoneListenerService.ACTION_TELEPHONE_LISTENER__SERVICE);
        stopService(intent);
    }

}
