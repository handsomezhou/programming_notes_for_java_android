
package com.handsomezhou.telephonelistener.application;

import android.app.Application;
import android.content.Context;

public class TelephoneListenerApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContextObject() {
        return mContext;
    }
}
