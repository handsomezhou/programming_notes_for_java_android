package com.handsomezhou.fragmentdemo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.fragmentdemo.R;
import com.handsomezhou.fragmentdemo.Interface.OnTabChange.TAB_CHANGE_STATE;

public class TelephoneFragment extends BaseFragment {
	private static final String TAG="TelephoneFragment";
	private Button mTelephoneBtn;

	@Override
	protected void initData() {
		setContext(getActivity());
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
	
	public void  updateView(TAB_CHANGE_STATE tabChangeState){
		switch (tabChangeState) {
		case TAB_UNSELECTED:
			Toast.makeText(getContext(), TAG+tabChangeState.toString(), Toast.LENGTH_SHORT).show();
			break;
		case TAB_SELECTED_UNFOCUSED:
			Toast.makeText(getContext(), TAG+tabChangeState.toString(), Toast.LENGTH_SHORT).show();
			break;
			
		case TAB_SELECTED_FOCUSED:
			Toast.makeText(getContext(), TAG+tabChangeState.toString(), Toast.LENGTH_SHORT).show();
			break;
			
		default:
			break;
		}
	}

}
