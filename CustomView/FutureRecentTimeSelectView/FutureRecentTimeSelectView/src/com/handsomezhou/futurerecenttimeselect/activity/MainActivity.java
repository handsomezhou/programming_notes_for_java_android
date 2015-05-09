package com.handsomezhou.futurerecenttimeselect.activity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.futurerecenttimeselect.model.AlarmMsg;
import com.handsomezhou.futurerecenttimeselect.model.TimeItemValue;
import com.handsomezhou.futurerecenttimeselect.util.AlarmUtil;
import com.handsomezhou.futurerecenttimeselect.util.TimeItemUtil;
import com.handsomezhou.futurerecenttimeselect.util.TimeUtil;
import com.handsomezhou.futurerecenttimeselect.util.ViewUtil;
import com.handsomezhou.futurerecenttimeselect.view.FutureRecentTimeSelectView;
import com.handsomezhou.futurerecenttimeselect.view.FutureRecentTimeSelectView.OnFutureRecentTimeSelectView;
import com.handsomezhou.futurerecenttimeselectview.R;

public class MainActivity extends Activity implements OnFutureRecentTimeSelectView{
	private Context mContext;
	private Button mFutureRecentTimeSelectBtn;
	private FutureRecentTimeSelectView mFutureRecentTimeSelectView;
	private AlarmMsg mAlarmMsg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initView();
		initListener();
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
		mFutureRecentTimeSelectView.updateView();
	}


	/*Start: OnFutureRecentTimeSelectView*/
	@Override
	public void onFutureRecentTimeSelectViewCancel() {
		ViewUtil.hideView(mFutureRecentTimeSelectView);
		
	}

	@Override
	public void onFutureRecentTimeSelectViewOk(TimeItemValue timeItemValue) {
		futureRecentTimeSelectViewOk(timeItemValue);
	}

	@Override
	public void onTimeChanged(TimeItemValue timeItemValue) {
		// TODO Auto-generated method stub
		
	}
	
	/*End: OnFutureRecentTimeSelectView*/
	
	private void initData(){
		mContext=this;
		mAlarmMsg=new AlarmMsg();
		
		return;
	}
	
	private void initView(){
		mFutureRecentTimeSelectBtn=(Button)findViewById(R.id.future_recent_time_select_btn);
		mFutureRecentTimeSelectView=(FutureRecentTimeSelectView) findViewById(R.id.future_recent_time_select_view);
		mFutureRecentTimeSelectView.setOnFutureRecentTimeSelectView(this);
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
		ViewUtil.showView(mFutureRecentTimeSelectView);
		//Toast.makeText(mContext, "clickFutureRecentTimeSelect", Toast.LENGTH_SHORT).show();
		return;
	}
	
	private void futureRecentTimeSelectViewOk(TimeItemValue timeItemValue){
		if(null==timeItemValue){
			return;
		}
		
		String[] dayRelativeToToday=mContext.getResources().getStringArray(R.array.day_relative_to_today);
		int year=TimeUtil.getYear();
		int month=TimeUtil.getMonth();
		int dayOfMonth=TimeUtil.getDayOfMonth()+timeItemValue.getDayItemValue();
		int hourOfDay=timeItemValue.getHourItemValue();
		int minute=timeItemValue.getMinuteItemValue();
		
		
		Toast.makeText(mContext,dayRelativeToToday[timeItemValue.getDayItemValue()]+":"+timeItemValue.getHourItemValue()+":"+timeItemValue.getMinuteItemValue()+"["+year+"-"+month+"-"+dayOfMonth+" "+hourOfDay+":"+minute+"]", Toast.LENGTH_SHORT).show();
		
		mAlarmMsg.setType(0);
		mAlarmMsg.setText("text");
		mAlarmMsg.setSender("sender");
		mAlarmMsg.setReceiver("receiver");
		
		
		long triggerAtMillis=TimeItemUtil.getTimeInMillis(timeItemValue);
		Intent intent=new Intent(mContext, AlarmNoticeActivity.class);
		intent.putExtra(AlarmNoticeActivity.ALARM_MSG_OBJECT, mAlarmMsg);
		
		PendingIntent pendingIntent=PendingIntent.getActivity(mContext, 0, intent, 0);
		AlarmUtil.set(mContext, AlarmManager.RTC_WAKEUP, triggerAtMillis, pendingIntent);
		
		ViewUtil.hideView(mFutureRecentTimeSelectView);
	}
}
