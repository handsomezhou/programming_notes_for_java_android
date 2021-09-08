package com.handsomezhou.demo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handsomezhou.demo.R;
import com.handsomezhou.demo.util.ViewUtil;
import com.handsomezhou.demo.view.NavigationBarLayout;


/**
 * Created by handsomezhou on 2021/9/8.
 */
public class HomePageFragment extends BaseFragment implements NavigationBarLayout.OnNavigationBarLayout{
    private NavigationBarLayout mNavigationBarLayout;
    private String mTitle;
    @Override
    protected void initData() {
        setContext(getActivity());
        mTitle = getContext().getString(R.string.home_page);
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_home_page, container, false);
        mNavigationBarLayout = (NavigationBarLayout) view.findViewById(R.id.navigation_bar_layout);
        mNavigationBarLayout.setOnNavigationBarLayout(this);
        ViewUtil.hideView(mNavigationBarLayout.getImageBackBtn());
        mNavigationBarLayout.setTitle(mTitle);
        return view;
    }

    @Override
    protected void initListener() {

    }

    /* Start: OnNavigationBarLayout */
    @Override
    public void onBack() {


    }
    /* End: OnNavigationBarLayout */

    public void refreshFragment() {

        return;
    }
}
