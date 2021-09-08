package com.handsomezhou.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.handsomezhou.demo.R;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public class NavigationBarLayout extends RelativeLayout {
	private Context mContext;
	private View mNavigationBarView;
	private ImageButton mImageBackBtn;
	private TextView mTitleTv;
	private View mDividingLineView;

	private String mTitle;

	private OnNavigationBarLayout mOnNavigationBarLayout;

	public interface OnNavigationBarLayout {
		void onBack();
	}

	public NavigationBarLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		initView();
		initData();
		initListener();
	}

	public OnNavigationBarLayout getOnNavigationBarLayout() {
		return mOnNavigationBarLayout;
	}

	public void setOnNavigationBarLayout(
			OnNavigationBarLayout onNavigationBarLayout) {
		mOnNavigationBarLayout = onNavigationBarLayout;
	}

	public ImageButton getImageBackBtn() {
		return mImageBackBtn;
	}

	public void setImageBackBtn(ImageButton imageBackBtn) {
		mImageBackBtn = imageBackBtn;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
		mTitleTv.setText(mTitle);
	}

	public TextView getTitleTv() {
		return mTitleTv;
	}

	public void setTitleTv(TextView titleTv) {
		mTitleTv = titleTv;
	}

	public View getDividingLineView() {
		return mDividingLineView;
	}

	public void setDividingLineView(View dividingLineView) {
		mDividingLineView = dividingLineView;
	}

	private void initView() {
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mNavigationBarView = (View) inflater.inflate(R.layout.navigation_bar,this);
		mImageBackBtn = (ImageButton) mNavigationBarView.findViewById(R.id.back_btn);
		mTitleTv = (TextView) mNavigationBarView
				.findViewById(R.id.title_text_view);
		mDividingLineView = mNavigationBarView
				.findViewById(R.id.dividing_line_view);
		return;
	}

	private void initData() {

		return;
	}

	private void initListener() {
		mImageBackBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (null != mOnNavigationBarLayout) {
					mOnNavigationBarLayout.onBack();
				}

			}
		});
		return;
	}

}
