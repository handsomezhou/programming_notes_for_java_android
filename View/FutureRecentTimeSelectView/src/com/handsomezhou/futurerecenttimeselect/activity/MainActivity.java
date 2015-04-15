package com.handsomezhou.futurerecenttimeselect.activity;

import com.handsomezhou.futurerecenttimeselectview.R;
import com.handsomezhou.futurerecenttimeselectview.R.id;
import com.handsomezhou.futurerecenttimeselectview.R.layout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Context mContext;
	private Button mFutureRecentTimeSelectBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initView();
		initListener();
	}
	
	private void initData(){
		mContext=this;
		return;
	}
	
	private void initView(){
		mFutureRecentTimeSelectBtn=(Button)findViewById(R.id.future_recent_time_select_btn);
		return;
	}
	
	private void initListener(){
		mFutureRecentTimeSelectBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clickFutureRecentTimeSelect();
			}
		});
	}
	
	private void clickFutureRecentTimeSelect(){
		
		Toast.makeText(mContext, "clickFutureRecentTimeSelect", Toast.LENGTH_SHORT).show();
		return;
	}
}
