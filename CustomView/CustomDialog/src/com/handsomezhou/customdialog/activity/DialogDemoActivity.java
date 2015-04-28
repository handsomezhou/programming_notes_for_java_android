package com.handsomezhou.customdialog.activity;

import com.handsomezhou.customdialog.fragment.DialogDemoFragment;

import android.support.v4.app.Fragment;

public class DialogDemoActivity extends BaseSingleFragmentActivity {
    private Fragment mDialogDemoFragment;
	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		return mDialogDemoFragment=new DialogDemoFragment();
	}

	@Override
	protected boolean isRealTimeLoadFragment() {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public void onBackPressed() {
       if(mDialogDemoFragment instanceof DialogDemoFragment){
           ((DialogDemoFragment) mDialogDemoFragment).clickExitDialog();
       }
    }
	
	
	
	

}
