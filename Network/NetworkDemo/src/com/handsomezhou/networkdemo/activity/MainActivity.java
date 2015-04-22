package com.handsomezhou.networkdemo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.handsomezhou.networkdemo.R;
import com.handsomezhou.networkdemo.broadcast.NetworkChangeReceiver;
import com.handsomezhou.networkdemo.service.NetworkDemoService;
import com.handsomezhou.networkdemo.util.NetworkHelper;
import com.handsomezhou.networkdemo.util.NetworkHelper.OnNetworkChange;
import com.handsomezhou.networkdemo.util.NetworkUtil;
import com.handsomezhou.networkdemo.util.NetworkUtil.NETWORK_TYPE;
import com.handsomezhou.networkdemo.view.NetworkStateTipsView;

public class MainActivity extends Activity implements OnNetworkChange {
	private static final String TAG="MainActivity";
	private Context mContext;
	private IntentFilter mIntentFilter;
	private NetworkChangeReceiver mNetworkChangeReceiver;
	private AsyncTask<Object, Object, NETWORK_TYPE> mNetworkReachableCheckAsyncTask;
	private NetworkStateTipsView mNetworkStateTipsView;
	private Button mUpdateNetworkStateBtn;
	private int mCurrentCallState;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initView();
		initListener();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver();
	}

	/* Start: OnNetworkChange */
	@Override
	public void onNetworkChange(NETWORK_TYPE networkType,int callState) {
		mNetworkStateTipsView.updateView(networkType,callState);
		setCurrentCallState(callState);
		if((networkType!=NETWORK_TYPE.NETWORKTYPE_INVALID)){
			netWorkStateCheck();
		}
	}
	/* End: OnNetworkChange */

	public int getCurrentCallState() {
		return mCurrentCallState;
	}

	public void setCurrentCallState(int currentCallState) {
		mCurrentCallState = currentCallState;
	}
	
	private void initData() {
		mContext = this;
		NetworkHelper.getInstance().setOnNetworkChange(this);
		registerReceiver();

		return;
	}

	private void initView() {
		mNetworkStateTipsView=(NetworkStateTipsView) findViewById(R.id.network_state_tips_view);
		mUpdateNetworkStateBtn=(Button)findViewById(R.id.update_network_state_btn);
		return;
	}

	private void initListener() {
		mUpdateNetworkStateBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				updateNetworkState();

			}
		});
		
		Intent  intent=new Intent(MainActivity.this, NetworkDemoService.class);
		intent.setAction(NetworkDemoService.ACTION_NETWORK_DEMO__SERVICE);
		startService(intent);
		
		return;
	}

	private void registerReceiver() {

		mIntentFilter = new IntentFilter();
		mIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		mNetworkChangeReceiver = new NetworkChangeReceiver();
		registerReceiver(mNetworkChangeReceiver, mIntentFilter);

		return;
	}

	private void unregisterReceiver() {

		unregisterReceiver(mNetworkChangeReceiver);

		return;
	}

	private void updateNetworkState(){
		mNetworkStateTipsView.updateView();
	}
	
	private void netWorkStateCheck(){
		mNetworkReachableCheckAsyncTask=new AsyncTask<Object, Object, NetworkUtil.NETWORK_TYPE>(){

			@Override
			protected NETWORK_TYPE doInBackground(Object... params) {
				NETWORK_TYPE networkType=NETWORK_TYPE.NETWORKTYPE_INVALID;;
				boolean reachable=NetworkUtil.isReachable();
				if(true==reachable){
					networkType=NETWORK_TYPE.NETWORKTYPE_UNKNOW;
				}
				return networkType;
			}

			@Override
			protected void onPostExecute(NETWORK_TYPE networkType) {
				mNetworkStateTipsView.updateView(networkType,getCurrentCallState());
				super.onPostExecute(networkType);
			}
		}.execute();
	}
}
