package com.handsomezhou.permanentservice;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	private Button mStartServiceBtn;
	private Button mStopServiceBtn;
	private Button mUninstallAppBtn;
	private Intent mServiceIntent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initData();
		initView();
		initListener();
	}
	
	private void initData(){
		mServiceIntent=new Intent();
		mServiceIntent.setAction(PermanentService.ACTION_PERMANENT_SERVICE);
		return;
	}
	
	private void initView(){
		mStartServiceBtn=(Button) findViewById(R.id.start_service_btn);
		mStopServiceBtn=(Button) findViewById(R.id.stop_service_btn);
		mUninstallAppBtn=(Button) findViewById(R.id.uninstall_app_btn);
		
		return;
	}
	
	private void initListener(){
		mStartServiceBtn.setOnClickListener(this);
		mStopServiceBtn.setOnClickListener(this);
		mUninstallAppBtn.setOnClickListener(this);
		
		return;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start_service_btn:
			startService();
			break;
		case R.id.stop_service_btn:
			stopService();
			break;
		case R.id.uninstall_app_btn:
			uninstallApp();
			break;
		default:
			break;
		}
	}
	
	private void startService(){
		
		startService(mServiceIntent);
		
		return;
	}
	
	private void stopService(){
		
		stopService(mServiceIntent);
		
		return;
	}
	
	private void uninstallApp(){
		Intent intent=new Intent();
		PackageInfo packageInfo = null;
		try {
			packageInfo = getPackageManager().getPackageInfo(this.getPackageName(), 0);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String uriString="package:"+packageInfo.packageName;
		Uri uri=Uri.parse(uriString);
		
		intent.setAction(Intent.ACTION_DELETE);
		intent.setData(uri);
		startActivity(intent);
		//finish();
		return;
	}
}
