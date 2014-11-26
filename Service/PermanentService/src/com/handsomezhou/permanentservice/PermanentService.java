package com.handsomezhou.permanentservice;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

@SuppressLint("HandlerLeak")
public class PermanentService extends Service {
	private static final String TAG="PermanentService";
	public static final String ACTION_PERMANENT_SERVICE="com.handsomezhou.permanentservice.PermanentService";
	private static final int SLEEP_TIME_MILLIS=5000;	//ms
	private static final int WHAT_TIME_TICKS=0x01;
	private long mCurrentTimeSec=0;
	private PermanentServiceThread mPermanentServiceThread=null;
	private Handler mHandler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
		 switch (msg.what) {
			case WHAT_TIME_TICKS:
				mCurrentTimeSec=System.currentTimeMillis()/1000;
				Toast.makeText(PermanentService.this, "[Time:"+mCurrentTimeSec+"(s)]", Toast.LENGTH_SHORT).show();
				Log.i(TAG, "["+mCurrentTimeSec+"]PermanentService running");
				break;
	
			default:
				break;
		}
			
		}
		
	};
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		Log.i(TAG, "PermanentService Create");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(TAG, "PermanentService Start");
		mPermanentServiceThread=new PermanentServiceThread();
		mPermanentServiceThread.start();
		
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "PermanentService Destroy");
		if(null!=mPermanentServiceThread){
			mPermanentServiceThread.setExit(true);
		}
		
		Intent intent=new Intent();
		intent.setAction(ACTION_PERMANENT_SERVICE);
		startService(intent);
	}

	private class PermanentServiceThread extends Thread{
		private volatile boolean exit = false;

		public boolean isExit() {
			return exit;
		}

		public void setExit(boolean exit) {
			this.exit = exit;
		}

		@Override
		public void run() {
			while(true!=isExit()){
				try {
					sleep(SLEEP_TIME_MILLIS);
					mHandler.sendEmptyMessage(WHAT_TIME_TICKS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
