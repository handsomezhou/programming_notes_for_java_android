package com.handsomezhou.futurerecenttimeselect.util;

import java.util.Calendar;

public class TimeUtil {
	public static final int HOUR_PER_DAY = 24; // 1day=24h
	public static final int MINUTE_PER_HOUR = 60; // 1h=60min
	
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

	public static int getMinuteOfDay(){
		int minuteOfDay=(TimeUtil.getHourOfDay()*MINUTE_PER_HOUR)+TimeUtil.getMinute();
		
		return minuteOfDay;
	}
}
