package com.handsomezhou.customdialog.activity;

import com.handsomezhou.customdialog.fragment.DialogDemoFragment;

import android.support.v4.app.Fragment;

public class DialogDemoActivity extends BaseSingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		return new DialogDemoFragment();
	}

	@Override
	protected boolean isRealTimeLoadFragment() {
		// TODO Auto-generated method stub
		return false;
	}

}
