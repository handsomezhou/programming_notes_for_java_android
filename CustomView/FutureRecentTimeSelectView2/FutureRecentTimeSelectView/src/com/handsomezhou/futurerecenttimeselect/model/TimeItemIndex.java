package com.handsomezhou.futurerecenttimeselect.model;

public class TimeItemIndex implements Cloneable{
	public static final int DAY_ITEM_INDEX_DEFAULT=1;
	public static final int HOUR_ITEM_INDEX_DEFAULT=0;
	public static final int MINUTE_ITEM_INDEX_DEFAULT=0;
	
	private int mDayItemIndex;//the index range of the day in the time select view[0~3)
	private int mHourItemIndex;////the index range of the hour in the time select view[0~24)
	private int mMinuteItemIndex;////the index range of the hour in the time select view[0~6)
	
	public TimeItemIndex() {
		super();
		setDayItemIndex(DAY_ITEM_INDEX_DEFAULT);
		setHourItemIndex(HOUR_ITEM_INDEX_DEFAULT);
		setMinuteItemIndex(MINUTE_ITEM_INDEX_DEFAULT);
	}
	
	public TimeItemIndex(int dayItemIndex, int hourItemIndex, int minuteItemIndex) {
		super();
		setDayItemIndex(dayItemIndex);
		setHourItemIndex(hourItemIndex);
		setMinuteItemIndex(minuteItemIndex);
	}

	

	public int getDayItemIndex() {
		return mDayItemIndex;
	}

	public void setDayItemIndex(int dayItemIndex) {
		mDayItemIndex = dayItemIndex;
	}

	public int getHourItemIndex() {
		return mHourItemIndex;
	}

	public void setHourItemIndex(int hourItemIndex) {
		mHourItemIndex = hourItemIndex;
	}

	public int getMinuteItemIndex() {
		return mMinuteItemIndex;
	}

	public void setMinuteItemIndex(int minuteItemIndex) {
		mMinuteItemIndex = minuteItemIndex;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
}
