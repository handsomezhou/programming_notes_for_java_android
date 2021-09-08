package com.handsomezhou.demo.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import com.handsomezhou.demo.AppApplication;
import com.handsomezhou.demo.constant.SearchMode;


public class SearchModeSp {
	private static final String SEARCH_MODE="SEARCH_MODE";
	
	public static SearchMode getSearchMode(){
		SearchMode searchMode=SearchMode.T9;
		Context context = AppApplication.getContext();
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(context);
		
		String searchModeStr=sp.getString(SEARCH_MODE, SearchMode.T9.toString());
		if(searchModeStr.equals(SearchMode.QWERTY.toString())){
			searchMode=SearchMode.QWERTY;
		}else{
			searchMode=SearchMode.T9;
		}
		
		return searchMode;
	}
	
	public static void saveSearchMode(SearchMode searchMode){
		Context context = AppApplication.getContext();
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(context);
		Editor editor = sp.edit();
		editor.putString(SEARCH_MODE, searchMode.toString());
		editor.commit();
	}
}
