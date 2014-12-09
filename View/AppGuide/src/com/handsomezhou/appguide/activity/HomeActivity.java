package com.handsomezhou.appguide.activity;

import com.handsomezhou.appguide.R;
import com.handsomezhou.appguide.util.DataStoreManage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {
	private Button mClearConfigurationDataBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initData();
		initView();
		initListener();
	}

	private void initData() {

	}
	
	private void initView() {
		mClearConfigurationDataBtn = (Button) findViewById(R.id.clear_configuration_data_btn);
	}

	

	private void initListener() {
		mClearConfigurationDataBtn
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						DataStoreManage
								.setGuideFirstIn(HomeActivity.this, true);
					}
				});
	}
}
