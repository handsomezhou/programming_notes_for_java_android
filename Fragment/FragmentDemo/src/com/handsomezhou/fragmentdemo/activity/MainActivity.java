package com.handsomezhou.fragmentdemo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.handsomezhou.fragmentdemo.fragment.MainHorizontalFragment;
import com.handsomezhou.fragmentdemo.fragment.MainVerticalFragment;
import com.handsomezhou.fragmentdemo.util.ConfigurationUtil;

public class MainActivity extends BaseSingleFragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected Fragment createFragment() {
		
		return getFragment();
	}

	@Override
	protected boolean isRealTimeLoadFragment() {
		
		return true;
	}
	
	private Fragment getFragment(){
	
		Fragment fragment=new MainVerticalFragment();
		if(ConfigurationUtil.isOrientationPortrait(getContext())){
			fragment=new MainVerticalFragment();
		}else{
			fragment=new MainHorizontalFragment();
		}
		
		return fragment;
	}
}
