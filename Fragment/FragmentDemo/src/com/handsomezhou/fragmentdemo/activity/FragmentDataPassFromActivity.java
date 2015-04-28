package com.handsomezhou.fragmentdemo.activity;

import com.handsomezhou.fragmentdemo.fragment.FragmentDataPassFromFragment;

import android.support.v4.app.Fragment;

public class FragmentDataPassFromActivity extends BaseSingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        // TODO Auto-generated method stub
        return new FragmentDataPassFromFragment();
    }

    @Override
    protected boolean isRealTimeLoadFragment() {
        // TODO Auto-generated method stub
        return false;
    }

}
