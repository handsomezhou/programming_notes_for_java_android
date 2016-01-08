
package com.handsomezhou.listviewloadmore.activity;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;

import com.handsomezhou.listviewloadmore.fragment.MainFragment;

public class MainActivity extends BaseSingleFragmentActivity implements
        OnClickListener {

    @Override
    protected Fragment createFragment() {

        return new MainFragment();

    }

    @Override
    protected boolean isRealTimeLoadFragment() {

        return false;
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        
    }

}
