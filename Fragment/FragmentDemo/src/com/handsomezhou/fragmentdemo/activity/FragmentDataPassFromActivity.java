package com.handsomezhou.fragmentdemo.activity;

import com.handsomezhou.fragmentdemo.fragment.FragmentDataPassFromFragment;

import android.content.Intent;
import android.support.v4.app.Fragment;

public class FragmentDataPassFromActivity extends BaseSingleFragmentActivity {
	private Fragment mFragmentDataPassFromFragment;
    @Override
    protected Fragment createFragment() {
        // TODO Auto-generated method stub
        return mFragmentDataPassFromFragment=new FragmentDataPassFromFragment();
    }

    @Override
    protected boolean isRealTimeLoadFragment() {
        // TODO Auto-generated method stub
        return false;
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		mFragmentDataPassFromFragment.onActivityResult(requestCode, resultCode, data);
		//super.onActivityResult(requestCode, resultCode, data);
		
	}
}
