package htl.com.testdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

public class MyReceiver2 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		String action = intent.getAction();
		Bundle bundle = intent.getExtras();
		switch (action) {
			case JPushInterface.ACTION_REGISTRATION_ID:

				break;
			case JPushInterface.ACTION_MESSAGE_RECEIVED:

				break;
			case JPushInterface.ACTION_NOTIFICATION_RECEIVED:
					String tile = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
				Log.d("TAG", "onReceive----:NOTIFICATION_RECEIVED "+tile);
				break;
			case JPushInterface.ACTION_NOTIFICATION_OPENED:

				break;
		}
	}
}
