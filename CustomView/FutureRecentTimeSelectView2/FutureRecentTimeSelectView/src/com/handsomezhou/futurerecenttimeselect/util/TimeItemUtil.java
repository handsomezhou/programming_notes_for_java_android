package com.handsomezhou.futurerecenttimeselect.util;

//import android.util.Log;

import android.util.Log;

import com.handsomezhou.futurerecenttimeselect.model.TimeItemIndex;

public class TimeItemUtil {
	public static final String TAG="TimeItemUtil";
	public static final int MINUTE_MIN_APPOINTMENT_TIME = 0;//0 minute

	public static final int DAY_START_VALUE=0; //the today value
	public static final int DAY_INTERVAL=1; //1day
	public static final int DAY_WHEEL_VIEW_ITEMS=60;
	private static final int TODAY_WHEEL_VIEW_INDEX=1;// index in day wheel view

	
	public static final int HOUR_START_VALUE=0; //the first value of hour
	public static final int HOUR_INTERVAL=1; //1hour
	public static final int HOUR_WHEEL_VIEW_ITEMS=24;
	
	public static final int MINUTE_START_VALUE=0;//the first value of minute
	public static final int MINUTE_INTERVAL=1;//1 minute
	public static final int MINUTE_WHEEL_VIEW_ITEMS=60;

	
	public static TimeItemIndex correctTheTimeItem(TimeItemIndex currentItemIndex){
		
		TimeItemIndex correctTimeItemIndex=null;
		do{
			if(null==currentItemIndex){
				break;
			}
			
			if(currentItemIndex.getDayItemIndex()!=TODAY_WHEEL_VIEW_INDEX){
				break;
			}
			
			//Log.i(TAG,"timeItemValue:"+timeItemValue.getDayItemValue()+";"+timeItemValue.getHourItemValue()+";"+timeItemValue.getMinuteItemValue());
			int minuteOfday=TimeUtil.getMinuteOfDay();
			int systemMinuteOfDay=(minuteOfday/TimeItemUtil.MINUTE_INTERVAL+1)*(TimeItemUtil.MINUTE_INTERVAL)+TimeItemUtil.MINUTE_MIN_APPOINTMENT_TIME;
			Log.i(TAG, "systemMinuteOfDay["+systemMinuteOfDay+"]");
			int userMinuteOfDay=getMinuteOfDay(currentItemIndex);
			Log.i(TAG, "userMinuteOfDay["+userMinuteOfDay+"]");

			
			if(userMinuteOfDay>=systemMinuteOfDay){
				//correctTimeItemValue=timeItemValue;
				break;
			}
			correctTimeItemIndex=getTimeItemIndex(systemMinuteOfDay);
			
		}while(false);
				
		return correctTimeItemIndex;
	}
	
	public static long getTimeMillis(final TimeItemIndex timeItemIndex) {
        long millis = System.currentTimeMillis();
        do {
            if (timeItemIndex.getDayItemIndex() == 0) {// now
                break;
            }
            //note:It's necessary that System.currentTimeMillis behind TimeUtil.getMilliSecondOfDay().
            long todayStartTimeMillis=(-(long)TimeUtil.getMilliSecondOfDay()+System.currentTimeMillis());
            
            int daysRelativeTodayStartTime=(timeItemIndex.getDayItemIndex()- TimeItemUtil.TODAY_WHEEL_VIEW_INDEX)*TimeItemUtil.DAY_INTERVAL;
            long daysRelativeTodayStartTimeMillis=((long)daysRelativeTodayStartTime)*TimeUtil.HOUR_PER_DAY*TimeUtil.MINUTE_PER_HOUR*TimeUtil.SECOND_PER_MINUTE*TimeUtil.MILLISECOND_PER_SECOND;
    
            int hoursRelativeTodayStartTime=(timeItemIndex.getHourItemIndex()-0)*TimeItemUtil.HOUR_INTERVAL;
            long hoursRelativeTodayStartTimeMillis=((long)hoursRelativeTodayStartTime)*TimeUtil.MINUTE_PER_HOUR*TimeUtil.SECOND_PER_MINUTE*TimeUtil.MILLISECOND_PER_SECOND;
      
            int minutesRelativeTodayStartTime=(timeItemIndex.getMinuteItemIndex()-0)*TimeItemUtil.MINUTE_INTERVAL;
            long minutesRelativeTodayStartTimeMillis=((long)minutesRelativeTodayStartTime)*TimeUtil.SECOND_PER_MINUTE*TimeUtil.MILLISECOND_PER_SECOND;
            
            millis=todayStartTimeMillis+daysRelativeTodayStartTimeMillis+hoursRelativeTodayStartTimeMillis+minutesRelativeTodayStartTimeMillis;
         /*   Log.i(TAG, "todayStartTimeMillis "+todayStartTimeMillis);
            Log.i(TAG, "daysRelativeTodayStartTime "+daysRelativeTodayStartTime);
            Log.i(TAG, "daysRelativeTodayStartTimeMillis "+daysRelativeTodayStartTimeMillis);
            Log.i(TAG, "hoursRelativeTodayStartTime "+hoursRelativeTodayStartTime);
            Log.i(TAG, "hoursRelativeTodayStartTimeMillis "+hoursRelativeTodayStartTimeMillis);
            Log.i(TAG, "minutesRelativeTodayStartTime "+minutesRelativeTodayStartTime);
            Log.i(TAG, "minutesRelativeTodayStartTimeMillis "+minutesRelativeTodayStartTimeMillis);
            Log.i(TAG, "millis "+millis);
          */            
            break;

        } while (false);
        return millis;

    }
	
	private static int getMinuteOfDay(final TimeItemIndex timeItemIndex){
		
		int minuteOfDay=((TimeItemUtil.HOUR_START_VALUE+timeItemIndex.getHourItemIndex()*TimeItemUtil.HOUR_INTERVAL)*(TimeUtil.MINUTE_PER_HOUR))+
				(TimeItemUtil.MINUTE_START_VALUE+timeItemIndex.getMinuteItemIndex()*TimeItemUtil.MINUTE_INTERVAL);
		
		return minuteOfDay;
	}
	
	private static TimeItemIndex getTimeItemIndex(int minuteOfDay){
		TimeItemIndex timeItemIndex=new TimeItemIndex();
		timeItemIndex.setDayItemIndex(minuteOfDay/(TimeUtil.HOUR_PER_DAY*TimeUtil.MINUTE_PER_HOUR)/TimeItemUtil.DAY_INTERVAL+TODAY_WHEEL_VIEW_INDEX);
		timeItemIndex.setHourItemIndex(minuteOfDay/TimeUtil.MINUTE_PER_HOUR%TimeUtil.HOUR_PER_DAY/TimeItemUtil.HOUR_INTERVAL);
		timeItemIndex.setMinuteItemIndex(minuteOfDay%TimeUtil.MINUTE_PER_HOUR/TimeItemUtil.MINUTE_INTERVAL);
		return timeItemIndex;
	}
	
	
}
