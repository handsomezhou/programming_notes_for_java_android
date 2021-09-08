package com.handsomezhou.demo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.commontools.constant.Constant;
import com.android.commontools.util.AppUtil;
import com.android.commontools.util.TimeUtil;
import com.handsomezhou.demo.R;
import com.handsomezhou.demo.activity.MainActivity;


/**
 * Created by handsomezhou on 2021/9/8.
 */
public class StartFragment extends BaseFragment{
    private static final String TAG = "StartFragment";

    private static final int START_TO_HOME_DELAY_MILLIS = 1600;// ms
    private static final int GO_GUIDE = 0x01;
    private static final int GO_LOGIN = 0x02;
    private static final int GO_HOME = 0x03;

    private String mVersionName;
    private TextView mVersionNameTv;
    private TextView mCopyrightInfoTv;
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_GUIDE:
                    goGuide();
                    break;
                case GO_LOGIN:
                    goLogin();
                    break;
                case GO_HOME:
                    goHome();
                    break;

                default:
                    break;
            }
            super.handleMessage(msg);
        }

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void initData() {
        setContext(getActivity());

        mVersionName = getContext().getString(R.string.android_version)
                + Constant.SPACE
                + Constant.V
                + AppUtil.getVersionName(getContext(), getContext()
                .getPackageName());

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        mVersionNameTv = (TextView) view.findViewById(R.id.version_name_text_view);
        mVersionNameTv.setText(mVersionName);
        mCopyrightInfoTv = (TextView) view.findViewById(R.id.copyright_info_text_view);
        refreshCopyrightInfoTv();
        return view;
    }

    @Override
    protected void initListener() {
        // if((START_TIME_MS+LIFE_CYCLE_MS)>=System.currentTimeMillis()) {
        mHandler.sendEmptyMessageDelayed(GO_HOME, START_TO_HOME_DELAY_MILLIS);
            /*}else {
                LogUtil.i(TAG,"已过试用时期");
            }*/


    }

    private void goGuide() {

    }

    private void goLogin() {

    }

    private void goHome() {
        MainActivity.launch(getActivity());
        getActivity().finish();
    }

    private void refreshCopyrightInfoTv() {
        int theYearOfBirthday = Integer.valueOf(getContext().getString(
                R.string.the_year_of_the_birthday));
        int theCurrentYear = TimeUtil.getYear();
        theCurrentYear = (theCurrentYear > theYearOfBirthday) ? (theCurrentYear)
                : (theYearOfBirthday);
        String copyrightInfo = getContext().getString(R.string.copyright_info,
                theYearOfBirthday, theCurrentYear);
        mCopyrightInfoTv.setText(copyrightInfo);
    }

}
