package com.handsomezhou.fragmentdemo.activity;

import java.util.Date;

import com.handsomezhou.fragmentdemo.fragment.FragmentDataPassToFragment;

import android.support.v4.app.Fragment;

public class FragmentDataPassToActivity extends BaseSingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        Date date=(Date)getIntent() .getSerializableExtra(FragmentDataPassToFragment.EXTRA_DATE);
        
        return FragmentDataPassToFragment.newInstance(date);
    }

    @Override
    protected boolean isRealTimeLoadFragment() {
        // TODO Auto-generated method stub
        return false;
    }

}
