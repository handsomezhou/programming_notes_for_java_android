package com.handsomezhou.futurerecenttimeselect.view;


import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;

import com.handsomezhou.futurerecenttimeselectview.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class FutureRecentTimeSelectView extends LinearLayout {
	private Context mContext;
	private View mFutureRecentTimeSelectView;
	private List<String> mDayList;
	private List<String> mHourList;
	private List<String> mMinuteList;
	
	private ArrayWheelAdapter<String> mDayWheelAdapter;
	private ArrayWheelAdapter<String> mHourWheelAdapter;
	private ArrayWheelAdapter<String> mMinuteWheelAdapter;
	
	private WheelView mDayWheelView;
	private WheelView mHourWheelView;
	private WheelView mMinuteWheelView;
	
	public FutureRecentTimeSelectView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext=context;
		initData();
		initView();
		initListener();
	}

	private void initData(){
		String[] dayStrings=mContext.getResources().getStringArray(R.array.day_relative_to_today);
		mDayList=Arrays.asList(dayStrings);
		
		String[] hourStrings=mContext.getResources().getStringArray(R.array.hour);
		mHourList=Arrays.asList(hourStrings);
		
		String[] minuteStrings=mContext.getResources().getStringArray(R.array.minute);
		mMinuteList=Arrays.asList(minuteStrings);
		
		return;
	}
	
	private void initView(){
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mFutureRecentTimeSelectView = inflater.inflate(R.layout.future_recent_time_select_layout,this);
		mDayWheelView=(WheelView) mFutureRecentTimeSelectView.findViewById(R.id.day_wheel_view);
		mHourWheelView=(WheelView) mFutureRecentTimeSelectView.findViewById(R.id.hour_wheel_view);
		mMinuteWheelView=(WheelView) mMinuteWheelView.findViewById(R.id.minute_wheel_view);
		
		return;
	}
	
	private void initListener(){
		
		return;
	}
}
