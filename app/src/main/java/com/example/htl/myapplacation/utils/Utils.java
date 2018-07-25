package com.example.htl.myapplacation.utils;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * Created by htl on 2018/2/27.
 */

public class Utils {


	/**
	 * 判断是否在前台
	 * @return
	 */
	public static boolean isAppOnForeground(Context context) {
		ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		String packageName = context.getPackageName();
		List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
				.getRunningAppProcesses();
		if (appProcesses == null)
			return false;

		for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
			// The name of the process that this object is associated with.
			if (appProcess.processName.equals(packageName)
					&& appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
				return true;
			}
		}

		return false;
	}


	public static int dp2px(Context context,int dp){
		float density = context.getResources().getDisplayMetrics().density;
		return (int) (dp*density+0.5f);
	}

	public static int sp2px(Context context,int sp){
		float density = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (sp*density+0.5f);
	}

}
