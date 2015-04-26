package com.handsomezhou.fragmentdemo.fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.handsomezhou.bottomtab.Interface.OnTabChange;
import com.handsomezhou.bottomtab.model.IconButtonData;
import com.handsomezhou.bottomtab.model.IconButtonValue;
import com.handsomezhou.fragmentdemo.R;
import com.handsomezhou.fragmentdemo.view.BottomTabView;

public class AddressBookBottomTabFragment extends BaseFragment implements OnTabChange{

	private BottomTabView mBottomTabView;
	   
    public enum BOTTOM_TAB_TAG{
        CALL,
        CONTACTS,
        SMS,
        MORE,
    }
	@Override
	protected void initData() {
		setContext(getActivity().getApplicationContext());
	}

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		View view=inflater.inflate(R.layout.fragment_address_book_bottom_tab, mBottomTabView, false);
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
		
		
	}

	/*Start: OnTabChange*/
	@Override
	public void onChangeToTab(Object fromTab, Object toTab,
			TAB_CHANGE_STATE tabChangeState) {
		Toast.makeText(getContext(), "onChangeToTab"+"["+fromTab.toString()+"]["+toTab.toString()+"]tabChangeState["+tabChangeState.toString()+"]", Toast.LENGTH_SHORT).show();

		
	}

	@Override
	public void onClickTab(Object currentTab, TAB_CHANGE_STATE tabChangeState) {
		Toast.makeText(getContext(), "onClickTab"+"["+currentTab.toString()+"]tabChangeState¡¾"+tabChangeState.toString()+"]", Toast.LENGTH_SHORT).show();
	}
	/*End: OnTabChange*/

}
