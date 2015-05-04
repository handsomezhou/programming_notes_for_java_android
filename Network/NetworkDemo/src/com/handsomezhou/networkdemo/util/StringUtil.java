package com.handsomezhou.networkdemo.util;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.handsomezhou.networkdemo.R;
import com.handsomezhou.networkdemo.util.NetworkUtil.NETWORK_TYPE;

public class StringUtil {
	
	public static String  getNetworkType(Context context,NETWORK_TYPE networkType){
		String currentnetworkPrefix = context.getString(R.string.network_type_state);
		String networkTypeContent=null;
		switch (networkType) {
		case NETWORKTYPE_INVALID:
			networkTypeContent=context.getString(R.string.network_type_invalid);
			break;

		case NETWORKTYPE_2G:
			networkTypeContent=context.getString(R.string.network_type_2g);
			break;

		case NETWORKTYPE_3G:
			networkTypeContent=context.getString(R.string.network_type_3g);
			break;

		case NETWORKTYPE_4G_NO_LESS:
			networkTypeContent=context.getString(R.string.network_type_4g_no_less);
			break;
		case NETWORKTYPE_WIFI:
			networkTypeContent=context.getString(R.string.network_type_wifi);
			break;

		default:
			networkTypeContent=context.getString(R.string.network_type_unknow);

			break;
		}
		return (currentnetworkPrefix+networkTypeContent);
	}
	
	public static String getCallState(Context context, int callState) {
		String callStatePrefix = context.getString(R.string.call_state);
		String callStateContext = null;
		switch (callState) {
		case TelephonyManager.CALL_STATE_IDLE:
			callStateContext = context.getString(R.string.call_state_idle);
			break;

		case TelephonyManager.CALL_STATE_RINGING:
			callStateContext = context.getString(R.string.call_state_ringing);

			break;
		case TelephonyManager.CALL_STATE_OFFHOOK:
			callStateContext = context.getString(R.string.call_state_offhook);
			break;
		default:
			break;
		}

		return (callStatePrefix + callStateContext);
	}
}
