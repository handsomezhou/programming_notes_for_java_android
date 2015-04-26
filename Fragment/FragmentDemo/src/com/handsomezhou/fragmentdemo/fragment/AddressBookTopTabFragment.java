package com.handsomezhou.fragmentdemo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handsomezhou.fragmentdemo.R;
import com.handsomezhou.fragmentdemo.view.PagerSlidingTabStrip;

public class AddressBookTopTabFragment extends BaseFragment {

	private TelephoneFragment mTelephoneFragment;
	private ContactsFragment mContactsFragment;
	private SmsFragment mSmsFragment;

	private List<String> mTitles;

	private PagerSlidingTabStrip mPagerSlidingTabStrip;
	private DisplayMetrics mDisplayMetrics;

	@Override
	protected void initData() {
		setContext(getActivity().getApplicationContext());
		mDisplayMetrics = getResources().getDisplayMetrics();

		// init title
		mTitles = new ArrayList<String>();
		mTitles.add(getResources().getString(R.string.telephone));
		mTitles.add(getResources().getString(R.string.contacts));
		mTitles.add(getResources().getString(R.string.sms));

	}

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		View view=inflater.inflate(R.layout.fragment_address_book_top_tab, container, false);
		mPagerSlidingTabStrip=(PagerSlidingTabStrip) view.findViewById(R.id.pager_sliding_tab_strip);
		ViewPager view_pager=(ViewPager)view.findViewById(R.id.view_pager);
		FragmentManager fm=this.getActivity().getSupportFragmentManager();
		view_pager.setAdapter(new TelephoneFragmentPagerAdapter(fm,mTitles));
		mPagerSlidingTabStrip.setViewPager(view_pager);
		setPagerSlidingTabStripValue();
		return view;
	}

	@Override
	protected void initListener() {
		// TODO Auto-generated method stub

	}
	
	private void setPagerSlidingTabStripValue(){
		// 设置Tab是自动填充满屏幕的
		mPagerSlidingTabStrip.setShouldExpand(true);
		// 设置Tab的分割线是透明的
		mPagerSlidingTabStrip.setDividerColor(Color.TRANSPARENT);
		// 设置Tab底部线的高度
		mPagerSlidingTabStrip.setUnderlineHeight((int) TypedValue.applyDimension(
						TypedValue.COMPLEX_UNIT_DIP, 1, mDisplayMetrics));
		// 设置Tab Indicator的高度
		mPagerSlidingTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(
						TypedValue.COMPLEX_UNIT_DIP, 4, mDisplayMetrics));
		// 设置Tab标题文字的大小
		mPagerSlidingTabStrip.setTextSize((int) TypedValue.applyDimension(
						TypedValue.COMPLEX_UNIT_SP, 16, mDisplayMetrics));
		// 设置Tab Indicator的颜色
		mPagerSlidingTabStrip.setIndicatorColor(Color.parseColor("#45c01a"));
		// 设置选中Tab文字的颜色 (这是我自定义的一个方法)
		mPagerSlidingTabStrip.setSelectedTextColor(Color.parseColor("#45c01a"));
		// 取消点击Tab时的背景色
		mPagerSlidingTabStrip.setTabBackground(0);
	}
	
	public class TelephoneFragmentPagerAdapter extends FragmentPagerAdapter{
		private List<String> mTelephoneTitleList;
		public TelephoneFragmentPagerAdapter(FragmentManager fm,List<String> titleList) {
			super(fm);
			mTelephoneTitleList=titleList;
		}

		
		@Override
		public CharSequence getPageTitle(int position) {
			return mTelephoneTitleList.get(position);
		}


		@Override
		public Fragment getItem(int position) {
			Fragment fragment=null;
			switch (position) {
			case 0:
				if(null==mTelephoneFragment){
					mTelephoneFragment=new TelephoneFragment();
				}
				fragment=mTelephoneFragment;
				break;
			case 1:
				if(null==mContactsFragment){
					mContactsFragment=new ContactsFragment();
				}
				fragment=mContactsFragment;
				break;
			case 2:
				if(null==mSmsFragment){
					mSmsFragment=new SmsFragment();
				}
				fragment=mSmsFragment;
				break;
			default:
				break;
			}
			return fragment;
		}

		@Override
		public int getCount() {
			
			return mTelephoneTitleList.size();
		}
		
	}
}
