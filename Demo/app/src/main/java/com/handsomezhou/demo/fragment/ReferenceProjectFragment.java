package com.handsomezhou.demo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.commontools.util.LogUtil;
import com.android.commontools.util.TimeUtil;
import com.handsomezhou.demo.R;
import com.handsomezhou.demo.adapter.ReferenceProjectAdapter;
import com.handsomezhou.demo.model.ProjectInfo;
import com.handsomezhou.demo.view.NavigationBarLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public class ReferenceProjectFragment extends BaseFragment implements NavigationBarLayout.OnNavigationBarLayout {
    private static final String TAG=ReferenceProjectFragment.class.getSimpleName();

    private NavigationBarLayout mNavigationBarLayout;
    private String mTitle;
    private ListView mReferenceProjectLv;
    private ReferenceProjectAdapter mReferenceProjectAdapter;
    private List<ProjectInfo> mProjectInfo;

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
        mTitle = getContext().getString(R.string.reference_project);
        mProjectInfo=loadReferenceProjectInfo();

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_reference_project, container, false);
        mNavigationBarLayout = (NavigationBarLayout) view
                .findViewById(R.id.navigation_bar_layout);
        mNavigationBarLayout.setOnNavigationBarLayout(this);
        mNavigationBarLayout.setTitle(mTitle);
        mReferenceProjectLv=(ListView)view.findViewById(R.id.reference_project_list_view);
        mReferenceProjectAdapter=new ReferenceProjectAdapter(getContext(), R.layout.project_info_list_item, mProjectInfo);
        mReferenceProjectLv.setAdapter(mReferenceProjectAdapter);

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

    private List<ProjectInfo> loadReferenceProjectInfo(){
        String[] projectInfoItems=getContext().getResources().getStringArray(R.array.reference_project);

        List<ProjectInfo> projectInfos=new ArrayList<ProjectInfo>();

        for(String item:projectInfoItems){
            try {
                JSONObject jsonObject=new JSONObject(item);
                if(null!=jsonObject){
                    ProjectInfo projectInfo=new ProjectInfo();
                    if(jsonObject.has(ProjectInfo.KEY_PROJECT_NAME)){
                        projectInfo.setProjectName(jsonObject.getString(ProjectInfo.KEY_PROJECT_NAME));
                    }

                    if(jsonObject.has(ProjectInfo.KEY_PROJECT_ADDRESS)){
                        projectInfo.setProjectAddress(jsonObject.getString(ProjectInfo.KEY_PROJECT_ADDRESS));
                    }

                    if(jsonObject.has(ProjectInfo.KEY_WHETHER_OPEN_SOURCE)){
                        projectInfo.setWhetherOpenSource(jsonObject.getBoolean(ProjectInfo.KEY_WHETHER_OPEN_SOURCE));
                    }

                    projectInfos.add(projectInfo);

                }


            } catch (JSONException e) {
                LogUtil.i(TAG, TimeUtil.getLogTime()+e.getMessage());

                e.printStackTrace();
            }


        }
        return projectInfos;
    }

}