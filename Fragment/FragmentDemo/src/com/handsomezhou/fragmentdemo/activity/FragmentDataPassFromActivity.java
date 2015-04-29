package com.handsomezhou.fragmentdemo.activity;

import android.support.v4.app.Fragment;

import com.handsomezhou.fragmentdemo.fragment.FragmentDataPassFromFragment;

public class FragmentDataPassFromActivity extends BaseSingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FragmentDataPassFromFragment();
    }

    @Override
    protected boolean isRealTimeLoadFragment() {
        return false;
    }    
}
