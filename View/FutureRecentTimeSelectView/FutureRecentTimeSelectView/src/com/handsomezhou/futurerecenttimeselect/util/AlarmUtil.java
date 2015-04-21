package com.handsomezhou.futurerecenttimeselect.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;

/**
 * alarm util
 * @author handsomezhou
 */
public class AlarmUtil {
	/**
	 * @see AlarmManager#set(int, long, PendingIntent)
	 * 
	 * @param context
	 * @param type
	 * @param triggerAtMillis
	 * @param operation
	 */
	public static void set(Context context,int type, long triggerAtMillis, PendingIntent operation){
		AlarmManager alarmManager=(AlarmManager) context.getSystemService(Service.ALARM_SERVICE);
		alarmManager.set(type, triggerAtMillis, operation);
	}
	
	/**
	 * @see AlarmManager#cancel(PendingIntent)
	 * @param context
	 * @param operation
	 */
	public static void cancel(Context context,PendingIntent operation){
		AlarmManager alarmManager=(AlarmManager) context.getSystemService(Service.ALARM_SERVICE);
		alarmManager.cancel(operation);
	}
}
