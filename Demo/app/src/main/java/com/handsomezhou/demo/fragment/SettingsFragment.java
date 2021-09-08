package com.handsomezhou.demo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.handsomezhou.demo.R;

import com.handsomezhou.demo.constant.SearchMode;
import com.handsomezhou.demo.helper.SettingsHelper;
import com.handsomezhou.demo.view.NavigationBarLayout;
import com.handsomezhou.demo.view.SegmentedGroup;
import com.handsomezhou.demo.view.switchbutton.SwitchButton;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public class SettingsFragment extends BaseFragment implements NavigationBarLayout.OnNavigationBarLayout {
    private static final String TAG = "SettingsFragment";
    private NavigationBarLayout mNavigationBarLayout;
    private String mTitle;


    /**
     * start: search mode
     */
    private SegmentedGroup mSearchModeSegmented;
    private RadioButton mT9RadioBtn;
    private RadioButton mQwertyRadioBtn;
    /**
     *  end: search mode
     */
    private TextView mSearchDataCountShowTv;
    private SwitchButton mSearchDataCountShowSwitchBtn;
    /**
     * start : exit_app_prompt switch button
     */
    private SwitchButton mExitAppPromptSwitchBtn;
    /**
     *  end : exit_app_prompt switch button
     */


    @Override
    public void onResume() {
        super.onResume();
        refreshView();

    }


    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    protected void initData() {
        setContext(getActivity());
        mTitle = getContext().getString(R.string.settings);
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        mNavigationBarLayout = (NavigationBarLayout) view.findViewById(R.id.navigation_bar_layout);
        mNavigationBarLayout.setOnNavigationBarLayout(this);
        mNavigationBarLayout.setTitle(mTitle);


        mSearchModeSegmented = (SegmentedGroup) view.findViewById(R.id.search_mode_segmented);
        mT9RadioBtn = (RadioButton) view.findViewById(R.id.t9_radio_btn);
        mQwertyRadioBtn = (RadioButton) view.findViewById(R.id.qwerty_radio_btn);
        SearchMode searchMode = SettingsHelper.getInstance().getSearchMode();
        if (SearchMode.QWERTY == searchMode) {
            mQwertyRadioBtn.setChecked(true);
        } else {
            mT9RadioBtn.setChecked(true);
        }

        mSearchDataCountShowTv= (TextView) view.findViewById(R.id.search_data_count_show_text_view);
        mSearchDataCountShowSwitchBtn= (SwitchButton) view.findViewById(R.id.search_data_count_show_switch_btn);
        boolean searchDataCountShow=SettingsHelper.getInstance().isSearchDataCountShow();
        mSearchDataCountShowSwitchBtn.setChecked(searchDataCountShow);

        mExitAppPromptSwitchBtn = (SwitchButton) view.findViewById(R.id.exit_app_prompt_switch_btn);

        boolean exitAppPrompt = SettingsHelper.getInstance().isExitAppPrompt();
        mExitAppPromptSwitchBtn.setChecked(exitAppPrompt);


        return view;
    }

    @Override
    protected void initListener() {

        mNavigationBarLayout.getTitleTv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        mSearchModeSegmented.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.qwerty_radio_btn:
                        SettingsHelper.getInstance().setSearchMode(SearchMode.QWERTY);
                        break;
                    case R.id.t9_radio_btn:
                        SettingsHelper.getInstance().setSearchMode(SearchMode.T9);
                        break;
                    default:
                        break;
                }

            }
        });

        mSearchDataCountShowSwitchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SettingsHelper.getInstance().setSearchDataCountShow(isChecked);

            }
        });


        mExitAppPromptSwitchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        SettingsHelper.getInstance().setExitAppPrompt(isChecked);
                    }
                });

    }




    /* Start: OnNavigationBarLayout */
    @Override
    public void onBack() {
        back();

    }

    /* End: OnNavigationBarLayout */


    private void back() {
        getActivity().finish();
    }


    private void refreshView(){

    }



}

