package com.example.htl.myapplacation.utils;

import android.util.Log;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * Created by htl on 2018/6/23.
 */

public class LongTypeAdapter extends TypeAdapter<Integer> {

	@Override
	public void write(JsonWriter out, Integer value) {
		try {
			if (value == null) {
				value = 0;
			}
			out.value(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer read(JsonReader in) {
		try {
			Integer value;
			if (in.peek() == JsonToken.NULL) {
				in.nextNull();
				Log.e("TypeAdapter", "null is not a number");
				return -1;
			}

			if (in.peek() == JsonToken.STRING) {
				String str = in.nextString();
				if (isInt(str)) {
					return Integer.parseInt(str);
				} else {
					Log.e("TypeAdapter", str + " is not a int number");
					return -1;
				}
			} else {
				value = in.nextInt();
				return value;
			}
		} catch (Exception e) {
			Log.e("TypeAdapter", "Not a number", e);
		}
		return -1;
	}

	private boolean isInt(String str) {
		try {
			Integer.valueOf(str);

		} catch (NumberFormatException e) {
			return false;
		}

		return true;

	}
}
