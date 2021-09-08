package com.handsomezhou.demo;

import android.app.Application;
import android.content.Context;

import com.android.commontools.util.CommonUtil;
import com.android.commontools.util.DeviceUtil;
import com.android.commontools.util.LogUtil;
import com.handsomezhou.demo.util.SecurityUtil;


/**
 * Created by handsomezhou on 2021/9/8.
 */
public class AppApplication extends Application {
    private static final String TAG="AppApplication";
    public static Context sContext;
    private static AppApplication sInstance;
    private String mClientId;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext=this;
        sInstance=this;
        //MultiDex.install(this);


        LogUtil.i(TAG,"DeviceId["+ DeviceUtil.getDeviceId(this)+"]");
        LogUtil.i(TAG,"ClientId["+ SecurityUtil.getClientId(DeviceUtil.getDeviceId(this))+"]");

    }

    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context context) {
        sContext = context;
    }

    public static AppApplication getInstance() {
        return sInstance;
    }

    public static void setInstance(AppApplication instance) {
        sInstance = instance;
    }




    public String getClientId(){
        if(true== CommonUtil.isEmpty(mClientId)){
            mClientId= SecurityUtil.getClientId(DeviceUtil.getDeviceId(this));
        }

        return mClientId;
    }

}
