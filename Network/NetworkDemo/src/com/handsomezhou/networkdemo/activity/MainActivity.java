package com.handsomezhou.networkdemo.activity;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;

import com.handsomezhou.networkdemo.R;
import com.handsomezhou.networkdemo.broadcast.NetworkChangeReceiver;

public class MainActivity extends Activity {
	private IntentFilter mIntentFilter;
	private NetworkChangeReceiver mNetworkChangeReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initView();
		initListener();
	}
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver();
	}


	private void initData(){
		
		registerReceiver();
		
		return;
	}
	
	private void initView(){
		
		return;
	}
	
	private void initListener(){
		
		return;
	}
	
	private void registerReceiver(){
		
		mIntentFilter=new IntentFilter();
		mIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		mNetworkChangeReceiver=new NetworkChangeReceiver();
		registerReceiver(mNetworkChangeReceiver, mIntentFilter);
	
		return;
	}
	
	private void unregisterReceiver(){
		
		unregisterReceiver(mNetworkChangeReceiver);
		
		return;
	}
	
	

}
