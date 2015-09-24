package com.handsomezhou.multiplelistitem.activity;

import com.handsomezhou.multiplelistitem.fragment.MainFragment;

import android.support.v4.app.Fragment;


public class MainActivity extends BaseSingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        // TODO Auto-generated method stub
        return new MainFragment();
    }

    @Override
    protected boolean isRealTimeLoadFragment() {
        // TODO Auto-generated method stub
        return false;
    }


	

}
