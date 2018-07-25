package com.example.htl.myapplacation.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by htl on 2018/4/16.
 */

public class LrucacheUtils {

	private LruCache<String,Bitmap> mLruCache;
	private LrucacheUtils() {
		int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
		int cacheSize = maxMemory/8;
		mLruCache = new LruCache<String,Bitmap>(cacheSize){
			@Override
			protected int sizeOf(String key, Bitmap value) {
				return value.getRowBytes()*value.getHeight()/1024;
			}
		};
	}
}
