package com.handsomezhou.fragmentdemo.fragment;

import com.handsomezhou.fragmentdemo.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainHorizontalFragment extends Fragment {
	private Context mContext;
	private Button mFragmentXmlLayoutBtn;
	private Button mFragmentCodeLayoutBtn;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main_horizontal,container, false);
		initData();
		initView(view);
		initListener();
		return view;
	}
	
	private void initData(){
		mContext=getActivity().getApplicationContext();
		return;
	}
	
	private void initView(View view){
		mFragmentXmlLayoutBtn=(Button) view.findViewById(R.id.fragment_xml_layout_btn);
		mFragmentCodeLayoutBtn=(Button) view.findViewById(R.id.fragment_code_layout_btn);
		return;
	}
	
	private void initListener(){
		mFragmentXmlLayoutBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clickFragmentXmlLayout();
			}
		});
		
		mFragmentCodeLayoutBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clickFragmentCodeLayout();
			}
		});
		return;
	}
	
	private void clickFragmentXmlLayout(){
		Toast.makeText(mContext,"clickFragmentXmlLayout" , Toast.LENGTH_SHORT).show();
	}
	
	private void clickFragmentCodeLayout(){
		Toast.makeText(mContext,"clickFragmentCodeLayout" , Toast.LENGTH_SHORT).show();
	}

}
