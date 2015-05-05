package com.handsomezhou.fragmentdemo.activity;

import com.handsomezhou.fragmentdemo.fragment.GridViewFragment;

import android.support.v4.app.Fragment;

public class GridViewActivity extends BaseSingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new GridViewFragment();
    }

    @Override
    protected boolean isRealTimeLoadFragment() {
        return false;
    }

}
