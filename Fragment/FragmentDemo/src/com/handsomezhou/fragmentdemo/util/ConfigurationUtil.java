package com.handsomezhou.fragmentdemo.util;

import android.content.Context;
import android.content.res.Configuration;

public class ConfigurationUtil {
	/**
	 * {@link Configuration#ORIENTATION_UNDEFINED}
	 * @param context
	 * @return
	 */
	public static boolean  isOrientationUndefined(Context context) {
		boolean orientationUndefined=false;
		do{
			if(null==context){
				break;
			}
			
			orientationUndefined=(context.getResources().getConfiguration().orientation==Configuration.ORIENTATION_UNDEFINED);
			break;
			
		}while(false);
		
		return orientationUndefined;
	}
	/**
	 * {@link Configuration#ORIENTATION_PORTRAIT}
	 * @param context
	 * @return
	 */
	public static boolean  isOrientationPortrait(Context context) {
		boolean orientationPortrait=false;
		do{
			if(null==context){
				break;
			}
			
			orientationPortrait=(context.getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT);
			break;
			
		}while(false);
		
		return orientationPortrait;
	}
	
	/**
	 * {@link Configuration#ORIENTATION_LANDSCAPE}
	 * @param context
	 * @return
	 */
	public static boolean  isOrientationLandscape(Context context) {
		boolean orientationLandscape=false;
		do{
			if(null==context){
				break;
			}
			
			orientationLandscape=(context.getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE);
			break;
			
		}while(false);
		
		return orientationLandscape;
	}
	
}
