package com.example.htl.myapplacation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.example.htl.myapplacation.utils.ScreenUtils;

public class TabActivity extends AppCompatActivity {

	private ProgressView mProgressView;
	private LinearLayout mLinearLayout;
	private TextUtils d;

	private String str;


	private DoubleSlideSeekBar mDoubleSlideSeekBar;
	private MapValueView mMapValueView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);

//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//			WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
//			localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
//		}

		this.getWindow()
				.getDecorView()
				.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

		ScreenUtils.MIUISetStatusBarLightMode(this.getWindow(), true);
		ScreenUtils.FlymeSetStatusBarLightMode(this.getWindow(), true);


	}
}
