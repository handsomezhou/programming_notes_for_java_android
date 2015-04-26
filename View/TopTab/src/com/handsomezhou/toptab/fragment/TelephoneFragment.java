package com.handsomezhou.toptab.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.toptab.R;

public class TelephoneFragment extends BaseFragment {
	private Button mTelephoneBtn;

	@Override
	protected void initData() {
		setContext(getActivity().getApplicationContext());
	}

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		View view=inflater.inflate(R.layout.fragment_telephone, container, false);
		mTelephoneBtn=(Button) view.findViewById(R.id.telephone_btn);
		return view;
	}

	@Override
	protected void initListener() {
		if(null!=mTelephoneBtn){
			mTelephoneBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(getContext(),getContext().getResources().getString(R.string.telephone) , Toast.LENGTH_SHORT).show();
				}
			});
		}
		
	}

}
