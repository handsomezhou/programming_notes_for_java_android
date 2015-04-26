package com.handsomezhou.fragmentdemo.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.fragmentdemo.R;
import com.handsomezhou.fragmentdemo.activity.AddressBookTopTabActivity;

public class MainHorizontalFragment extends BaseFragment {
	private Button mFragmentTopTabBtn;
	private Button mFragmentBottomTabBtn;

	@Override
	protected void initData() {
		setContext(getActivity().getApplicationContext());
		return;
	}

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.fragment_main_horizontal,
				container, false);
		mFragmentTopTabBtn = (Button) view
				.findViewById(R.id.fragment_top_tab_btn);
		mFragmentBottomTabBtn = (Button) view
				.findViewById(R.id.fragment_code_layout_btn);
		return view;

	}

	@Override
	protected void initListener() {
		mFragmentTopTabBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				clickFragmentTopTab();
			}
		});

		mFragmentBottomTabBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				clickFragmentBottomTab();
			}
		});
		return;

	}


	private void clickFragmentTopTab() {
		Toast.makeText(getContext(), "fragment_top_tab", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(getContext(), AddressBookTopTabActivity.class);
		startActivity(intent);
	}

	private void clickFragmentBottomTab() {
		Toast.makeText(getContext(), "fragment_bottom_tab", Toast.LENGTH_SHORT).show();
	}

}
