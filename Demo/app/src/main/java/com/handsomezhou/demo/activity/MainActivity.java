package com.handsomezhou.demo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.Toast;

import com.android.commontools.util.ActivityUtil;
import com.handsomezhou.demo.R;
import com.handsomezhou.demo.fragment.MainFragment;
import com.handsomezhou.demo.helper.SettingsHelper;
import com.handsomezhou.demo.receiver.CustomBroadcastReceiver;


/**
 * Created by handsomezhou on 2021/9/8.
 */
public class MainActivity extends BaseSingleFragmentActivity implements CustomBroadcastReceiver.OnCustomBroadcastReceiver{

    private static final String TAG = "MainActivity";
    private static final int DOUBLE_CLICK_EXIT_TIME_INTERVAL_MILLIS = 2000;
    private static long mBackPressedTimeMillis;
    private Context mContext;
    private MainFragment mMainFragment;
    private CustomBroadcastReceiver mCustomBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        registerBroadcastReceiver();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(null!=mMainFragment) {
            mMainFragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterBroadcastReceiver();
    }

    @Override
    protected Fragment createFragment() {
        return mMainFragment=new MainFragment();
    }

    @Override
    protected boolean isRealTimeLoadFragment() {
        return false;
    }

    @Override
    public boolean onKeyDown(int keycode, KeyEvent e) {
        if(null!=mMainFragment) {
            mMainFragment.onKeyDown(keycode, e);
        }

        return super.onKeyDown(keycode, e);
    }


    @Override
    public void onBackPressed() {
        if (false == SettingsHelper.getInstance().isExitAppPrompt()) {
            runInBackgroud();
        } else {
            doubleClickExit();
        }
    }

    /**
     * start:CustomBroadcastReceiver.OnCustomBroadcastReceiver
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        onReceiveBroadcast(context,intent);
    }
    /**
     * end:CustomBroadcastReceiver.OnCustomBroadcastReceiver
     */

    public static void launch(Context context){
        ActivityUtil.launch(context, MainActivity.class);
    }


    private void registerBroadcastReceiver() {

        mCustomBroadcastReceiver = new CustomBroadcastReceiver();
        mCustomBroadcastReceiver.setOnCustomBroadcastReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
       // intentFilter.addAction(PushMessageReceiver.ACTION_DISTRIBUTE_MESSAGE);
        registerReceiver(mCustomBroadcastReceiver, intentFilter);
    }

    private void unregisterBroadcastReceiver() {
        if (null!=mCustomBroadcastReceiver) {
            unregisterReceiver(mCustomBroadcastReceiver);
        }
    }

    private void onReceiveBroadcast(Context context, Intent intent){
        do{
            String action = intent.getAction();

            if(null==action){
                break;
            }

            switch (action){
               /* case PushMessageReceiver.ACTION_DISTRIBUTE_MESSAGE:
                    Msg msg=(Msg) intent.getSerializableExtra(PushMessageReceiver.EXTRA_DISTRIBUTE_MESSAGE_PARAMETER);
                    if(null!= mMainFragment) {
                        mMainFragment.onReceiveBroadcast(msg);
                    }
                    break;*/
                default:
                    break;
            }
        }while (false);

        return;
    }
    private void doubleClickExit() {
        if (mBackPressedTimeMillis + DOUBLE_CLICK_EXIT_TIME_INTERVAL_MILLIS > System
                .currentTimeMillis()) {
            runInBackgroud();

        } else {
            String DoubleBackPressExitApp=mContext.getString(R.string.double_back_press_exit_app, mContext.getString(R.string.app_name));
            Toast.makeText(mContext, DoubleBackPressExitApp, Toast.LENGTH_SHORT).show();
        }

        mBackPressedTimeMillis = System.currentTimeMillis();
    }

    private void runInBackgroud(){
        moveTaskToBack(true);

    }
}

