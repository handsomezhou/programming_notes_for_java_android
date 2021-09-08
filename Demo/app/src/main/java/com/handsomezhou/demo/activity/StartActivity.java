package com.handsomezhou.demo.activity;

import android.support.v4.app.Fragment;

import com.handsomezhou.demo.fragment.StartFragment;


/**
 * Created by handsomezhou on 2021/9/8.
 */
public class StartActivity extends BaseSingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new StartFragment();
    }

    @Override
    protected boolean isRealTimeLoadFragment() {
        return false;
    }
}