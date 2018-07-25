package com.example.htl.myapplacation;

import java.util.List;
import java.util.Map;

/**
 * Created by htl on 2018/5/24.
 */

public class GroupBean {
	private String str;
	private int groupId;
	private List<Map<String, Object>> mMaps;


	public GroupBean() {
	}

	public List<Map<String, Object>> getMaps() {
		return mMaps;
	}

	public void setMaps(List<Map<String, Object>> maps) {
		mMaps = maps;
	}



	public GroupBean(int groupId) {
		this.groupId = groupId;
	}

	public GroupBean(String str) {
		this.str = str;
	}

	public GroupBean(String str, int groupId) {
		this.str = str;
		this.groupId = groupId;
	}



	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}


	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
}
