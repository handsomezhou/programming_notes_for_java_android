package com.handsomezhou.networkdemo.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.handsomezhou.networkdemo.helper.NetworkHelper;

public class NetworkChangeReceiver extends BroadcastReceiver {
	private static final String TAG="NetworkChangeReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		/*ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
		if((null!=networkInfo)&&networkInfo.isAvailable()){
			Toast.makeText(context,"network is available" , Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(context,"network is unavailable" , Toast.LENGTH_SHORT).show();
		}
*/
		NetworkHelper.getInstance().NetworkChange();
	}

}
