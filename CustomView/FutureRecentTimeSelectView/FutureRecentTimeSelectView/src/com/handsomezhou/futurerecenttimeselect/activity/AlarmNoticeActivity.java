package com.handsomezhou.futurerecenttimeselect.activity;


import com.handsomezhou.futurerecenttimeselect.model.AlarmMsg;
import com.handsomezhou.futurerecenttimeselectview.R;

import android.app.Activity;
import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class AlarmNoticeActivity extends Activity {
	public static final String ALARM_MSG_OBJECT="ALARM_MSG";
	private Context mContext;
	private AlarmMsg mAlarmMsg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm_notice);
		initData();
		initView();
		initListener();
	}
	
	private void initData(){
		mContext=this;
		mAlarmMsg=(AlarmMsg) getIntent().getSerializableExtra(ALARM_MSG_OBJECT);
		Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);  
		Ringtone ringtone = RingtoneManager.getRingtone(mContext,notification);  
		ringtone.play();
		Toast.makeText(mContext, mAlarmMsg.getSender()+";"+mAlarmMsg.getReceiver()+";"+mAlarmMsg.getText(), Toast.LENGTH_LONG).show();
		
		return;
	}
	
	private void initView(){
		
		return;
	}
	
	private void initListener(){
		
		return;
	}

}
