package com.handsomezhou.futurerecenttimeselect.model;

public class TimeItemValue implements Cloneable{
	public static final int DAY_ITEM_VALUE_DEFAULT=0;
	public static final int HOUR_ITEM_VALUE_DEFAULT=0;
	public static final int MINUTE_ITEM_VALUE_DEFAULT=0;
	private int mDayItemValue;//the value of the day in the time select view{0,1,2}
	private int mHourItemValue;////the value of the hour in the time select view[0~24)
	private int mMinuteItemValue;////the value of the hour in the time select view{0,10,20,30,40,50}
	
	public TimeItemValue() {
		super();
		setDayItemValue(DAY_ITEM_VALUE_DEFAULT);
		setHourItemValue(HOUR_ITEM_VALUE_DEFAULT);
		setMinuteItemValue(MINUTE_ITEM_VALUE_DEFAULT);
	}

	public TimeItemValue(int dayItemValue, int hourItemValue, int minuteItemValue) {
		super();
		setDayItemValue(dayItemValue);
		setHourItemValue(hourItemValue);
		setMinuteItemValue(minuteItemValue);
	}

	public int getDayItemValue() {
		return mDayItemValue;
	}
	
	public void setDayItemValue(int dayItemValue) {
		mDayItemValue = dayItemValue;
	}
	
	public int getHourItemValue() {
		return mHourItemValue;
	}
	
	public void setHourItemValue(int hourItemValue) {
		mHourItemValue = hourItemValue;
	}
	
	public int getMinuteItemValue() {
		return mMinuteItemValue;
	}
	
	public void setMinuteItemValue(int minuteItemValue) {
		mMinuteItemValue = minuteItemValue;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
}
