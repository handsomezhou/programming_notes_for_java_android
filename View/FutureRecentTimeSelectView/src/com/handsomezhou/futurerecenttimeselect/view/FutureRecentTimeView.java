package com.handsomezhou.futurerecenttimeselect.view;


import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.handsomezhou.futurerecenttimeselect.util.TimeUtil;
import com.handsomezhou.futurerecenttimeselectview.R;

public class FutureRecentTimeView extends LinearLayout{
	public static final String TAG="FutureRecentTimeView";
	public static final int WHEEL_VIEW_VISIBLE_ITEMS=5;
	private Context mContext;
	private OnFutureRecentTimeView mOnFutureRecentTimeView;
	private View mFutureRecentTimeView;
	private String[] mDayStrings;
	private String[] mHourStrings;
	private String[] mMinuteStrings;
	/*private List<String> mDayList;
	private List<String> mHourList;
	private List<String> mMinuteList;*/
	
	private ArrayWheelAdapter<String> mDayWheelAdapter;
	private ArrayWheelAdapter<String> mHourWheelAdapter;
	private ArrayWheelAdapter<String> mMinuteWheelAdapter;
	
	private WheelView mDayWheelView;
	private WheelView mHourWheelView;
	private WheelView mMinuteWheelView;
	
	private int mDayLastItem;  
	private int mDayCurrentItem;
	
	private int mHourLastItem;  
	private int mHourCurrentItem;
	
	private int mMinuteLastItem;  
	private int mMinuteCurrentItem;
	
	public interface OnFutureRecentTimeView{
		void onTimeChanged(int dayValue,int hourValue,int minuteValue);
	}
	
