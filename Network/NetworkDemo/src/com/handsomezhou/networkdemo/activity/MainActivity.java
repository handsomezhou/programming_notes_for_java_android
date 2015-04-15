package com.handsomezhou.networkdemo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.networkdemo.R;
import com.handsomezhou.networkdemo.broadcast.NetworkChangeReceiver;
import com.handsomezhou.networkdemo.util.NetworkHelper;
import com.handsomezhou.networkdemo.util.NetworkHelper.OnNetworkChange;
import com.handsomezhou.networkdemo.util.NetworkUtil;
import com.handsomezhou.networkdemo.util.NetworkUtil.NETWORK_TYPE;
import com.handsomezhou.networkdemo.view.NetworkStateTipsView;

public class MainActivity extends Activity implements OnNetworkChange {
	private Context mContext;
	private IntentFilter mIntentFilter;
	private NetworkChangeReceiver mNetworkChangeReceiver;

	private NetworkStateTipsView mNetworkStateTipsView;
	private Button mUpdateNetworkStateBtn;

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
	public void onNetworkChange(NETWORK_TYPE networkType) {
		mNetworkStateTipsView.updateView(networkType);
	}

	/* End: OnNetworkChange */

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
}
