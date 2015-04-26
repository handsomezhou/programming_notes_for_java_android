package com.handsomezhou.fragmentdemo.activity;

import com.handsomezhou.fragmentdemo.fragment.AddressBookBottomTabFragment;

import android.support.v4.app.Fragment;

public class AddressBookBottomTabActivity extends BaseSingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		
		return new AddressBookBottomTabFragment();
	}

	@Override
	protected boolean isRealTimeLoadFragment() {
		// TODO Auto-generated method stub
		return false;
	}

}
