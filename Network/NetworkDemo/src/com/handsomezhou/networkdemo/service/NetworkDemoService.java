package com.handsomezhou.networkdemo.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.handsomezhou.networkdemo.listener.CustomPhoneStateListener;

public class NetworkDemoService extends Service{

	private static final String TAG="NetworkDemoService";
	public static final String ACTION_NETWORK_DEMO__SERVICE="com.handsomezhou.networkdemo.service.NETWORK_DEMO_SERVICE";
	private TelephonyManager mTelephonyManager=null;
	
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		initListener();
		Log.i(TAG, "NetworkDemoService onCreate()");
		
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(TAG, "NetworkDemoService onStartCommand()");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		Log.i(TAG, "NetworkDemoService onDestroy()");
		super.onDestroy();
	
		startService();
		
	}
	
	private void startService(){
		Intent intent=new Intent();
		intent.setAction(ACTION_NETWORK_DEMO__SERVICE);
		startService(intent);
	}

	private void initListener(){
		mTelephonyManager=(TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
		mTelephonyManager.listen(new CustomPhoneStateListener(), PhoneStateListener.LISTEN_CALL_STATE);		
	}
	


	
	

}
