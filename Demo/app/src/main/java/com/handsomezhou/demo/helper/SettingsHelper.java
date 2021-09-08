package com.handsomezhou.demo.helper;


import com.android.commontools.util.SharedPreferencesUtil;
import com.handsomezhou.demo.AppApplication;
import com.handsomezhou.demo.constant.SearchMode;
import com.handsomezhou.demo.sharedPreferences.SearchModeSp;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public class SettingsHelper {
    private static final String TAG="SettingsHelper";
    private static SettingsHelper mInstance;
    public static final String KEY_SEARCH_DATA_COUNT_SHOW="KEY_SEARCH_DATA_COUNT_SHOW";
    public static final String KEY_EXIT_APP_PROMPT = "KEY_EXIT_APP_PROMPT";


    private SearchMode mSearchMode;
    private boolean mSearchDataCountShow=true;
    private boolean mExitAppPrompt;





    public static SettingsHelper getInstance() {
        if (null == mInstance) {
            mInstance = new SettingsHelper();
        }

        return mInstance;
    }

    private SettingsHelper() {
        initSettingsHelper();
    }

    private void initSettingsHelper() {
        mSearchMode = SearchModeSp.getSearchMode();
        mSearchDataCountShow = SharedPreferencesUtil.getBoolean(AppApplication.getContext(), KEY_SEARCH_DATA_COUNT_SHOW, true);
        mExitAppPrompt = SharedPreferencesUtil.getBoolean(AppApplication.getContext(), KEY_EXIT_APP_PROMPT, true);

    }


    public SearchMode getSearchMode() {
        return mSearchMode;
    }

    public void setSearchMode(SearchMode searchMode) {
        SearchModeSp.saveSearchMode(searchMode);
        mSearchMode = searchMode;
    }

    public boolean isSearchDataCountShow() {
        return mSearchDataCountShow;
    }

    public void setSearchDataCountShow(boolean searchDataCountShow) {
        SharedPreferencesUtil.putBoolean(AppApplication.getContext(), KEY_SEARCH_DATA_COUNT_SHOW, searchDataCountShow);
        mSearchDataCountShow = searchDataCountShow;
    }

    public boolean isExitAppPrompt() {
        return mExitAppPrompt;
    }

    public void setExitAppPrompt(boolean exitAppPrompt) {
        SharedPreferencesUtil.putBoolean(AppApplication.getContext(), KEY_EXIT_APP_PROMPT, exitAppPrompt);
        mExitAppPrompt = exitAppPrompt;
    }
}
