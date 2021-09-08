package com.handsomezhou.demo.activity;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.android.commontools.util.ActivityUtil;
import com.handsomezhou.demo.fragment.VersionInfoFragment;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public class VersionInfoActivity extends BaseSingleFragmentActivity {

    @Override
    protected Fragment createFragment() {

        return new VersionInfoFragment();
    }

    @Override
    protected boolean isRealTimeLoadFragment() {

        return false;
    }

    public static void launch(Context context){
        ActivityUtil.launch(context, VersionInfoActivity.class);
        return;
    }
}
