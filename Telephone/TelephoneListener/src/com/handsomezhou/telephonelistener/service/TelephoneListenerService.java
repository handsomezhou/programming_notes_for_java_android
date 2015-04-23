package com.handsomezhou.telephonelistener.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.handsomezhou.telephonelistener.application.TelephoneListenerApplication;
import com.handsomezhou.telephonelistener.listener.CustomPhoneStateListener;

public class TelephoneListenerService extends Service{

	private static final String TAG="TelephoneListenerService";
	public static final String ACTION_TELEPHONE_LISTENER__SERVICE="com.handsomezhou.telephonelistener.service.TELEPHONE_LISTENER__SERVICE";
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
		Log.i(TAG, "TelephoneListenerService onCreate()");
		Toast.makeText(TelephoneListenerApplication.getContextObject(), "TelephoneListenerService start", Toast.LENGTH_LONG).show();
		
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(TAG, "TelephoneListenerService onStartCommand()");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		Log.i(TAG, "TelephoneListenerService onDestroy()");
		super.onDestroy();
	
		startService();
		
	}
	
	private void startService(){
		Intent intent=new Intent();
		intent.setAction(ACTION_TELEPHONE_LISTENER__SERVICE);
		startService(intent);
	}

	private void initListener(){
		mTelephonyManager=(TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
		mTelephonyManager.listen(new CustomPhoneStateListener(), PhoneStateListener.LISTEN_CALL_STATE);		
	}
}
