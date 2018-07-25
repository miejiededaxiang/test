package com.example.htl.myapplacation;

import com.google.gson.annotations.Expose;

/**
 * Created by htl on 2018/6/6.
 */

public class GsonBean {

	private String name;
	private int age;

	public GsonBean(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public GsonBean(int age) {
		this.age = age;
	}

	public GsonBean(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
