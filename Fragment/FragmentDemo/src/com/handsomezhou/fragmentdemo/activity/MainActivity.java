package com.handsomezhou.fragmentdemo.activity;

import com.handsomezhou.fragmentdemo.R;
import com.handsomezhou.fragmentdemo.R.layout;
import com.handsomezhou.fragmentdemo.R.menu;
import com.handsomezhou.fragmentdemo.fragment.MainHorizontalFragment;
import com.handsomezhou.fragmentdemo.fragment.MainVerticalFragment;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

public class MainActivity extends BaseFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	
	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initView() {
		
		FragmentManager fm=getSupportFragmentManager();
		Fragment fragment=new MainVerticalFragment();
		if(this.getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){
			fragment=new MainVerticalFragment();
		}else{
			fragment=new MainHorizontalFragment();
		}
		
		fm.beginTransaction().replace(R.id.fragment_container, fragment).commit();
		
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		
	}


}
