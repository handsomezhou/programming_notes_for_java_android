package com.handsomezhou.futurerecenttimeselect.util;

//import android.util.Log;

import com.handsomezhou.futurerecenttimeselect.model.TimeItemIndex;
import com.handsomezhou.futurerecenttimeselect.model.TimeItemValue;

public class TimeItemUtil {
	public static final String TAG="TimeItemUtil";
	public static final int[] dayPoint={0,1,2};
	public static final int[] hourPoint={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
	public static final int[] minutePoint={0,10,20,30,40,50};
	public static final int MINUTE_MIN_APPOINTMENT_TIME=10;
	
	public static TimeItemIndex correctTheTimeItem(TimeItemIndex currentItemIndex){
		TimeItemValue timeItemValue=null;
		TimeItemValue correctTimeItemValue=null;
		TimeItemIndex correctTimeItemIndex=null;
		do{
			if(null==currentItemIndex){
				break;
			}
			//Log.i(TAG, "TimeItemIndexToValue index:"+currentItemIndex.getDayItemIndex()+";"+currentItemIndex.getHourItemIndex()+";"+currentItemIndex.getMinuteItemIndex());
			timeItemValue=TimeItemUtil.TimeItemIndexToValue(currentItemIndex);
			//Log.i(TAG, "TimeItemIndexToValue value:"+timeItemValue.getDayItemValue()+";"+timeItemValue.getHourItemValue()+";"+timeItemValue.getMinuteItemValue());
			if(null==timeItemValue){
				break;
			}
			
			correctTimeItemValue=TimeItemUtil.correctTheTimeItem(timeItemValue);
			//Log.i(TAG, "correctTimeItemValue value:"+correctTimeItemValue.getDayItemValue()+";"+correctTimeItemValue.getHourItemValue()+";"+correctTimeItemValue.getMinuteItemValue());
			if(null==correctTimeItemValue){
				break;
			}
			
			correctTimeItemIndex=TimeItemUtil.TimeItemValueToIndex(correctTimeItemValue);
			break;
			
		}while(false);
				
		return correctTimeItemIndex;
	}
	
	public static long getTimeInMillis(TimeItemValue timeItemValue){
		long time=0;
		
		do{
			if(null==timeItemValue){
				break;
			}
			int milliSecondOfDay=TimeUtil.getMilliSecondOfDay();
			long currentTimeMillis=System.currentTimeMillis();
			
			time=(currentTimeMillis-milliSecondOfDay)+((timeItemValue.getDayItemValue()*TimeUtil.HOUR_PER_DAY*TimeUtil.MINUTE_PER_HOUR)+(timeItemValue.getHourItemValue()*TimeUtil.MINUTE_PER_HOUR)+timeItemValue.getMinuteItemValue())*(TimeUtil.SECOND_PER_MINUTE)*(TimeUtil.MILLISECOND_PER_SECOND);
		}while(false);
		
		return time;
	}
	
	private static TimeItemValue correctTheTimeItem(TimeItemValue timeItemValue){
		TimeItemValue correctTimeItemValue=timeItemValue;
		do{
			if(null==timeItemValue){
				//correctTimeItemValue=timeItemValue;
				break;
			}
			
			if(timeItemValue.getDayItemValue()!=dayPoint[0]){
				//correctTimeItemValue=timeItemValue;
				break;
			}
			//Log.i(TAG,"timeItemValue:"+timeItemValue.getDayItemValue()+";"+timeItemValue.getHourItemValue()+";"+timeItemValue.getMinuteItemValue());
			int minuteOfday=TimeUtil.getMinuteOfDay();
			int systemMinuteOfDay=(minuteOfday/MINUTE_MIN_APPOINTMENT_TIME+1)*(MINUTE_MIN_APPOINTMENT_TIME)+TimeItemUtil.MINUTE_MIN_APPOINTMENT_TIME;
			//Log.i(TAG, "systemMinuteOfDay["+systemMinuteOfDay+"]");
			int userMinuteOfDay=getMinuteOfDay(timeItemValue);
			//Log.i(TAG, "userMinuteOfDay["+userMinuteOfDay+"]");

			
			if(userMinuteOfDay>=systemMinuteOfDay){
				//correctTimeItemValue=timeItemValue;
				break;
			}
			
			correctTimeItemValue=getTimeItemValue(systemMinuteOfDay);
			//Log.i(TAG,"correctTimeItemValue:"+correctTimeItemValue.getDayItemValue()+";"+correctTimeItemValue.getHourItemValue()+";"+correctTimeItemValue.getMinuteItemValue());
			
			break;
		}while(false);
		
		return correctTimeItemValue;
	}
	
	private static int getMinuteOfDay(TimeItemValue timeItemValue){
		int minuteOfDay=timeItemValue.getHourItemValue()*(TimeUtil.MINUTE_PER_HOUR)+timeItemValue.getMinuteItemValue();
		
		return minuteOfDay;
	}
	
	private static TimeItemValue getTimeItemValue(int minuteOfDay){
		TimeItemValue timeItemValue=new TimeItemValue();
		timeItemValue.setDayItemValue(minuteOfDay/(TimeUtil.HOUR_PER_DAY*TimeUtil.MINUTE_PER_HOUR));
		timeItemValue.setHourItemValue(minuteOfDay/TimeUtil.MINUTE_PER_HOUR%TimeUtil.HOUR_PER_DAY);
		timeItemValue.setMinuteItemValue(minuteOfDay%TimeUtil.MINUTE_PER_HOUR);
		return timeItemValue;
	}
	
	private static TimeItemValue TimeItemIndexToValue(TimeItemIndex timeItemIndex){
		TimeItemValue timeItemValue=null;
		do{
			if(null==timeItemIndex){
				break;
			}
			
			timeItemValue=new TimeItemValue();
			if((timeItemIndex.getDayItemIndex()>=0)&&(timeItemIndex.getDayItemIndex()<dayPoint.length)){
				timeItemValue.setDayItemValue(dayPoint[timeItemIndex.getDayItemIndex()]);
			}else{
				timeItemValue.setDayItemValue(TimeItemValue.DAY_ITEM_VALUE_DEFAULT);
			}
			
			if((timeItemIndex.getHourItemIndex()>=0)&&(timeItemIndex.getHourItemIndex()<hourPoint.length)){
				timeItemValue.setHourItemValue(hourPoint[timeItemIndex.getHourItemIndex()]);
			}else{
				timeItemValue.setHourItemValue(TimeItemValue.HOUR_ITEM_VALUE_DEFAULT);
			}
			
			if((timeItemIndex.getMinuteItemIndex()>=0)&&(timeItemIndex.getMinuteItemIndex()<minutePoint.length)){
				timeItemValue.setMinuteItemValue(minutePoint[timeItemIndex.getMinuteItemIndex()]);
			}else{
				timeItemValue.setMinuteItemValue(TimeItemValue.MINUTE_ITEM_VALUE_DEFAULT);
			}
			
			break;
		}while(false);
		
		
		return timeItemValue;
	}
	
	private static TimeItemIndex TimeItemValueToIndex(TimeItemValue timeItemValue){
		TimeItemIndex timeItemIndex=null;
		
		do{
			if(null==timeItemValue){
				break;
			}
		
			timeItemIndex=new TimeItemIndex();
			int dayItemIndex=getTimeItemIndex(timeItemValue.getDayItemValue(), dayPoint);
			timeItemIndex.setDayItemIndex(dayItemIndex);
			
			int hourItemIndex=getTimeItemIndex(timeItemValue.getHourItemValue(), hourPoint);
			timeItemIndex.setHourItemIndex(hourItemIndex);
			
			//Log.i(TAG, "getTimeItemIndex:"+timeItemValue.getMinuteItemValue());
			int minuteItemIndex=getTimeItemIndex(timeItemValue.getMinuteItemValue(), minutePoint);
			//Log.i(TAG, "minuteItemIndex:"+minuteItemIndex);
			timeItemIndex.setMinuteItemIndex(minuteItemIndex);
			
			break;
		}while(false);
		
		return timeItemIndex;
	}
	
	private static int getTimeItemIndex(int timeItemValue,final int[] timePoint){
		int itemItemIndex=0;
		for(int i=0; i<timePoint.length; i++){
			if(timeItemValue<=timePoint[i]){
				itemItemIndex=i;
				break;
			}
		}
		return itemItemIndex;
	}
	
}
