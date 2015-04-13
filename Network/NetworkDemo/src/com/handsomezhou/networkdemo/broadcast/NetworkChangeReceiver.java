package com.handsomezhou.networkdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {
	private static final String TAG="NetworkChangeReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
		if((null!=networkInfo)&&networkInfo.isAvailable()){
			Toast.makeText(context,"network is available" , Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(context,"network is unavailable" , Toast.LENGTH_SHORT).show();
		}

	}

}
