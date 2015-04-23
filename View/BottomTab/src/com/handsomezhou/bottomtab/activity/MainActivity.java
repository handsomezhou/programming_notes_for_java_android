package com.handsomezhou.bottomtab.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.handsomezhou.bottomtab.R;
import com.handsomezhou.bottomtab.Interface.OnTabChange;
import com.handsomezhou.bottomtab.Interface.OnTabChange.TAB_CHANGE_STATE;
import com.handsomezhou.bottomtab.model.IconButtonData;
import com.handsomezhou.bottomtab.model.IconButtonValue;
import com.handsomezhou.bottomtab.view.BottomTabView;

public class MainActivity extends Activity implements OnTabChange{
    private Context mContext;
    private BottomTabView mBottomTabView;
    
    public enum BOTTOM_TAB_TAG{
        CALL,
        CONTACTS,
        SMS,
        MORE,
    }
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initView();
		initListener();
	}
	
	/*Start: IChangeToTabCallBack*/
	@Override
	public void onChangeToTab(Object fromTab, Object toTab,TAB_CHANGE_STATE tabChangeState ) {
		Toast.makeText(mContext, "onChangeToTab"+"["+fromTab.toString()+"]["+toTab.toString()+"]tabChangeState["+tabChangeState.toString()+"]", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClickTab(Object currentTab,TAB_CHANGE_STATE tabChangeState) {
		
		Toast.makeText(mContext, "onClickTab"+"["+currentTab.toString()+"]tabChangeState¡¾"+tabChangeState.toString()+"]", Toast.LENGTH_SHORT).show();

		
	}
	/*End: IChangeToTabCallBack*/
	
	private void initData(){
	    mContext=this;
	    return;
	}
	
	private void initView(){
	    mBottomTabView=(BottomTabView) findViewById(R.id.bottom_tab_view);
	    mBottomTabView.removeAllViews();
	    /*Start: call tab*/
	    IconButtonValue callIconBtnValue=new IconButtonValue(BOTTOM_TAB_TAG.CALL,R.drawable.call_icon_selected_unfocused,R.drawable.call_icon_selected_focused, R.drawable.call_icon_unselected, R.string.call);
	    IconButtonData callIconBtnData=new IconButtonData(mContext, callIconBtnValue);
	    mBottomTabView.addIconButtonData(callIconBtnData);
	    /*End: call tab*/
	    
	    /*Start: contacts tab*/
        IconButtonValue contactsIconBtnValue=new IconButtonValue(BOTTOM_TAB_TAG.CONTACTS,R.drawable.contacts_icon_selected_unfocused, R.drawable.contacts_icon_unselected, R.string.contacts);
        IconButtonData contactsIconBtnData=new IconButtonData(mContext, contactsIconBtnValue);
        mBottomTabView.addIconButtonData(contactsIconBtnData);
        /*End: contacts tab*/
        
        /*Start: sms tab*/
        IconButtonValue smsIconBtnValue=new IconButtonValue(BOTTOM_TAB_TAG.SMS,R.drawable.sms_icon_selected_unfocused, R.drawable.sms_icon_unselected, R.string.sms);
        IconButtonData smsIconBtnData=new IconButtonData(mContext, smsIconBtnValue);
        mBottomTabView.addIconButtonData(smsIconBtnData);
        /*End: sms tab*/
        
        /*Start: more tab*/
        IconButtonValue moreIconBtnValue=new IconButtonValue(BOTTOM_TAB_TAG.MORE,R.drawable.more_icon_selected_unfocused, R.drawable.more_icon_unselected, R.string.more);
        IconButtonData moreIconBtnData=new IconButtonData(mContext, moreIconBtnValue);
        mBottomTabView.addIconButtonData(moreIconBtnData);
        /*End: more tab*/
        mBottomTabView.setOnTabChange(this);
	    return;
	}
	
	private void initListener(){
	    
	    return;
	}


}
