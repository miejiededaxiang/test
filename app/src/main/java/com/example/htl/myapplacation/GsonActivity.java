package com.example.htl.myapplacation;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class GsonActivity extends AppCompatActivity {

	GsonBean mGsonBean;
	private WebView mWebView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gson);

		mGsonBean = new GsonBean("ss");
		mWebView = findViewById(R.id.web_view);
		WebSettings webSettings = mWebView.getSettings();
		webSettings.setAllowFileAccess(true);
		webSettings.setJavaScriptEnabled(true);
		webSettings.setBuiltInZoomControls(false);
		webSettings.setLoadsImagesAutomatically(true);
		webSettings.setSupportZoom(true);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			// 让网页自适应屏幕宽度
			webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		}
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
		// 设置缓存
		webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

		webSettings.setLoadWithOverviewMode(true);
		webSettings.setUseWideViewPort(true);
		webSettings.setDefaultTextEncodingName("UTF-8");
		webSettings.setPluginState(WebSettings.PluginState.ON);
		webSettings.setSupportZoom(true);
		// Technical settings
		webSettings.setSupportMultipleWindows(true);

		webSettings.setAppCacheEnabled(true);
		webSettings.setDatabaseEnabled(true);
		webSettings.setDomStorageEnabled(true);
		webSettings.setSaveFormData(true);

		mWebView.loadUrl("file:///android_asset/index.html");

	}

}
