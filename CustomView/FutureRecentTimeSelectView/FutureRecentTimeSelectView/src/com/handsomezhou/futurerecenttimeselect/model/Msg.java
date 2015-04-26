package com.handsomezhou.futurerecenttimeselect.model;

import java.io.Serializable;

public class Msg implements Cloneable,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mType;// msg type
	private String mText;//text msg
	private String mSender;// msg sender
	private String mReceiver;//msg receiver
	
	public int getType() {
		return mType;
	}
	
	public void setType(int type) {
		mType = type;
	}
	
	public String getText() {
		return mText;
	}
	
	public void setText(String text) {
		mText = text;
	}
	
	public String getSender() {
		return mSender;
	}
	
	public void setSender(String sender) {
		mSender = sender;
	}
	
	public String getReceiver() {
		return mReceiver;
	}
	
	public void setReceiver(String receiver) {
		mReceiver = receiver;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
