package com.handsomezhou.toptab.fragment;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.handsomezhou.toptab.R;

public class ContactsFragment extends BaseFragment {
	private Button mContactsBtn;

	@Override
	protected void initData() {
		setContext(getActivity().getApplicationContext());
	}

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		LinearLayout ll = new LinearLayout(getActivity());
		LayoutParams llParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		ll.setGravity(Gravity.CENTER);
		ll.setLayoutParams(llParams);
		
		mContactsBtn=new Button(getContext());
		LayoutParams btnLayoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		DisplayMetrics dm = getResources().getDisplayMetrics();
		final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, dm);
		btnLayoutParams.setMargins(margin, margin, margin, margin);
		mContactsBtn.setLayoutParams(btnLayoutParams);
		mContactsBtn.setGravity(Gravity.CENTER);
		mContactsBtn.setText(getContext().getResources().getString(R.string.contacts));
		mContactsBtn.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, dm));
		mContactsBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getContext(),getContext().getResources().getString(R.string.contacts) , Toast.LENGTH_SHORT).show();				
			}
		});
		
		ll.addView(mContactsBtn);
		
		return ll;
	}

	@Override
	protected void initListener() {
		// TODO Auto-generated method stub
		
	}
}
