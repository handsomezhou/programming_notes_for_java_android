package com.handsomezhou.futurerecenttimeselect.view;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kankan.wheel.widget.OnWheelClickedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.handsomezhou.futurerecenttimeselect.model.TimeItemIndex;
import com.handsomezhou.futurerecenttimeselect.util.TimeItemUtil;
import com.handsomezhou.futurerecenttimeselect.util.TimeUtil;
import com.handsomezhou.futurerecenttimeselect.util.ViewUtil;
import com.handsomezhou.futurerecenttimeselectview.R;

public class FutureRecentTimeView extends LinearLayout{
	public static final String TAG="FutureRecentTimeView";
	public static final int WHEEL_VIEW_VISIBLE_ITEMS=7;
	private Context mContext;
	private OnFutureRecentTimeView mOnFutureRecentTimeView;
	private View mFutureRecentTimeView;
	private int mDayOfYear=0;
//	private String[] mDayStrings;
	private List<String> mDayList;
	private List<String> mHourList;
	private List<String> mMinuteList;
	
	private ArrayWheelAdapter<String> mDayWheelAdapter;
	private ArrayWheelAdapter<String> mHourWheelAdapter;
	private ArrayWheelAdapter<String> mMinuteWheelAdapter;
	
	private WheelView mDayWheelView;
	private WheelView mHourWheelView;
	private WheelView mMinuteWheelView;
	
	private TimeItemIndex mLastTimeItem;
	private TimeItemIndex mCurrentItem;
	
	public interface OnFutureRecentTimeView{
		void onTimeChanged(TimeItemIndex timeItemIndex);
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
	
	public int getDayItemIndex(){
		int dayItemIndex=mDayWheelView.getCurrentItem();
		
		return dayItemIndex;
	}
	
	public int getHouItemIndex(){
		int hourItemIndex=mHourWheelView.getCurrentItem();
		
		return hourItemIndex;
	}
	
	public int getMinuteItemIndex(){
		int minuteItemIndex=mMinuteWheelView.getCurrentItem();
		
		return minuteItemIndex;
	}
	
	private void initData(){
		initDayList();
		initHourList();
		initMinuteList();
		
		mLastTimeItem=new TimeItemIndex();
		mCurrentItem=new TimeItemIndex();
		return;
	}
	
	@SuppressLint("SimpleDateFormat")
	private void initDayList(){
		mDayOfYear=TimeUtil.getDayOfYear();
		
		if(null==mDayList){
			mDayList=new ArrayList<String>();
		}
		mDayList.clear();
		mDayList.add(mContext.getString(R.string.now));
		mDayList.add(mContext.getString(R.string.today));
		long currentTimeMillis=System.currentTimeMillis();
		
		String dateFromat=mContext.getString(R.string.date_fromat);
		SimpleDateFormat df = new SimpleDateFormat(dateFromat);
		long oneDayTimeMillis=TimeUtil.HOUR_PER_DAY*TimeUtil.MINUTE_PER_HOUR*TimeUtil.SECOND_PER_MINUTE*TimeUtil.MILLISECOND_PER_SECOND;
		for(int i=0; i<TimeItemUtil.DAY_WHEEL_VIEW_ITEMS-2; i++){
			mDayList.add(df.format(new Date(currentTimeMillis+oneDayTimeMillis*(i+1))));
		}
	}
	
	private void initHourList(){
		if(null==mHourList){
			mHourList=new ArrayList<String>();
		}
		mHourList.clear();
		String hourSuffix=mContext.getString(R.string.hour_suffix);
		for(int i=0; i<TimeItemUtil.HOUR_WHEEL_VIEW_ITEMS; i++){
			int currentItemValue=TimeItemUtil.HOUR_START_VALUE+(i*TimeItemUtil.HOUR_INTERVAL);
			mHourList.add(currentItemValue+hourSuffix);
		}
		
		return;
	}
	
	private void initMinuteList(){
		if(null==mMinuteList){
			mMinuteList=new ArrayList<String>();
		}
		mMinuteList.clear();
		String minuteSuffix=mContext.getString(R.string.minute_suffix);
		for(int i=0; i<TimeItemUtil.MINUTE_WHEEL_VIEW_ITEMS; i++){
			int currentItemValue=TimeItemUtil.MINUTE_START_VALUE+(i*TimeItemUtil.MINUTE_INTERVAL);
			mMinuteList.add(currentItemValue+minuteSuffix);
		}
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
		
		mDayWheelAdapter=new ArrayWheelAdapter<String>(mContext,  (String[])mDayList.toArray(new String[mDayList.size()]));
		mDayWheelAdapter.setItemResource(R.layout.wheel_text_item);
		mDayWheelAdapter.setItemTextResource(R.id.text);
		mDayWheelView.setViewAdapter(mDayWheelAdapter);
		mDayWheelView.setCurrentItem(mCurrentItem.getDayItemIndex());//init today index
	
		
		mHourWheelView=(WheelView) mFutureRecentTimeView.findViewById(R.id.hour_wheel_view);
		mHourWheelView.setVisibleItems(WHEEL_VIEW_VISIBLE_ITEMS);
		mHourWheelAdapter=new ArrayWheelAdapter<String>(mContext,  (String[])mHourList.toArray(new String[mHourList.size()]));
		mHourWheelAdapter.setItemResource(R.layout.wheel_text_item);
		mHourWheelAdapter.setItemTextResource(R.id.text);
		mHourWheelView.setViewAdapter(mHourWheelAdapter);
		
		
		mMinuteWheelView=(WheelView) mFutureRecentTimeView.findViewById(R.id.minute_wheel_view);
		mMinuteWheelView.setVisibleItems(WHEEL_VIEW_VISIBLE_ITEMS);
		mMinuteWheelAdapter=new ArrayWheelAdapter<String>(mContext,  (String[])mMinuteList.toArray(new String[mMinuteList.size()]));
		mMinuteWheelAdapter.setItemResource(R.layout.wheel_text_item);
		mMinuteWheelAdapter.setItemTextResource(R.id.text);
		mMinuteWheelView.setViewAdapter(mMinuteWheelAdapter);
		
		return;
	}
	
