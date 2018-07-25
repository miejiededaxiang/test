package com.example.htl.myapplacation.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.math.BigDecimal;

/**
 * Created by htl on 2018/4/16.
 */

public class CacheUtils {

	private static final String TAG = "htl";


	private File cacheFile;
	private File saveFile;
	private File saveEnvirmentFile;
	private File cacheEnvirmentFile;

	public void getFile(Context context) {
		cacheFile = context.getCacheDir();
		saveFile = context.getFilesDir();
		Log.d(TAG, "cacheFile --->" + cacheFile.getPath());
		Log.d(TAG, "saveFile: --->" + saveFile.getPath());
	}

	public void getEnvirmentFile(Context context) {

		if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
			saveEnvirmentFile = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
			cacheEnvirmentFile = context.getExternalCacheDir();

			Log.d(TAG, "saveEnvirmentFile --->" + saveEnvirmentFile.getPath());
			Log.d(TAG, "cacheEnvirmentFile: --->" + cacheEnvirmentFile.getPath());
		} else {
			Toast.makeText(context, "SD卡未挂载", Toast.LENGTH_SHORT).show();
		}
	}

	public long getFolderSize(File file) {
		long size = 0;

		try {

			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				File subFile = files[i];
				if (subFile.isDirectory()) {
					size = size + getFolderSize(subFile);
				} else {
					size = size + subFile.length();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return size;
	}

	public String getTotalCacheSize(Context context) {
		long cacheSize = getFolderSize(context.getCacheDir());

		if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
			cacheSize += getFolderSize(context.getExternalCacheDir());
		}

		return getFormatSize(cacheSize);


	}

	public String getFormatSize(double size) {
		double kSize = size / 1024;
		if (kSize < 1) {
			return "0K";
		}

		double mSize = kSize / 1024;
		if (mSize < 1) {
			BigDecimal mDecimal = new BigDecimal(Double.toString(kSize));
			return mDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "K";
		}


		BigDecimal mDecimal = new BigDecimal(Double.toString(mSize));
		return mDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "M";
	}

	public void clearCache(Context context) {
		deleteDir(context.getCacheDir());
		if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
			deleteDir(context.getExternalCacheDir());
		}
	}

	private boolean deleteDir(File dir) {
		if (dir != null && dir.isDirectory()) {

			try {

				File[] files = dir.listFiles();
				for (int i = 0; i < files.length; i++) {
					File dir1 = files[i];
					boolean isSuc = deleteDir(dir);
					if (!isSuc) {
						return false;
					}

				}
			} catch (Exception e) {

			}

		}


		return dir.delete();
	}

}
