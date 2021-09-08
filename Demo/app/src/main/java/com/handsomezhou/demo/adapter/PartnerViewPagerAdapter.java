package com.handsomezhou.demo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.handsomezhou.demo.model.PartnerView;

import java.util.List;


/**
 * Created by handsomezhou on 2021/9/8.
 */
public class PartnerViewPagerAdapter extends FragmentPagerAdapter {
	List<PartnerView> mPartnerViews;
	public PartnerViewPagerAdapter(FragmentManager fm, List<PartnerView> partnerViews) {
		super(fm);
		mPartnerViews=partnerViews;
	}

	@Override
	public Fragment getItem(int pos) {
		PartnerView partnerViews=mPartnerViews.get(pos);
		return partnerViews.getFragment();
	}

	@Override
	public int getCount() {
		
		return mPartnerViews.size();
	}

}
