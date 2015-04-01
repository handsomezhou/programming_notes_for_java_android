package com.handsomezhou.customobjectpassed.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Teacher implements Parcelable{
	private String mName;
	private int mAge;
	private String mCourse;
	
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
	
	public String getCourse() {
		return mCourse;
	}
	
	public void setCourse(String course) {
		mCourse = course;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(mName);
		dest.writeInt(mAge);
		dest.writeString(mCourse);	
	}
	
	public static final Parcelable.Creator<Teacher> CREATOR=new Parcelable.Creator<Teacher>() {

		@Override
		public Teacher createFromParcel(Parcel source) {
			Teacher teacher=new Teacher();
			teacher.mName=source.readString();
			teacher.mAge=source.readInt();
			teacher.mCourse=source.readString();
			
			return teacher;
		}

		@Override
		public Teacher[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Teacher[size];
		}
	};
}