	public FutureRecentTimeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext=context;
		initData();
		initView();
		initListener();
	}

	public OnFutureRecentTimeView getOnFutureRecentTimeView() {
		return mOnFutureRecentTimeView;
	}

	public void setOnFutureRecentTimeView(OnFutureRecentTimeView onFutureRecentTimeView) {
		mOnFutureRecentTimeView = onFutureRecentTimeView;
	}
	
	private void initData(){
		mDayStrings=mContext.getResources().getStringArray(R.array.day_relative_to_today);
		//mDayList=Arrays.asList(dayStrings);
		
		mHourStrings=mContext.getResources().getStringArray(R.array.hour);
		//mHourList=Arrays.asList(hourStrings);
		
		mMinuteStrings=mContext.getResources().getStringArray(R.array.minute);
		//mMinuteList=Arrays.asList(minuteStrings);
		
		return;
	}
	
	private void initView(){
//		LayoutInflater inflater = LayoutInflater.from(mContext);
		LayoutInflater inflater=(LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mFutureRecentTimeView = inflater.inflate(R.layout.future_recent_time_layout,this);
		
		mDayWheelView=(WheelView) mFutureRecentTimeView.findViewById(R.id.day_wheel_view);
		mDayWheelView.setVisibleItems(WHEEL_VIEW_VISIBLE_ITEMS);
		mDayWheelAdapter=new ArrayWheelAdapter<String>(mContext, mDayStrings);
		mDayWheelAdapter.setItemResource(R.layout.wheel_text_item);
		mDayWheelAdapter.setItemTextResource(R.id.text);
		mDayWheelView.setViewAdapter(mDayWheelAdapter);
	
		
		mHourWheelView=(WheelView) mFutureRecentTimeView.findViewById(R.id.hour_wheel_view);
		mHourWheelView.setVisibleItems(WHEEL_VIEW_VISIBLE_ITEMS);
		mHourWheelAdapter=new ArrayWheelAdapter<String>(mContext, mHourStrings);
		mHourWheelAdapter.setItemResource(R.layout.wheel_text_item);
		mHourWheelAdapter.setItemTextResource(R.id.text);
		mHourWheelView.setViewAdapter(mHourWheelAdapter);
		
		
		mMinuteWheelView=(WheelView) mFutureRecentTimeView.findViewById(R.id.minute_wheel_view);
		mMinuteWheelView.setVisibleItems(WHEEL_VIEW_VISIBLE_ITEMS);
		mMinuteWheelAdapter=new ArrayWheelAdapter<String>(mContext, mMinuteStrings);
		mMinuteWheelAdapter.setItemResource(R.layout.wheel_text_item);
		mMinuteWheelAdapter.setItemTextResource(R.id.text);
		mMinuteWheelView.setViewAdapter(mMinuteWheelAdapter);
		
		return;
	}
	
	private void initListener(){
		//mDayWheelView.seton
		mDayWheelView.addScrollingListener(dayWheelViewScrollListener);
		//mDayWheelView.addChangingListener(dayWheelViewChangedListener);
		mHourWheelView.addScrollingListener(hourWheelViewScrollListener);
		mMinuteWheelView.addScrollingListener(minuteWheelViewScrollListener);
		
		correctTheTime();
		return;
	}
	
/*	private OnWheelChangedListener dayWheelViewChangedListener=new OnWheelChangedListener() {
		
		@Override
		public void onChanged(WheelView wheel, int oldValue, int newValue) {
		
			Log.i(TAG, "oldValue["+oldValue+"]newValue["+newValue+"]");
			
		}
	};*/
	
	private OnWheelScrollListener dayWheelViewScrollListener=new OnWheelScrollListener() {
		
		@Override
		public void onScrollingStarted(WheelView wheel) {
			if(null==wheel){
				return;
			}
			//Log.i(TAG, "onScrollingStarted");
			mDayLastItem=wheel.getCurrentItem();
		}
		
		@Override
		public void onScrollingFinished(WheelView wheel) {
			if(null==wheel){
				return;
			}
			
			mDayCurrentItem=wheel.getCurrentItem();
			if(mDayCurrentItem==mDayLastItem){
				return;
			}
			
			correctTheTime();
			//Log.i(TAG, "onScrollingFinished mDayLastItem["+mDayLastItem+"]"+"mDayCurrentItem["+mDayCurrentItem+"]");
		}
	};
	
	private OnWheelScrollListener hourWheelViewScrollListener=new OnWheelScrollListener() {
		
		@Override
		public void onScrollingStarted(WheelView wheel) {
			if(null==wheel){
				return;
			}
			
			mHourLastItem=wheel.getCurrentItem();
		}
		
		@Override
		public void onScrollingFinished(WheelView wheel) {
			if(null==wheel){
				return;
			}
			mHourCurrentItem=wheel.getCurrentItem();
			if(mHourCurrentItem==mHourLastItem){
				return;
			}
			
			correctTheTime();
			//Log.i(TAG, "onScrollingFinished mHourLastItem["+mHourLastItem+"]"+"mHourCurrentItem["+mHourCurrentItem+"]");
			
		}
	};
	
	private OnWheelScrollListener minuteWheelViewScrollListener=new OnWheelScrollListener() {
		
		@Override
		public void onScrollingStarted(WheelView wheel) {
			if(null==wheel){
				return;
			}
			
			mMinuteLastItem=wheel.getCurrentItem();
			
		}
		
		@Override
		public void onScrollingFinished(WheelView wheel) {
			if(null==wheel){
				return;
			}
			mMinuteCurrentItem=wheel.getCurrentItem();
			if(mMinuteCurrentItem==mMinuteLastItem){
				return;
			}
			
			correctTheTime();
			//Log.i(TAG, "onScrollingFinished mMinuteLastItem["+mMinuteLastItem+"]"+"mMinuteCurrentItem["+mMinuteCurrentItem+"]");
		}
	};
	
	private void correctTheTime(){	
		int dayCurrentItem=mDayWheelView.getCurrentItem();	
		int hourCurrentItem=mHourWheelView.getCurrentItem();
		int minuteCurrentItem=mMinuteWheelView.getCurrentItem();
		
		int dayCorrectTheItem=dayCurrentItem;
		int hourCorrectTheItem=hourCurrentItem;
		int minuteCorrectTheItem=minuteCurrentItem;
		
		
		int hour_of_day=TimeUtil.getHourOfDay();
		int minute=TimeUtil.getMinute();
		Log.i(TAG, "hour_of_day["+hour_of_day+"]minute["+minute+"]");
		Log.i(TAG, "dayCurrentItem updateView before["+dayCurrentItem+"]hourCurrentItem["+hourCurrentItem+"]minuteCurrentItem["+minuteCurrentItem+"]");
		if(dayCurrentItem==0){
			Log.i(TAG,"hourCurrentItem["+hourCurrentItem );
			
			if(hour_of_day>=TimeUtil.hourPoint[hourCurrentItem]){
				if(hour_of_day>TimeUtil.hourPoint[hourCurrentItem]){
					int minuteCurrent = (minute+TimeUtil.MINUTE_MIN_APPOINTMENT_TIME);
					hourCorrectTheItem = (hour_of_day + minuteCurrent/TimeUtil.MINUTE_PER_HOUR);
					minuteCorrectTheItem = ((minuteCurrent%TimeUtil.MINUTE_PER_HOUR)/TimeUtil.MINUTE_INTERVAL);
				}else{
					if((minute+TimeUtil.MINUTE_MIN_APPOINTMENT_TIME)>=TimeUtil.minutePoint[minuteCurrentItem]){
						int minuteCurrent = (minute+TimeUtil.MINUTE_MIN_APPOINTMENT_TIME);
						hourCorrectTheItem = (hour_of_day + minuteCurrent/TimeUtil.MINUTE_PER_HOUR);
						minuteCorrectTheItem = ((minuteCurrent%TimeUtil.MINUTE_PER_HOUR)/TimeUtil.MINUTE_INTERVAL);
					}
				}
			
				updateView(dayCorrectTheItem, hourCorrectTheItem, minuteCorrectTheItem);
			}
		}
		
		if(null!=mOnFutureRecentTimeView){
			int dayValue=TimeUtil.dayPoint[mDayWheelView.getCurrentItem()];
			int hourValue=TimeUtil.hourPoint[mHourWheelView.getCurrentItem()];
			int minuteValue=TimeUtil.minutePoint[mMinuteWheelView.getCurrentItem()];
			Log.i(TAG, "dayValue["+dayValue+"]hourValue["+hourValue+"]minuteValue["+minuteValue+"]");
			mOnFutureRecentTimeView.onTimeChanged(dayValue, hourValue, minuteValue);
		}
	}
	
	private void updateView(int dayIndex, int hourIndex, int minuteIndex){
		Log.i(TAG, "updateView...["+dayIndex+"]["+hourIndex+"]["+minuteIndex+"]");
		mDayWheelView.setCurrentItem(dayIndex);
		mHourWheelView.setCurrentItem(hourIndex);
		mMinuteWheelView.setCurrentItem(minuteIndex);
		Log.i(TAG, "updateView===["+mDayWheelView.getCurrentItem()+"]["+mHourWheelView.getCurrentItem()+"]["+mMinuteWheelView.getCurrentItem()+"]");
	}
	
	
}
