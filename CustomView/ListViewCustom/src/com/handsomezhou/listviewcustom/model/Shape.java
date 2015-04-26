package com.handsomezhou.listviewcustom.model;

public class Shape {
	private String mName;
	private int mImageId;
	
	public Shape(String name, int imageId){
		this.mName=name;
		this.mImageId=imageId;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	public int getImageId() {
		return mImageId;
	}

	public void setImageId(int imageId) {
		mImageId = imageId;
	}

}
