package com.handsomezhou.appguide.activity;

import com.handsomezhou.appguide.R;
import com.handsomezhou.appguide.util.DataStoreManage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
/**
 *@reference:
 *http://download.csdn.net/detail/wangjinyu501/5875375
 *http://blog.csdn.net/harvic880925/article/details/38453725
 */
public class StartActivity extends Activity {
	private static final String TAG = "StartActivity";
	private static final int START_DELAY_MILLIS=3000;//ms
	private static final int GO_HOME = 0x01;
	private static final int GO_GUIDE = 0x02;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		initData();
	}

	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GO_HOME:
				goHome();
				break;
			case GO_GUIDE:
				goGuide();
				break;
			}
			super.handleMessage(msg);
		}

	};

	private void initData() {
		boolean guideFirstIn = DataStoreManage
				.isGuideFirstIn(StartActivity.this);
		
		if(guideFirstIn){
			mHandler.sendEmptyMessageDelayed(GO_GUIDE, START_DELAY_MILLIS);
		}else{
			mHandler.sendEmptyMessageDelayed(GO_HOME, START_DELAY_MILLIS);
		}

		return;
	}
	
	private void goHome(){
		Intent intent=new Intent(StartActivity.this, HomeActivity.class);
		startActivity(intent);
		this.finish();
	}
	
	private void goGuide(){
		Intent intent=new Intent(StartActivity.this, GuideActivity.class);
		startActivity(intent);
		this.finish();
	}
}
