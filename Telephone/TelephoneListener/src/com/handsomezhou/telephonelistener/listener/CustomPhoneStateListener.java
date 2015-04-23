package com.handsomezhou.telephonelistener.listener;

import com.handsomezhou.telephonelistener.application.TelephoneListenerApplication;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class CustomPhoneStateListener extends PhoneStateListener{
	private static final String TAG="CustomPhoneStateListener";
	private static int mLastState=TelephonyManager.CALL_STATE_IDLE;
	@Override
	public void onCallStateChanged(int state, String incomingNumber) {
		
		switch (state) {
		case TelephonyManager.CALL_STATE_IDLE:
			Log.i(TAG, "state:["+state+"]"+"incomingNumber:["+incomingNumber+"]");
			
			Toast.makeText(TelephoneListenerApplication.getContextObject(),"["+incomingNumber+"]["+"idle"+"]" , Toast.LENGTH_LONG).show();
			break;
			
		case TelephonyManager.CALL_STATE_RINGING:
			Log.i(TAG, "state:["+state+"]"+"incomingNumber:["+incomingNumber+"]");
			Toast.makeText(TelephoneListenerApplication.getContextObject(),"["+incomingNumber+"]["+"ringing"+"]" , Toast.LENGTH_LONG).show();
			
			break;
			
		case TelephonyManager.CALL_STATE_OFFHOOK:
			Log.i(TAG, "state:["+state+"]"+"incomingNumber:["+incomingNumber+"]");
			Toast.makeText(TelephoneListenerApplication.getContextObject(),"["+incomingNumber+"]["+"offhook"+"]" , Toast.LENGTH_LONG).show();
			
			break;
			
		default:
			
			break;
			
		}
		
		setmLastState(state);
		super.onCallStateChanged(state, incomingNumber);
	}
	
	public static int getmLastState() {
		return mLastState;
	}
	public static void setmLastState(int mLastState) {
		CustomPhoneStateListener.mLastState = mLastState;
	}
}
