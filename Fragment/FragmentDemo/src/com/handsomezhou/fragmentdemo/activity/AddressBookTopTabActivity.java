package com.handsomezhou.fragmentdemo.activity;

import com.handsomezhou.fragmentdemo.fragment.AddressBookTopTabFragment;
import android.support.v4.app.Fragment;

public class AddressBookTopTabActivity extends BaseSingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		return new AddressBookTopTabFragment();
	}

	@Override
	protected boolean isRealTimeLoadFragment() {
		// TODO Auto-generated method stub
		return false;
	}

}
