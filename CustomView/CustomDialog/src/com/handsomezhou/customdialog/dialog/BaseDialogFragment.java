package com.handsomezhou.customdialog.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.view.View;

public abstract class BaseDialogFragment extends DialogFragment {
	private Context mContext;

	private AlertDialog mAlertDialog;
	
	private int mViewSpacingLeft=0;
	private int mViewSpacingTop=0;
	private int mViewSpacingRight=0;
	private int mViewSpacingBottom=0;

	public BaseDialogFragment(Context context) {
		super();
		mContext =context;
		View view=getView();
		mAlertDialog = new AlertDialog.Builder(mContext).create();
		mAlertDialog.setView(view, mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight,mViewSpacingBottom);
		mAlertDialog.setCanceledOnTouchOutside(false);
	}
	
	public abstract View getView();
	
	public Context getContext() {
		return mContext;
	}

	public void setContext(Context context) {
		mContext = context;
	}
	
	public AlertDialog getAlertDialog() {
		return mAlertDialog;
	}

	public void setAlertDialog(AlertDialog alertDialog) {
		mAlertDialog = alertDialog;
	}
	
	public void setCanceledOnTouchOutside(boolean cancel){
		mAlertDialog.setCanceledOnTouchOutside(cancel);
	}
}
