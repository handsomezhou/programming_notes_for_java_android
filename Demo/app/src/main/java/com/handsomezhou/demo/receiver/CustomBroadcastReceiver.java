package com.handsomezhou.demo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.android.commontools.util.LogUtil;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public class CustomBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG="CustomBroadcast";

    private OnCustomBroadcastReceiver mOnCustomBroadcastReceiver;

    public interface OnCustomBroadcastReceiver{
        void onReceive(Context context, Intent intent);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        do{
            if(null==context){
                break;
            }
            if(null==intent){
                break;
            }
            if(null!= mOnCustomBroadcastReceiver){
                mOnCustomBroadcastReceiver.onReceive(context,intent);
            }
            LogUtil.i(TAG,"CustomBroadcastReceiver+"+intent.getAction());
        }while (false);
        return;
    }

    public OnCustomBroadcastReceiver getOnCustomBroadcastReceiver() {
        return mOnCustomBroadcastReceiver;
    }

    public void setOnCustomBroadcastReceiver(OnCustomBroadcastReceiver onCustomBroadcastReceiver) {
        mOnCustomBroadcastReceiver = onCustomBroadcastReceiver;
    }
}
