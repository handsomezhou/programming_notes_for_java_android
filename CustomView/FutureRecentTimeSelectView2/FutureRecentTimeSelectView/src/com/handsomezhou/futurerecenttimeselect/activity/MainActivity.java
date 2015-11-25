package com.handsomezhou.futurerecenttimeselect.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.futurerecenttimeselect.model.TimeItemIndex;
import com.handsomezhou.futurerecenttimeselect.util.ViewUtil;
import com.handsomezhou.futurerecenttimeselect.view.FutureRecentTimeSelectView;
import com.handsomezhou.futurerecenttimeselect.view.FutureRecentTimeSelectView.OnFutureRecentTimeSelectView;
import com.handsomezhou.futurerecenttimeselectview.R;

public class MainActivity extends Activity implements OnFutureRecentTimeSelectView{
	private Context mContext;
	private Button mFutureRecentTimeSelectBtn;
	private FutureRecentTimeSelectView mFutureRecentTimeSelectView;
	
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
	public void onFutureRecentTimeSelectViewOk(TimeItemIndex timeItemIndex) {
		futureRecentTimeSelectViewOk(timeItemIndex);
	}

	@Override
	public void onTimeChanged(TimeItemIndex timeItemIndex) {
		// TODO Auto-generated method stub
		
	}
	
	/*End: OnFutureRecentTimeSelectView*/
	
	private void initData(){
		mContext=this;
		
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
	
	private void futureRecentTimeSelectViewOk(TimeItemIndex timeItemIndex){
		if(null==timeItemIndex){
			return;
		}
		
		Toast.makeText(mContext,timeItemIndex.getDayItemIndex()+";"+timeItemIndex.getHourItemIndex()+";"+timeItemIndex.getMinuteItemIndex(), Toast.LENGTH_SHORT).show();

	/*	if(null==timeItemValue){
			return;
		}
		
		int year=TimeUtil.getYear();
		int month=TimeUtil.getMonth();
		int dayOfMonth=TimeUtil.getDayOfMonth()+timeItemValue.getDayItemValue();
		int hourOfDay=timeItemValue.getHourItemValue();
		int minute=timeItemValue.getMinuteItemValue();
		
		
		//Toast.makeText(mContext,dayRelativeToToday[timeItemValue.getDayItemValue()]+":"+timeItemValue.getHourItemValue()+":"+timeItemValue.getMinuteItemValue()+"["+year+"-"+month+"-"+dayOfMonth+" "+hourOfDay+":"+minute+"]", Toast.LENGTH_SHORT).show();
		Toast.makeText(mContext,timeItemValue.getDayItemValue()+":"+timeItemValue.getHourItemValue()+":"+timeItemValue.getMinuteItemValue()+"["+year+"-"+month+"-"+dayOfMonth+" "+hourOfDay+":"+minute+"]", Toast.LENGTH_SHORT).show();
		
		
		
		
		long triggerAtMillis=TimeItemUtil.getTimeInMillis(timeItemValue);*/
	
		
		ViewUtil.hideView(mFutureRecentTimeSelectView);
	}
}
