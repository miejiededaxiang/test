package com.example.htl.myapplacation;

/**
 * Created by htl on 2018/5/15.
 */

public class Bean {

	/**
	 * addTime : 1525950489000
	 * content : 调入分公司：【成都分公司】，数量：【1】
	 * id : 901
	 * isRead : 0
	 * msgType : 7
	 * title : 请尽快进行车辆调拨审批
	 */

	private long addTime;
	private String content;
	private int id;
	private int isRead;
	private String msgType;
	private String title;

	public long getAddTime() {
		return addTime;
	}

	public void setAddTime(long addTime) {
		this.addTime = addTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
