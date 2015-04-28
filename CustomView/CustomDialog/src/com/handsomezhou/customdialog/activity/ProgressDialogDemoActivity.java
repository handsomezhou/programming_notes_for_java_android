package com.handsomezhou.customdialog.activity;

import com.handsomezhou.customdialog.fragment.ProgressDialogDemoFragment;

import android.support.v4.app.Fragment;

public class ProgressDialogDemoActivity extends BaseSingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        // TODO Auto-generated method stub
        return new ProgressDialogDemoFragment();
    }

    @Override
    protected boolean isRealTimeLoadFragment() {
        // TODO Auto-generated method stub
        return false;
    }

}
