
package com.handsomezhou.test.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handsomezhou.test.R;

public class MainFragment extends BaseFragment {

    @Override
    protected void initData() {
        setContext(getActivity());

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }

    @Override
    protected void initListener() {

    }

}
