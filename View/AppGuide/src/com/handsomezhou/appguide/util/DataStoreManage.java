package com.handsomezhou.appguide.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class DataStoreManage {
	public static final String SHAREDPREFERENCES_GUIDE="SHAREDPREFERENCES_GUIDE";
	public static final String KEY_GUIDE_FIRST_IN="KEY_GUIDE_FIRST_IN"; 
	
	public static void setGuideFirstIn(Context context,boolean firstIn){
		SharedPreferences preferences = context.getSharedPreferences(SHAREDPREFERENCES_GUIDE, Context.MODE_PRIVATE);
		
		Editor editor = preferences.edit();
		editor.putBoolean(KEY_GUIDE_FIRST_IN, firstIn);
		editor.commit();
	}
	
	public static boolean isGuideFirstIn(Context context){
		SharedPreferences preferences = context.getSharedPreferences(SHAREDPREFERENCES_GUIDE, Context.MODE_PRIVATE);
		boolean guideFirstIn = preferences.getBoolean(KEY_GUIDE_FIRST_IN, true);
		
		return guideFirstIn;
	}
}
