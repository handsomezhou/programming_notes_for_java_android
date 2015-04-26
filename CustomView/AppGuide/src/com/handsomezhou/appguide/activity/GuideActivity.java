package com.handsomezhou.appguide.activity;



import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.handsomezhou.appguide.R;
import com.handsomezhou.appguide.adapter.GuidePagerAdapter;
import com.handsomezhou.appguide.adapter.GuidePagerAdapter.OnGuidePagerAdapter;
import com.handsomezhou.appguide.util.DataStoreManage;

public class GuideActivity extends Activity implements OnPageChangeListener,OnGuidePagerAdapter{
	private Context mContext;
	private ViewPager mGuideViewPager;
	private GuidePagerAdapter mGuidePagerAdapter;
	private List<View> mViews;
	

	private ImageView[] mDots;
	private int mCurrentIndex;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		initData();
		initView();
		initListener();
	}
	
	private void initData(){
		
	}
	
	private void initView(){
		mGuideViewPager=(ViewPager)findViewById(R.id.guide_viewpager);
		
		LayoutInflater inflater=LayoutInflater.from(this);
		mViews=new ArrayList<View>();
		
		mViews.add(inflater.inflate(R.layout.guide_pager_one, null));
		mViews.add(inflater.inflate(R.layout.guide_pager_two, null));
		mViews.add(inflater.inflate(R.layout.guide_pager_three, null));
		mViews.add(inflater.inflate(R.layout.guide_pager_four, null));
		
		
		mGuidePagerAdapter=new GuidePagerAdapter(mViews, mContext);
		mGuidePagerAdapter.setOnGuidePagerAdapter(this);
		mGuideViewPager.setAdapter(mGuidePagerAdapter);
		
		
		initViewDots();
	}
	
	private void initListener(){
		mGuideViewPager.setOnPageChangeListener(this);
		
		initListenerDots();
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int position) {

		setCurrentDot(position);
		
	}
	
	private void initViewDots(){
		LinearLayout linearLayout=(LinearLayout) findViewById(R.id.ll);
		mDots=new ImageView[mViews.size()];
		
		for(int i=0; i<mViews.size(); i++){
			mDots[i]=(ImageView)linearLayout.getChildAt(i);
			mDots[i].setEnabled(true);
		}
		mCurrentIndex = 0;
		mDots[mCurrentIndex].setEnabled(false);
		
		return;
	}
	
	private void initListenerDots(){
		int dotsCount=mDots.length;
		for(int i=0; i<dotsCount; i++){
			mDots[i].setTag(i);
			mDots[i].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					int position=(Integer) v.getTag();
					setCurrentDot(position);
					mGuideViewPager.setCurrentItem(position);
				}
			});
		}
		
		return;
	}
	
	private void setCurrentDot(int position) {
		if (position < 0 || position > mViews.size() - 1
				|| mCurrentIndex == position) {
			return;
		}

		mDots[position].setEnabled(false);
		mDots[mCurrentIndex].setEnabled(true);

		mCurrentIndex = position;
	}

	@Override
	public void exitGuidePager() {
		DataStoreManage.setGuideFirstIn(GuideActivity.this, false);
		
		Intent intent=new Intent(GuideActivity.this, HomeActivity.class);
		startActivity(intent);
		GuideActivity.this.finish();
	}
}
