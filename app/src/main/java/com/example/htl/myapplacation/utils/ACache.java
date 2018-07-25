package com.example.htl.myapplacation.utils;

import android.content.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by htl on 2018/4/16.
 */

public class ACache {


	private static final int MAX_COUNT = Integer.MAX_VALUE;
	private static final long MAX_SIZE = 50 * 1000 * 1000;
	private static String cacheName = "AcacheName";
	private AtomicLong cacheSize;
	private AtomicInteger cacheCount;
	private static File cacheFile;
	private Context mContext;
	private static ACache mACache;
	private AcacheManager mManager;

	public static void initFile(Context context) throws Exception {
		initFile(context, cacheName);
	}


	public static void initFile(Context context, String name) throws Exception {
		cacheFile = new File(context.getCacheDir(), name);
		if (mACache == null) {
			mACache = new ACache();
		}
	}

	public void put(String key, String value) throws IOException {
		File file = mManager.newFile(key);
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
		bufferedWriter.write(value);
		bufferedWriter.flush();
		bufferedWriter.close();


	}


	private ACache() throws Exception {
		if (!cacheFile.isDirectory() || !cacheFile.mkdirs()) {
			throw new Exception("没有文件");
		}

		mManager = new AcacheManager(MAX_SIZE, MAX_COUNT);

	}


	private class AcacheManager {

		private long currentSize;
		private int currentCount;

		private Map<File, Long> lastTimeMap = Collections.synchronizedMap(new HashMap<File, Long>());

		private AcacheManager(long size, int count) {
			cacheSize = new AtomicLong();
			cacheCount = new AtomicInteger();
			currentSize = caculatSize(cacheFile);

			cacheSize.set(currentSize);
			cacheCount.set(currentCount);
		}

		public void put(File file) {
			while ((currentCount + 1) > cacheCount.get()) {
				File removeFile = removeFile(cacheFile);
				cacheCount.set(-1);
				cacheSize.set(-removeFile.length());
			}
		}


		public File removeFile(File file) {


			long oldUpdateTime = 0;
			File endUpdateFile = null;

			long currentTime = 0;

			if (lastTimeMap == null || lastTimeMap.isEmpty()) {
				return null;
			}

			Set<Map.Entry<File, Long>> set = lastTimeMap.entrySet();
			for (Map.Entry<File, Long> map : set) {
				if (oldUpdateTime == 0l) {
					oldUpdateTime = map.getValue();
					endUpdateFile = map.getKey();
				} else {
					currentTime = map.getValue();
					if (currentTime < oldUpdateTime) {
						oldUpdateTime = currentTime;
						endUpdateFile = map.getKey();
					}
				}
			}

			return endUpdateFile;
		}


		public long caculatSize(File file) {
			long size = 0;
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				if (file == null) return size;
				for (int i = 0; i < files.length; i++) {
					size += caculatSize(files[i]);
				}
			} else {
				size += file.length();
				lastTimeMap.put(file, file.lastModified());
				currentCount++;
			}

			return size;
		}

		private File newFile(String key) {
			return new File(cacheFile, key.hashCode() + "");
		}


	}


}
