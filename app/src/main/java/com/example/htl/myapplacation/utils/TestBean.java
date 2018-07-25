package com.example.htl.myapplacation.utils;

import java.util.List;
import java.util.Map;

/**
 * Created by htl on 2018/5/24.
 */

public class TestBean {

	public OneBean mOneBean;
	public OneBean1 mOneBean1;
	public OneBean2 mOneBean2;

	public OneBean getOneBean() {
		return mOneBean;
	}

	public void setOneBean(OneBean oneBean) {
		mOneBean = oneBean;
	}

	public OneBean1 getOneBean1() {
		return mOneBean1;
	}

	public void setOneBean1(OneBean1 oneBean1) {
		mOneBean1 = oneBean1;
	}

	public OneBean2 getOneBean2() {
		return mOneBean2;
	}

	public void setOneBean2(OneBean2 oneBean2) {
		mOneBean2 = oneBean2;
	}

	public class OneBean {
		public String ontStr;
		public List<Map<String, Object>> oneList;

		public String getOntStr() {
			return ontStr;
		}

		public void setOntStr(String ontStr) {
			this.ontStr = ontStr;
		}

		public List<Map<String, Object>> getOneList() {
			return oneList;
		}

		public void setOneList(List<Map<String, Object>> oneList) {
			this.oneList = oneList;
		}
	}

	public class OneBean1 {
		public String ontStr;
		public List<Map<String, Object>> oneList;

		public String getOntStr() {
			return ontStr;
		}

		public void setOntStr(String ontStr) {
			this.ontStr = ontStr;
		}

		public List<Map<String, Object>> getOneList() {
			return oneList;
		}

		public void setOneList(List<Map<String, Object>> oneList) {
			this.oneList = oneList;
		}
	}


	public class OneBean2 {
		public String ontStr;
		public List<Map<String, Object>> oneList;

		public String getOntStr() {
			return ontStr;
		}

		public void setOntStr(String ontStr) {
			this.ontStr = ontStr;
		}

		public List<Map<String, Object>> getOneList() {
			return oneList;
		}

		public void setOneList(List<Map<String, Object>> oneList) {
			this.oneList = oneList;
		}
	}

}
