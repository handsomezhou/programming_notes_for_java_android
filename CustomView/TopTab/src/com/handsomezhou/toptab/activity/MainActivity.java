package com.handsomezhou.toptab.activity;

import android.support.v4.app.Fragment;

import com.handsomezhou.toptab.fragment.MainFragment;

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
