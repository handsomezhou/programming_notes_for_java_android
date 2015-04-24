package com.handsomezhou.fragmentdemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

public abstract class BaseFragmentActivity extends FragmentActivity {
	private Context mContext;
	private boolean mFullScreen = true;

	@Override
	protected void onCreate(Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		setContext(this);
		if(true==isFullScreen()){
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		}
		initData();
		initView();
		initListener();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	/**
	 * init data in onCreate()
	 * 
	 * initData()->initView()->initListener()
	 */
	public abstract void initData();
	
	/**
	 * init view in onCreate()
	 * 
	 * initData()->initView()->initListener()
	 */
	public abstract void initView();
		
	
	/**
	 * init Listener in onCreate()
	 * 
	 * initData()->initView()->initListener()
	 */
	public abstract void initListener();
	
	public Context getContext() {
		return mContext;
	}

	public void setContext(Context context) {
		mContext = context;
	}
	
	public boolean isFullScreen() {
		return mFullScreen;
	}

	public void setFullScreen(boolean fullScreen) {
		mFullScreen = fullScreen;
	}
}
