package com.handsomezhou.demo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handsomezhou.demo.R;
import com.handsomezhou.demo.activity.AboutActivity;
import com.handsomezhou.demo.activity.SettingsActivity;
import com.handsomezhou.demo.util.ViewUtil;
import com.handsomezhou.demo.view.NavigationBarLayout;


/**
 * Created by handsomezhou on 2021/9/8.
 */
public class MoreFragment extends BaseFragment implements NavigationBarLayout.OnNavigationBarLayout{
    private NavigationBarLayout mNavigationBarLayout;
    private String mTitle;

    private View mSettingsView;
    private View mAboutView;
    @Override
    protected void initData() {
        setContext(getActivity());
        mTitle = getContext().getString(R.string.more);
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_more, container, false);
        mNavigationBarLayout = (NavigationBarLayout) view.findViewById(R.id.navigation_bar_layout);
        mNavigationBarLayout.setOnNavigationBarLayout(this);
        ViewUtil.hideView(mNavigationBarLayout.getImageBackBtn());
        mNavigationBarLayout.setTitle(mTitle);


        mSettingsView=view.findViewById(R.id.settings_layout);
        mAboutView=view.findViewById(R.id.about_layout);
        return view;
    }

    @Override
    protected void initListener() {
        mSettingsView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                enterSettings();

            }
        });


        mAboutView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                enterAbout();

            }
        });

    }

    /* Start: OnNavigationBarLayout */
    @Override
    public void onBack() {


    }
    /* End: OnNavigationBarLayout */

    public void refreshFragment() {

        return;
    }

    private void enterSettings(){
        SettingsActivity.launch(getContext());
    }


    private void enterAbout(){
        AboutActivity.launch(getContext());
    }
}
