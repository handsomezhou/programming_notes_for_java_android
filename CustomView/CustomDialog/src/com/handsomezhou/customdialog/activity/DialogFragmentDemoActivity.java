package com.handsomezhou.customdialog.activity;

import android.support.v4.app.Fragment;

import com.handsomezhou.customdialog.fragment.DialogFragmentDemoFragment;

public class DialogFragmentDemoActivity extends BaseSingleFragmentActivity {
	private Fragment mDialogFragmentDemoFragment;
	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		return mDialogFragmentDemoFragment=new DialogFragmentDemoFragment();
	}

	@Override
	protected boolean isRealTimeLoadFragment() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onBackPressed() {
		((DialogFragmentDemoFragment) mDialogFragmentDemoFragment).clickExitDialog();
		
	}
	
	

}