	private void initListener(){
		//mDayWheelView.seton
		mDayWheelView.addScrollingListener(dayWheelViewScrollListener);
		mDayWheelView.addClickingListener(dayWheelClickedListener);

		//mDayWheelView.addChangingListener(dayWheelViewChangedListener);
		mHourWheelView.addScrollingListener(hourWheelViewScrollListener);
		mHourWheelView.addClickingListener(hourWheelClickedListener);
		
		mMinuteWheelView.addScrollingListener(minuteWheelViewScrollListener);
		mMinuteWheelView.addClickingListener(minuteWheelClickedListener);

		
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
			//Log.i(TAG, "TimeUtil.getDayOfYear() "+TimeUtil.getDayOfYear()+";"+mDayOfYear+" mDayOfYear");
			if(TimeUtil.getDayOfYear()!=mDayOfYear){//refresh day data
				initDayList();
				mDayWheelAdapter.set((String[])mDayList.toArray(new String[mDayList.size()]));
			}
			
			mCurrentItem.setDayItemIndex(wheel.getCurrentItem());
			refreshNowWheelView();
			if(mCurrentItem.getDayItemIndex()==mLastTimeItem.getDayItemIndex()){
				return;
			}
			
			correctTheTime();
			//Log.i(TAG, "onScrollingFinished mDayLastItem["+mDayLastItem+"]"+"mDayCurrentItem["+mDayCurrentItem+"]");
		}
	};
	
	private OnWheelClickedListener dayWheelClickedListener=new OnWheelClickedListener() {
		
		@Override
		public void onItemClicked(WheelView wheel, int itemIndex) {
			if(null==wheel){
				return;
			}
			Log.i(TAG, "wheel.getCurrentItem() "+wheel.getCurrentItem()+"  itemIndex "+itemIndex);
			mLastTimeItem.setDayItemIndex(mDayWheelView.getCurrentItem());
			mDayWheelView.setCurrentItem(itemIndex);
			mCurrentItem.setDayItemIndex(itemIndex);
			refreshNowWheelView();
			if(mCurrentItem.getDayItemIndex()==mLastTimeItem.getDayItemIndex()){
				return;
			}
			
			correctTheTime();
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
	
	private OnWheelClickedListener hourWheelClickedListener=new OnWheelClickedListener() {
		
		@Override
		public void onItemClicked(WheelView wheel, int itemIndex) {
			if(null==wheel){
				return;
			}
			Log.i(TAG, "wheel.getCurrentItem() "+wheel.getCurrentItem()+"  itemIndex "+itemIndex);
			mLastTimeItem.setHourItemIndex(mHourWheelView.getCurrentItem());
			mHourWheelView.setCurrentItem(itemIndex);
			mCurrentItem.setHourItemIndex(itemIndex);
			if(mCurrentItem.getHourItemIndex()==mLastTimeItem.getHourItemIndex()){
				return;
			}
			
			correctTheTime();
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
	
	private OnWheelClickedListener minuteWheelClickedListener=new OnWheelClickedListener() {
		
		@Override
		public void onItemClicked(WheelView wheel, int itemIndex) {
			if(null==wheel){
				return;
			}
			Log.i(TAG, "wheel.getCurrentItem() "+wheel.getCurrentItem()+"  itemIndex "+itemIndex);
			mLastTimeItem.setMinuteItemIndex(wheel.getCurrentItem());
			mMinuteWheelView.setCurrentItem(itemIndex);
			mCurrentItem.setMinuteItemIndex(itemIndex);
			if(mCurrentItem.getMinuteItemIndex()==mLastTimeItem.getMinuteItemIndex()){
				return;
			}
			
			correctTheTime();
		}
	};
	private void correctTheTime() {
		TimeItemIndex currentItem = null;

		currentItem = new TimeItemIndex();
		currentItem.setDayItemIndex(mDayWheelView.getCurrentItem());
		currentItem.setHourItemIndex(mHourWheelView.getCurrentItem());
		currentItem.setMinuteItemIndex(mMinuteWheelView.getCurrentItem());
		
		//Log.i(TAG,currentItem.getDayItemIndex()+";"+currentItem.getHourItemIndex()+";" +currentItem.getMinuteItemIndex());
		TimeItemIndex correctItem=TimeItemUtil.correctTheTimeItem(currentItem);
		
		//Log.i(TAG,correctItem.getDayItemIndex()+";"+correctItem.getHourItemIndex()+";" +correctItem.getMinuteItemIndex());
		if(null!=correctItem){
			refreshWheelView(correctItem);
		}
	}
	
	private void refreshNowWheelView(){
		if(mCurrentItem.getDayItemIndex()==0){//now
			ViewUtil.hideView(mHourWheelView);
			ViewUtil.hideView(mMinuteWheelView);
			
		}else{//not now
			ViewUtil.showView(mHourWheelView);
			ViewUtil.showView(mMinuteWheelView);
		}
		
		return;
	}
	
	private void refreshWheelView(TimeItemIndex timeItem){
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
