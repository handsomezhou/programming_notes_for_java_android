package com.handsomezhou.bottomtab.view;

/**
 * custom view option
 * @author handsomezhou
 *
 */
public class ViewOption {
	private Object mTag;//tag
	private int mIcon;//icon
	private int mText;//text
	
	public ViewOption(Object tag, int icon, int text) {
		super();
		mTag = tag;
		mIcon = icon;
		mText = text;
	}

	public Object getTag() {
		return mTag;
	}
	
	public void setTag(Object tag) {
		mTag = tag;
	}
	
	public int getIcon() {
		return mIcon;
	}
	
	public void setIcon(int icon) {
		mIcon = icon;
	}
	
	public int getText() {
		return mText;
	}
	
	public void setText(int text) {
		mText = text;
	}
}
