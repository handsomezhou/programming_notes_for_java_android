package com.handsomezhou.fragmentdemo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.fragmentdemo.R;

public class MoreFragment extends BaseFragment {
	private Button mMoreBtn;
	@Override
	protected void initData() {
		setContext(getActivity());

	}

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		View view=inflater.inflate(R.layout.fragment_more, container, false);
		mMoreBtn=(Button) view.findViewById(R.id.more_btn);
		return view;
	}

	@Override
	protected void initListener() {
		if(null!=mMoreBtn){
			mMoreBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(getContext(),getContext().getResources().getString(R.string.more) , Toast.LENGTH_SHORT).show();
					
				}
			});
		}

	}

}
