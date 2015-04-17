package com.handsomezhou.networkdemo.util;

import android.content.Context;
import android.telephony.TelephonyManager;

import  com.handsomezhou.networkdemo.application.NetWorkDemoApplication;
import com.handsomezhou.networkdemo.util.NetworkUtil.NETWORK_TYPE;

public class NetworkHelper {
	private static NetworkHelper mInstance=null;
	private Context mContext;
	private OnNetworkChange mOnNetworkChange;
	private int mCallState;//

	public static NetworkHelper getInstance(){
		if (null == mInstance) {
			mInstance = new NetworkHelper(NetWorkDemoApplication.getContextObject().getApplicationContext());
		}

		return mInstance;
	}
	
	public  interface OnNetworkChange{
		void onNetworkChange(NETWORK_TYPE networkType, int mCallState);
		

	};
	
	public void NetworkChange(){
		if (null != mOnNetworkChange) {
			NETWORK_TYPE networkType = NetworkUtil.getNetWorkType(mContext);

			mOnNetworkChange.onNetworkChange(networkType,mCallState);

		}
	}
	
	public OnNetworkChange getOnNetworkChange() {
		return mOnNetworkChange;
	}


	public void setOnNetworkChange(OnNetworkChange onNetworkChange) {
		mOnNetworkChange = onNetworkChange;
	}
	
	public int getCallState() {
		return mCallState;
	}

	public void setCallState(int callState) {
		mCallState = callState;
	}
	
	private NetworkHelper(Context context){
		mContext = context.getApplicationContext();
		initNetworkHelper();
		
		return;
	}
	
	private void initNetworkHelper(){
		setCallState(TelephonyManager.CALL_STATE_IDLE);
		return;
	}
	
	/*private void freeNetworkHelper(){
		if(null!=mInstance){
			mInstance=null;
		}
		
		return;
	}*/
}
