package com.handsomezhou.fragmentdemo.fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.handsomezhou.fragmentdemo.R;

public class SmsFragment extends BaseFragment {
	private EditText mSmsEt;
	@Override
	protected void initData() {
		setContext(getActivity().getApplicationContext());
	}

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		View view=inflater.inflate(R.layout.fragment_sms, container, false);
		mSmsEt = (EditText) view.findViewById(R.id.sms_et);
		mSmsEt.setHint(getActivity().getApplicationContext().getString(
				R.string.sms));
		return view;
	}

	@Override
	protected void initListener() {
		mSmsEt.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				if (!TextUtils.isEmpty(s.toString())) {
					Toast.makeText(getContext(),
							s.toString(), Toast.LENGTH_SHORT).show();
				}

			}
		});

	}
}
