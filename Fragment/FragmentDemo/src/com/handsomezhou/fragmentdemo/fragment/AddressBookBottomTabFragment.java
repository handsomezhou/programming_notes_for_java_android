package com.handsomezhou.fragmentdemo.fragment;


import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handsomezhou.fragmentdemo.R;
import com.handsomezhou.fragmentdemo.Interface.OnTabChange;
import com.handsomezhou.fragmentdemo.adapter.AddressBookFragmentPagerAdapter;
import com.handsomezhou.fragmentdemo.model.PartnerView;
import com.handsomezhou.fragmentdemo.model.IconButtonData;
import com.handsomezhou.fragmentdemo.model.IconButtonValue;
import com.handsomezhou.fragmentdemo.view.BottomTabView;
import com.handsomezhou.fragmentdemo.view.CustomViewPager;

public class AddressBookBottomTabFragment extends BaseFragment implements OnTabChange{	
	private List<PartnerView> mAddressBookViews;
	private BottomTabView mBottomTabView;
	private CustomViewPager mCustomViewPager;
	private AddressBookFragmentPagerAdapter mAddressBookFragmentPagerAdapter;
	   
    public enum BOTTOM_TAB_TAG{
        CALL,
        CONTACTS,
        SMS,
        MORE,
    }
	@Override
	protected void initData() {
		setContext(getActivity());
		mAddressBookViews=new ArrayList<PartnerView>();
		
		/*Start: call view*/
		PartnerView callAddressBookView=new PartnerView(BOTTOM_TAB_TAG.CALL, new TelephoneFragment());
		mAddressBookViews.add(callAddressBookView);
		/*End: call view*/
		
		/*Start: contacts view*/
		PartnerView contactsAddressBookView=new PartnerView(BOTTOM_TAB_TAG.CONTACTS, new ContactsFragment());
		mAddressBookViews.add(contactsAddressBookView);
		/*End: contacts view*/
		
		/*Start: contacts view*/
		PartnerView smsAddressBookView=new PartnerView(BOTTOM_TAB_TAG.SMS, new SmsFragment());
		mAddressBookViews.add(smsAddressBookView);
		/*End: contacts view*/
		
		/*Start: contacts view*/
		PartnerView moreAddressBookView=new PartnerView(BOTTOM_TAB_TAG.MORE, new MoreFragment());
		mAddressBookViews.add(moreAddressBookView);
		/*End: contacts view*/
		
	}

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		View view=inflater.inflate(R.layout.fragment_address_book_bottom_tab, container, false);
		mCustomViewPager=(CustomViewPager)view.findViewById(R.id.custom_view_pager);
		mCustomViewPager.setPagingEnabled(true);
		
	    mBottomTabView=(BottomTabView) view.findViewById(R.id.bottom_tab_view);
	    mBottomTabView.removeAllViews();
	    /*Start: call tab*/
	    IconButtonValue callIconBtnValue=new IconButtonValue(BOTTOM_TAB_TAG.CALL,R.drawable.call_icon_selected_unfocused,R.drawable.call_icon_selected_focused, R.drawable.call_icon_unselected, R.string.call);
	    IconButtonData callIconBtnData=new IconButtonData(getContext(), callIconBtnValue);
	    mBottomTabView.addIconButtonData(callIconBtnData);
	    /*End: call tab*/
	    
	    /*Start: contacts tab*/
        IconButtonValue contactsIconBtnValue=new IconButtonValue(BOTTOM_TAB_TAG.CONTACTS,R.drawable.contacts_icon_selected_unfocused, R.drawable.contacts_icon_unselected, R.string.contacts);
        IconButtonData contactsIconBtnData=new IconButtonData(getContext(), contactsIconBtnValue);
        mBottomTabView.addIconButtonData(contactsIconBtnData);
        /*End: contacts tab*/
        
        /*Start: sms tab*/
        IconButtonValue smsIconBtnValue=new IconButtonValue(BOTTOM_TAB_TAG.SMS,R.drawable.sms_icon_selected_unfocused, R.drawable.sms_icon_unselected, R.string.sms);
        IconButtonData smsIconBtnData=new IconButtonData(getContext(), smsIconBtnValue);
        mBottomTabView.addIconButtonData(smsIconBtnData);
        /*End: sms tab*/
        
        /*Start: more tab*/
        IconButtonValue moreIconBtnValue=new IconButtonValue(BOTTOM_TAB_TAG.MORE,R.drawable.more_icon_selected_unfocused, R.drawable.more_icon_unselected, R.string.more);
        IconButtonData moreIconBtnData=new IconButtonData(getContext(), moreIconBtnValue);
        mBottomTabView.addIconButtonData(moreIconBtnData);
        /*End: more tab*/
        mBottomTabView.setOnTabChange(this);
		return view;
	}

	@Override
	protected void initListener() {
		FragmentManager fm=getActivity().getSupportFragmentManager();
		mAddressBookFragmentPagerAdapter=new AddressBookFragmentPagerAdapter(fm, mAddressBookViews);
		mCustomViewPager.setAdapter(mAddressBookFragmentPagerAdapter);
		
		mCustomViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int pos) {
				
				PartnerView addressBookView=mAddressBookViews.get(pos);
				//Toast.makeText(getContext(),addressBookView.getTag().toString()+"+++" , Toast.LENGTH_LONG).show();
				mBottomTabView.setCurrentTabItem(addressBookView.getTag());
			}
			
			@Override
			public void onPageScrolled(int pos, float posOffset, int posOffsetPixels) {
				
				
			}
			
			@Override
			public void onPageScrollStateChanged(int state) {
				
			}
		});
	
		
	}

	/*Start: OnTabChange*/
	@Override
	public void onChangeToTab(Object fromTab, Object toTab,
			TAB_CHANGE_STATE tabChangeState) {
		//Toast.makeText(getContext(), "onChangeToTab"+"["+fromTab.toString()+"]["+toTab.toString()+"]tabChangeState["+tabChangeState.toString()+"]", Toast.LENGTH_SHORT).show();
		int item=getAddressBookViewItem(toTab);
		mCustomViewPager.setCurrentItem(item);	
	}

	@Override
	public void onClickTab(Object currentTab, TAB_CHANGE_STATE tabChangeState) {
		//Toast.makeText(getContext(), "onClickTab"+"["+currentTab.toString()+"]tabChangeState¡¾"+tabChangeState.toString()+"]", Toast.LENGTH_SHORT).show();
		Fragment fragment=mAddressBookViews.get(getAddressBookViewItem(currentTab)).getFragment();
		switch ((BOTTOM_TAB_TAG)currentTab) {
		case CALL:
			if(fragment instanceof TelephoneFragment){
				((TelephoneFragment) fragment).updateView(tabChangeState);
			}
			break;

		default:
			break;
		}
	}
	/*End: OnTabChange*/
	
	private int getAddressBookViewItem(Object tag){
		int item=0;;
		do{
			if(null==tag){
				break;
			}
			
			for(int i=0; i<mAddressBookViews.size();i++){
				if(mAddressBookViews.get(i).getTag().equals(tag)){
					item=i;
					break;
				}
			}
		}while(false);
	
		return item;
	}

}
