package htl.com.testdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.HashMap;

import cn.jiguang.share.android.api.JShareInterface;
import cn.jiguang.share.android.api.PlatActionListener;
import cn.jiguang.share.android.api.Platform;
import cn.jiguang.share.android.api.PlatformConfig;
import cn.jiguang.share.android.api.ShareParams;
import cn.jiguang.share.qqmodel.QQ;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";
	private ImageView mView;
	private TextView mText;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		JShareInterface.setDebugMode(true);
		PlatformConfig platformConfig = new PlatformConfig()
				.setWechat("wxc40e16f3ba6ebabc", "dcad950cd0633a27e353477c4ec12e7a")
				.setQQ("1108048894", "stSrjun0Yjfv88hw")
				.setSinaWeibo("374535501", "baccd12c166f1df96736b51ffbf600a2", "https://www.jiguang.cn")
				.setFacebook("1847959632183996", "JShareDemo")
				.setTwitter("fCm4SUcgYI1wUACGxB2erX5pL", "NAhzwYCgm15FBILWqXYDKxpryiuDlEQWZ5YERnO1D89VBtZO6q")
				.setJchatPro("1847959632183996");
		/**
		 * since 1.5.0，1.5.0版本后增加API，支持在代码中设置第三方appKey等信息，当PlatformConfig为null时，或者使用JShareInterface.init(Context)时需要配置assets目录下的JGShareSDK.xml
		 **/
		//*
		JShareInterface.init(this, platformConfig);
		JPushInterface.setDebugMode(true);
		JPushInterface.init(this);

		mView = findViewById(R.id.img);
		mText = findViewById(R.id.tet);
		Glide.with(this).load("https://www.baidu.com/img/bd_logo1.png").into(mView);
		String text = "2018.12.2" + "&emsp&emsp&emsp  用户xxxx<font color='#ff0000'>fdsfsdfdfd</font>";
		mText.setText(Html.fromHtml(text));
		mText.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String id = JPushInterface.getRegistrationID(getApplicationContext());
				Log.d(TAG, "onClick:---- "+id);
				ShareParams shareParams = new ShareParams();
				shareParams.setShareType(Platform.SHARE_WEBPAGE);
				shareParams.setTitle("share_title");
				shareParams.setText("share_text");
				shareParams.setUrl("https://www.baidu.com/");
				JShareInterface.share(QQ.Name, shareParams, mPlatActionListener);
			}
		});

		Log.d(TAG, "isValid---- " + JShareInterface.isClientValid(QQ.Name));
	}

	private PlatActionListener mPlatActionListener = new PlatActionListener() {
		@Override
		public void onComplete(Platform platform, int action, HashMap<String, Object> data) {
			Log.d(TAG, "onComplete: ");
		}

		@Override
		public void onError(Platform platform, int action, int errorCode, Throwable error) {
			Log.d(TAG, "分享失败:" + (error != null ? error.getMessage() : "") + "---" + errorCode);
		}

		@Override
		public void onCancel(Platform platform, int action) {
			Log.d(TAG, "onCancel: ");
		}
	};
}
