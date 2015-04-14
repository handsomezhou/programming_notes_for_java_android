package com.handsomezhou.networkdemo.util;

import android.content.Context;

import com.handsomezhou.networkdemo.application.NetWorkDemoApplication;
import com.handsomezhou.networkdemo.util.NetworkUtil.NETWORK_TYPE;

public class NetworkHelper {
	private static NetworkHelper mInstance=null;
	private Context mContext;
	private OnNetworkChange mOnNetworkChange;

	public static NetworkHelper getInstance(){
		if (null == mInstance) {
			mInstance = new NetworkHelper(NetWorkDemoApplication.getContextObject().getApplicationContext());
		}

		return mInstance;
	}
	
	public  interface OnNetworkChange{
		void onNetworkChange(NETWORK_TYPE networkType);
		

	};
	
	public void NetworkChange(){
		if (null != mOnNetworkChange) {
			NETWORK_TYPE networkType = NetworkUtil.getNetWorkType(mContext);

			mOnNetworkChange.onNetworkChange(networkType);

		}
	}
	
	public OnNetworkChange getOnNetworkChange() {
		return mOnNetworkChange;
	}


	public void setOnNetworkChange(OnNetworkChange onNetworkChange) {
		mOnNetworkChange = onNetworkChange;
	}
	
	private NetworkHelper(Context context){
		mContext = context.getApplicationContext();
		initNetworkHelper();
		
		return;
	}
	
	private void initNetworkHelper(){
		
		return;
	}
	
	/*private void freeNetworkHelper(){
		if(null!=mInstance){
			mInstance=null;
		}
		
		return;
	}*/
}
