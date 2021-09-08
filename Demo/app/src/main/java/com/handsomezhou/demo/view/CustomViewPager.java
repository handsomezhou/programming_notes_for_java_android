package com.handsomezhou.demo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public class CustomViewPager extends ViewPager {
	public static final String TAG	= CustomViewPager.class.getSimpleName();
	private float				mDownX;
	private float				mDownY;
	private boolean mPagingEnabled = true;

	public CustomViewPager(Context context) {
		super(context);
	}

	public CustomViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				mDownX = ev.getRawX();
				mDownY = ev.getRawY();
				break;
			case MotionEvent.ACTION_MOVE:
				float moveX = ev.getRawX();
				float moveY = ev.getRawY();

				int diffX = (int) (moveX - mDownX + .5f);
				int diffY = (int) (moveY - mDownY + .5f);

				int position = this.getCurrentItem();
				if (position == 0) {//第一页
					if (diffX > 0) {//往右拖动
						//Log.i(TAG, "第一页->往右拖动-->父容器处理");
						getParent().requestDisallowInterceptTouchEvent(false);
					} else {
						//Log.i(TAG, "第一页->往左拖动-->自己处理");
						getParent().requestDisallowInterceptTouchEvent(true);
					}

				} else if (position == this.getAdapter().getCount() - 1) {//最后一页
					if (diffX > 0) {//往右拖动
						//Log.i(TAG, "最后一页->往右拖动-->自己处理");
						getParent().requestDisallowInterceptTouchEvent(true);
					} else {
						//Log.i(TAG, "最后一页->往左拖动-->父容器处理");
						getParent().requestDisallowInterceptTouchEvent(false);
					}
				} else {//中间页
					//Log.i(TAG, "自己处理");
					getParent().requestDisallowInterceptTouchEvent(true);
				}

				break;
			case MotionEvent.ACTION_UP:

				break;

			default:
				break;
		}

		return super.dispatchTouchEvent(ev);
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return this.mPagingEnabled && super.onTouchEvent(event);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		return this.mPagingEnabled && super.onInterceptTouchEvent(event);
	}

	public void setPagingEnabled(boolean pagingEnabled) {
		this.mPagingEnabled = pagingEnabled;
	}

	public boolean isPagingEnabled() {
		return mPagingEnabled;
	}

}