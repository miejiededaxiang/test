package com.example.htl.myapplacation;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.htl.myapplacation.litepreferences.LitePrefs;
import com.example.htl.myapplacation.utils.Utils;

public class MainActivity extends AppCompatActivity {
	private boolean isActivi = true;

	private ComponentName defaultName, changeName;
	private PackageManager mPackageManager;

	private static final String TAG = "htl";

	private boolean isOpenDefault = false;

	private TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);



	}

	public void change(View view) {
		isOpenDefault = false;


	}

	public void defaul(View view) {
		isOpenDefault = true;


	}

	@Override
	protected void onResume() {
		super.onResume();
		if (!isActivi) {
			Log.d(TAG, "onResume: ----->转到前台");
		}
	}

	@Override
	protected void onStop() {
		super.onStop();

		if (!Utils.isAppOnForeground(this)) {
			isActivi = false;
			Log.d(TAG, "onStop:----> 转到后台");

			if (isOpenDefault) {
				enabled(defaultName);
				disnable(changeName);
			} else {
				enabled(changeName);
				disnable(defaultName);
			}


		}
	}

	/**
	 * 启用
	 *
	 * @param componentName
	 */
	private void enabled(ComponentName componentName) {
		int state = mPackageManager.getComponentEnabledSetting(componentName);
		if (state == PackageManager.COMPONENT_ENABLED_STATE_ENABLED) {
			Toast.makeText(this, componentName.getClassName() + "----已经启用", Toast.LENGTH_SHORT).show();

		} else {
			mPackageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
		}
	}


	/**
	 * 默认
	 */
	private void disnable(ComponentName mComponentName) {
		int state = mPackageManager.getComponentEnabledSetting(mComponentName);
		if (state == PackageManager.COMPONENT_ENABLED_STATE_DISABLED) {
			Toast.makeText(this, mComponentName.getClassName() + "-----没有启用", Toast.LENGTH_SHORT).show();

		} else {
			mPackageManager.setComponentEnabledSetting(mComponentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
		}
	}


//	private void setVisibleDraw(TextView view) {
//		isActivi = false;
//		Drawable drawable = ContextCompat.getDrawable(this,R.drawable.ic);
//		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
//		view.setCompoundDrawables(null, null, drawable, null);
//	}
//
//	private void setGoneDraw(TextView view){
//		isActivi = true;
//		view.setCompoundDrawables(null,null,null,null);
//	}

}
