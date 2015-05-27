
package com.handsomezhou.databasedemo.activity;

import android.support.v4.app.Fragment;

import com.handsomezhou.databasedemo.fragment.MainFragment;

public class MainActivity extends BaseSingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
       
        return new MainFragment();
    }

    @Override
    protected boolean isRealTimeLoadFragment() {
        return false;
    }


}
