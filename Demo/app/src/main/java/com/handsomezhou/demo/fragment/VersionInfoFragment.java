package com.handsomezhou.demo.fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.commontools.util.LogUtil;
import com.android.commontools.util.TimeUtil;
import com.handsomezhou.demo.R;
import com.handsomezhou.demo.adapter.VersionInfoAdapter;
import com.handsomezhou.demo.model.VersionInfo;
import com.handsomezhou.demo.view.NavigationBarLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public class VersionInfoFragment extends BaseFragment implements NavigationBarLayout.OnNavigationBarLayout {
    private static final String TAG=VersionInfoFragment.class.getSimpleName();

    private NavigationBarLayout mNavigationBarLayout;
    private String mTitle;
    private ListView mVersionInfoLv;
    private VersionInfoAdapter mVersionInfoAdapter;
    private List<VersionInfo> mVersionInfos;

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
        mTitle = getContext().getString(R.string.version_info);
        mVersionInfos=loadVersionInfo();
        Collections.sort(mVersionInfos, VersionInfo.mSortByIdDes);
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_version_info, container, false);
        mNavigationBarLayout = (NavigationBarLayout) view
                .findViewById(R.id.navigation_bar_layout);
        mNavigationBarLayout.setOnNavigationBarLayout(this);
        mNavigationBarLayout.setTitle(mTitle);
        mVersionInfoLv=(ListView)view.findViewById(R.id.version_info_list_view);
        mVersionInfoAdapter=new VersionInfoAdapter(getContext(), R.layout.version_info_list_item, mVersionInfos);
        mVersionInfoLv.setAdapter(mVersionInfoAdapter);

        return view;
    }

    @Override
    protected void initListener() {


    }

    @Override
    public void onBack() {
        back();
    }

    private void back(){
        getActivity().finish();
    }

    private List<VersionInfo> loadVersionInfo(){
        String[] versionInfoItems=getContext().getResources().getStringArray(R.array.version_info);

        List<VersionInfo> versionInfos=new ArrayList<VersionInfo>();

        for(String item:versionInfoItems){
            try {
                JSONObject jsonObject=new JSONObject(item);
                if(null!=jsonObject){
                    VersionInfo versionInfo=new VersionInfo();
                    if(jsonObject.has(VersionInfo.KEY_ID)){
                        versionInfo.setId(jsonObject.getLong(VersionInfo.KEY_ID));
                    }

                    if(jsonObject.has(VersionInfo.KEY_VERSION_CODE)){
                        versionInfo.setVersionCode(jsonObject.getString(VersionInfo.KEY_VERSION_CODE));
                    }

                    if(jsonObject.has(VersionInfo.KEY_VERSION_NAME)){
                        versionInfo.setVersionName(jsonObject.getString(VersionInfo.KEY_VERSION_NAME));
                    }

                    if(jsonObject.has(VersionInfo.KEY_UPGRADE_INFO)){
                        versionInfo.setUpgradeInfo(jsonObject.getString(VersionInfo.KEY_UPGRADE_INFO));
                    }

                    if(jsonObject.has(VersionInfo.KEY_REMARK)){
                        versionInfo.setRemark(jsonObject.getString(VersionInfo.KEY_REMARK));
                    }

                    versionInfos.add(versionInfo);

                }


            } catch (JSONException e) {
                LogUtil.i(TAG, TimeUtil.getLogTime()+e.getMessage());
                e.printStackTrace();
            }


        }
        return versionInfos;
    }


}

