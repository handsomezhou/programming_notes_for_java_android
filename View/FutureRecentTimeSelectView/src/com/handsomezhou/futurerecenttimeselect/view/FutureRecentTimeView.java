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

import com.handsomezhou.futurerecenttimeselect.model.TimeItemIndex;
import com.handsomezhou.futurerecenttimeselect.util.TimeItemUtil;
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
	
	private TimeItemIndex mLastTimeItem;
	private TimeItemIndex mCurrentItem;
	
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
	
	public int getDayValue(){
		int dayValue=TimeItemUtil.dayPoint[mDayWheelView.getCurrentItem()];
		
		return dayValue;
	}
	
	public int getHourValue(){
		int hourValue=TimeItemUtil.hourPoint[mHourWheelView.getCurrentItem()];
		
		return hourValue;
	}
	
	public int getMinuteValue(){
		int minuteValue=TimeItemUtil.minutePoint[mMinuteWheelView.getCurrentItem()];
		
		return minuteValue;
	}
	
	private void initData(){
		mDayStrings=mContext.getResources().getStringArray(R.array.day_relative_to_today);
		//mDayList=Arrays.asList(dayStrings);
		
		mHourStrings=mContext.getResources().getStringArray(R.array.hour);
		//mHourList=Arrays.asList(hourStrings);
		
		mMinuteStrings=mContext.getResources().getStringArray(R.array.minute);
		//mMinuteList=Arrays.asList(minuteStrings);
		
		mLastTimeItem=new TimeItemIndex();
		mCurrentItem=new TimeItemIndex();
		return;
	}
	
	public void updateView(){
		correctTheTime();
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
			mLastTimeItem.setDayItemIndex(wheel.getCurrentItem());
		}
		
		@Override
		public void onScrollingFinished(WheelView wheel) {
			if(null==wheel){
				return;
			}
			
			mCurrentItem.setDayItemIndex(wheel.getCurrentItem());
			if(mCurrentItem.getDayItemIndex()==mLastTimeItem.getDayItemIndex()){
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
			
			mLastTimeItem.setHourItemIndex(wheel.getCurrentItem());
		}
		
		@Override
		public void onScrollingFinished(WheelView wheel) {
			if(null==wheel){
				return;
			}
		
			mCurrentItem.setHourItemIndex(wheel.getCurrentItem());
			if(mCurrentItem.getHourItemIndex()==mLastTimeItem.getHourItemIndex()){
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
			
			mLastTimeItem.setMinuteItemIndex(wheel.getCurrentItem());
			
		}
		
		@Override
		public void onScrollingFinished(WheelView wheel) {
			if(null==wheel){
				return;
			}
			mCurrentItem.setMinuteItemIndex(wheel.getCurrentItem());
			if(mCurrentItem.getMinuteItemIndex()==mLastTimeItem.getMinuteItemIndex()){
				return;
			}
			
			correctTheTime();
			//Log.i(TAG, "onScrollingFinished mMinuteLastItem["+mMinuteLastItem+"]"+"mMinuteCurrentItem["+mMinuteCurrentItem+"]");
		}
	};
	
	private void correctTheTime() {
		TimeItemIndex currentItem = null;

		currentItem = new TimeItemIndex();
		currentItem.setDayItemIndex(mDayWheelView.getCurrentItem());
		currentItem.setHourItemIndex(mHourWheelView.getCurrentItem());
		currentItem.setMinuteItemIndex(mMinuteWheelView.getCurrentItem());
		
		Log.i(TAG,currentItem.getDayItemIndex()+";"+currentItem.getHourItemIndex()+";" +currentItem.getMinuteItemIndex());
		TimeItemIndex correctItem=TimeItemUtil.correctTheTimeItem(currentItem);
		
		Log.i(TAG,correctItem.getDayItemIndex()+";"+correctItem.getHourItemIndex()+";" +correctItem.getMinuteItemIndex());
		if(null!=correctItem){
			updateView(correctItem);
		}
	}
	
	private void updateView(TimeItemIndex timeItem){
		if(null==timeItem){
			return;
		}
		
		//Log.i(TAG, "updateView...["+timeItem.getDayItemIndex()+"]["+timeItem.getHourItemIndex()+"]["+timeItem.getMinuteItemIndex()+"]");
		mDayWheelView.setCurrentItem(timeItem.getDayItemIndex());
		mHourWheelView.setCurrentItem(timeItem.getHourItemIndex());
		mMinuteWheelView.setCurrentItem(timeItem.getMinuteItemIndex());
		//Log.i(TAG, "updateView===["+mDayWheelView.getCurrentItem()+"]["+mHourWheelView.getCurrentItem()+"]["+mMinuteWheelView.getCurrentItem()+"]");
	}
	
	
}
