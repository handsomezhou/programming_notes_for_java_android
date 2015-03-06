package com.handsomezhou.toptab.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.handsomezhou.toptab.R;

public class SmsFragment extends Fragment {
	private EditText mSmsEt;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_sms, container, false);
		initView(v);
		initData();
		initListener();
		return v;
	}
	
	private void initView(View view){
		mSmsEt=(EditText) view.findViewById(R.id.sms_et);
		mSmsEt.setHint(getActivity().getApplicationContext().getString(R.string.sms));
	}
	
	private void initData(){
		
	}
	
	private void initListener(){
		mSmsEt.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				if(!TextUtils.isEmpty(s.toString())){
					Toast.makeText(getActivity().getApplicationContext(),s.toString(), Toast.LENGTH_SHORT).show();
				}

			}
		});
	}
}
