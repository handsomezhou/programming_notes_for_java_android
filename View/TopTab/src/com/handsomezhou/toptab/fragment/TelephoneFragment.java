package com.handsomezhou.toptab.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.toptab.R;

public class TelephoneFragment extends Fragment {
	private Button mTelephoneBtn;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_telephone, container, false);
		initView(v);
		initListener();
		
		return v;
	}
	
	private void initView(View v){
		if(null==v){
			return;
		}
		
		mTelephoneBtn=(Button) v.findViewById(R.id.telephone_btn);
	}
	
	private void initListener(){
		if(null!=mTelephoneBtn){
			mTelephoneBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(getActivity().getApplicationContext(),getActivity().getApplicationContext().getResources().getString(R.string.telephone) , Toast.LENGTH_SHORT).show();
				}
			});
		}
	}

}
