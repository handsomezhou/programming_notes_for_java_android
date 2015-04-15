package com.handsomezhou.networkdemo.util;

import com.handsomezhou.networkdemo.R;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Reference:
 * http://stackoverflow.com/questions/2802472/detect-network-connection
 * -type-on-android
 * */
public class NetworkUtil {
	private final static String TAG = "NetworkUtil";

	public enum NETWORK_TYPE {
		NETWORKTYPE_INVALID,
		/* NETWORKTYPE_WAP , */
		NETWORKTYPE_2G, NETWORKTYPE_3G, NETWORKTYPE_4G_NO_LESS, // no less than
																// 4G, include
																// 4G,and so on.
		NETWORKTYPE_WIFI, NETWORKTYPE_UNKNOW,
	}

	public NetworkUtil() {

	}

	/**
	 * Get the network info
	 * 
	 * @param context
	 * @return
	 */
	public static NetworkInfo getNetworkInfo(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		return cm.getActiveNetworkInfo();
	}

	/**
	 * Check if there is any connectivity
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isConnected(Context context) {
		NetworkInfo info = NetworkUtil.getNetworkInfo(context);
		return (info != null && info.isConnected());
	}

	/**
	 * Check if there is any connectivity to a Wifi network
	 * 
	 * @param context
	 * @param type
	 * @return
	 */
	public static boolean isConnectedWifi(Context context) {
		NetworkInfo info = NetworkUtil.getNetworkInfo(context);
		return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_WIFI);
	}

	/**
	 * Check if there is any connectivity to a mobile network
	 * 
	 * @param context
	 * @param type
	 * @return
	 */
	public static boolean isConnectedMobile(Context context) {
		NetworkInfo info = NetworkUtil.getNetworkInfo(context);
		return (info != null &&info.isConnected() && info.getType() == ConnectivityManager.TYPE_MOBILE);
	}

	/**
	 * Check if there is fast connectivity
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isConnectedFast(Context context) {
		NetworkInfo info = NetworkUtil.getNetworkInfo(context);
		return (info != null && info.isConnected() && NetworkUtil
				.isConnectionFast(info.getType(), info.getSubtype()));
	}

	public static NETWORK_TYPE getNetWorkType(Context context) {
		NETWORK_TYPE networkType = NETWORK_TYPE.NETWORKTYPE_INVALID;

		NetworkInfo networkInfo = NetworkUtil.getNetworkInfo(context);
		if (networkInfo != null && networkInfo.isConnected()) {
			int type = networkInfo.getType();
			if (ConnectivityManager.TYPE_WIFI == type) {
				networkType = NETWORK_TYPE.NETWORKTYPE_WIFI;
			} else if (ConnectivityManager.TYPE_MOBILE == type) {
				Toast.makeText(context,
						"networkType:[" + networkInfo.getSubtypeName() + "]",
						Toast.LENGTH_LONG).show();
				networkType = NetworkUtil.getMobileNetWorkType(networkInfo
						.getSubtype());
			}
		} else {
			networkType = NETWORK_TYPE.NETWORKTYPE_INVALID;
		}

		return networkType;
	}

	public static String getNetWorkTypeName(Context context) {
		String networkTypeName = null;
		NetworkInfo networkInfo = NetworkUtil.getNetworkInfo(context);
		if (networkInfo != null && networkInfo.isConnected()) {
			if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
				networkTypeName = "[" + networkInfo.getTypeName() + "]" + "["
						+ networkInfo.getSubtype() + "]" + "["
						+ networkInfo.getSubtypeName() + "]";
			} else {
				networkTypeName = "[" + networkInfo.getTypeName() + "]";
			}
		} else {
			networkTypeName = context.getString(R.string.network_type_invalid);
		}

		return networkTypeName;
	}

	//public static boolean 
	/**
	 * Check if the connection is fast
	 * 
	 * @param type
	 * @param subType
	 * @return
	 */
	private static boolean isConnectionFast(int type, int subType) {
		boolean connectionFast = false;
		if (type == ConnectivityManager.TYPE_WIFI) {
			connectionFast = true;
		} else if (type == ConnectivityManager.TYPE_MOBILE) {
			connectionFast = isFastMobileNetwork(subType);
		} else {
			connectionFast = false;
		}

		return connectionFast;
	}

	/**
	 * Check if the mobile connection is fast
	 * 
	 * @param subType
	 * @return
	 */
	private static boolean isFastMobileNetwork(int subType) {
		boolean fastMobileNetwork = false;

		if ((getMobileNetWorkType(subType) == NETWORK_TYPE.NETWORKTYPE_3G)
				|| (getMobileNetWorkType(subType) == NETWORK_TYPE.NETWORKTYPE_4G_NO_LESS)) {
			fastMobileNetwork = true;
		} else {
			fastMobileNetwork = false;
		}

		return fastMobileNetwork;
	}

	private static NETWORK_TYPE getMobileNetWorkType(int subType) {
		NETWORK_TYPE networkType = NETWORK_TYPE.NETWORKTYPE_2G;

		switch (subType) {
		case TelephonyManager.NETWORK_TYPE_GPRS: // 2g ok
		case TelephonyManager.NETWORK_TYPE_CDMA: //
		case TelephonyManager.NETWORK_TYPE_IDEN: // API level 8
		// 2.5G:
		case TelephonyManager.NETWORK_TYPE_EDGE:// 2g ok
		case TelephonyManager.NETWORK_TYPE_1xRTT:// 
		case 16: // TelephonyManager.NETWORK_TYPE_GSM://16
			networkType = NETWORK_TYPE.NETWORKTYPE_2G;
			break;

		// 3G:
		case TelephonyManager.NETWORK_TYPE_UMTS: // 3g ok
		case TelephonyManager.NETWORK_TYPE_EVDO_0://
		case TelephonyManager.NETWORK_TYPE_EVDO_A://
		case TelephonyManager.NETWORK_TYPE_HSPA: //

		case TelephonyManager.NETWORK_TYPE_HSDPA:// ~ 2-14 Mbps
		case TelephonyManager.NETWORK_TYPE_HSUPA: // ~ 1-23 Mbps
		case TelephonyManager.NETWORK_TYPE_EVDO_B: // ~ 5 Mbps // API level 9
		case TelephonyManager.NETWORK_TYPE_EHRPD:// =14 // ~ 1-2 Mbps // API level 11
		case TelephonyManager.NETWORK_TYPE_HSPAP:// =15 // ~ 10-20 Mbps// API level 13
		case 17:// TelephonyManager.xxx China Mobile 3G
			networkType = NETWORK_TYPE.NETWORKTYPE_3G;
			break;
		// 4G:
		case TelephonyManager.NETWORK_TYPE_LTE: // =13 // ~ 10+ Mbps // API
			networkType = NETWORK_TYPE.NETWORKTYPE_4G_NO_LESS;
			break;
		case TelephonyManager.NETWORK_TYPE_UNKNOWN:
		default:
			networkType = NETWORK_TYPE.NETWORKTYPE_UNKNOW;
			break;
		}

		Log.i(TAG, "subType[" + subType + "]");

		return networkType;
	}

}
