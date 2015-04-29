package com.handsomezhou.fragmentdemo.activity;

import java.util.Date;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.handsomezhou.fragmentdemo.fragment.FragmentDataPassToFragment;

public class FragmentDataPassToActivity extends BaseSingleFragmentActivity {
    private Fragment mFragmentDataPassToFragment; 
    @Override
    protected Fragment createFragment() {
        Date date=(Date)getIntent() .getSerializableExtra(FragmentDataPassToFragment.EXTRA_DATE);
        return mFragmentDataPassToFragment=FragmentDataPassToFragment.newInstance(date);
    }

    @Override
    protected boolean isRealTimeLoadFragment() {
        return false;
    }
    
    @Override
    public void onBackPressed() {
        if(mFragmentDataPassToFragment instanceof FragmentDataPassToFragment){
            ((FragmentDataPassToFragment) mFragmentDataPassToFragment).sendResult(Activity.RESULT_OK);
        }
        
        super.onBackPressed();
    }

}
