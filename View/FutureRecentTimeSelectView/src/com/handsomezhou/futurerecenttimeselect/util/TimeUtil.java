package com.handsomezhou.futurerecenttimeselect.util;

import java.util.Calendar;

public class TimeUtil {
	public static final int[] dayPoint={0,1,2};
	public static final int[] hourPoint={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
	public static final int[] minutePoint={0,10,20,30,40,50};
	
	public static final int HOUR_PER_DAY = 24; // 1day=24h
	public static final int MINUTE_PER_HOUR = 60; // 1h=60min
	
	public static final int DAY_MIN_SET = 0;
	public static final int DAY_MAX_SET = 2;
	public static final int DAY_INTERVAL=1;

	public static final int HOUR_MIN_SET = 0;
	public static final int HOUR_MAX_SET = 23;
	public static final int HOUR_INTERVAL=1;
	
	public static final int MINUTE_MIN_SET=0;
	public static final int MINUTE_MAX_SET=50;
	public static final int MINUTE_INTERVAL=10;
	
	public static final int MINUTE_MIN_APPOINTMENT_TIME=20;
	
	public static int getHourOfDay(){
		Calendar calendar = Calendar.getInstance();
		int hour_of_day=calendar.get(Calendar.HOUR_OF_DAY);
		
		return hour_of_day;
	}
	
	public static int getMinute(){
		Calendar calendar = Calendar.getInstance();
		
		int minute=calendar.get(Calendar.MINUTE);
		
		return minute;
	}
	

}
