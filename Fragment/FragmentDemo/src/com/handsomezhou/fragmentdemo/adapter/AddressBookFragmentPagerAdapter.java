package com.handsomezhou.fragmentdemo.adapter;

import java.util.List;

import com.handsomezhou.fragmentdemo.model.PartnerView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AddressBookFragmentPagerAdapter extends FragmentPagerAdapter {
	List<PartnerView> mAddressBookViews;
	public AddressBookFragmentPagerAdapter(FragmentManager fm,List<PartnerView> addressBookViews) {
		super(fm);
		mAddressBookViews=addressBookViews;
	}

	@Override
	public Fragment getItem(int pos) {
		PartnerView addressBookView=mAddressBookViews.get(pos);
		return addressBookView.getFragment();
	}

	@Override
	public int getCount() {
		
		return mAddressBookViews.size();
	}

}
