package com.handsomezhou.service.startservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ListenService extends Service {

	//必须实现的方法
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	//Service被创建时回调该方法
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("Service is Created");
	}

	//Service被启动时回调该方法
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("Service is Started");
		return Service.START_STICKY;
	}
	
	//Service被关闭之前回调
	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("Service is Destroyed");
	}
	

}
