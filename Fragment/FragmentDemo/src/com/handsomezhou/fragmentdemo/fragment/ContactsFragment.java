package com.handsomezhou.fragmentdemo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.fragmentdemo.R;

public class ContactsFragment extends BaseFragment {
	private Button mContactsBtn;

	@Override
	protected void initData() {
		setContext(getActivity());
	}

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		View view =inflater.inflate(R.layout.fragment_contacts, container, false);
		mContactsBtn=(Button) view.findViewById(R.id.contacts_btn);
		return view;
	}

	@Override
	protected void initListener() {
		mContactsBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getContext(), getContext().getResources().getString(R.string.contacts), Toast.LENGTH_SHORT).show();
				
			}
		});
		
	}
}
