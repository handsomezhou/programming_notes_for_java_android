package com.handsomezhou.customobjectpassed.model;

import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mId;
	private String mName;
	private int mAge;
	
	public String getId() {
		return mId;
	}
	
	public void setId(String id) {
		mId = id;
	}
	
	public String getName() {
		return mName;
	}
	
	public void setName(String name) {
		mName = name;
	}
	
	public int getAge() {
		return mAge;
	}
	
	public void setAge(int age) {
		mAge = age;
	}
	
}
