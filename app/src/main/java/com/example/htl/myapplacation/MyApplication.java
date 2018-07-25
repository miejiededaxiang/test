package com.example.htl.myapplacation;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by htl on 2018/2/27.
 */

public class MyApplication extends Application{

	private static final String TAG = "htl";
	@Override
	public void onCreate() {
		super.onCreate();

		registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
			@Override
			public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

			}

			@Override
			public void onActivityStarted(Activity activity) {
				Log.d(TAG, "从后台到前台");
			}

			@Override
			public void onActivityResumed(Activity activity) {

			}

			@Override
			public void onActivityPaused(Activity activity) {
				Log.d(TAG, "从前台到后台");

			}

			@Override
			public void onActivityStopped(Activity activity) {

			}

			@Override
			public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

			}

			@Override
			public void onActivityDestroyed(Activity activity) {

			}
		});
	}

}
