package com.handsomezhou.demo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.commontools.util.LogUtil;
import com.android.commontools.util.SharedPreferencesUtil;
import com.handsomezhou.demo.AppApplication;
import com.handsomezhou.demo.Interface.OnTabChange;
import com.handsomezhou.demo.R;
import com.handsomezhou.demo.adapter.PartnerViewPagerAdapter;
import com.handsomezhou.demo.model.IconButtonData;
import com.handsomezhou.demo.model.IconButtonValue;
import com.handsomezhou.demo.model.PartnerView;
import com.handsomezhou.demo.view.BottomTabView;
import com.handsomezhou.demo.view.CustomViewPager;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public class MainFragment extends BaseFragment implements OnTabChange {
    private static final String TAG="MainFragment";
    private static long lastToastTimeMs=0;
    public enum BOTTOM_TAB_TAG{
        /**
         * 主页
         */
        HOME_PAGE,



        /**
         * 更多
         */
        MORE,
    }

    private List<PartnerView> mMainPartnerViews;
    private BottomTabView mBottomTabView;
    private CustomViewPager mCustomViewPager;
    private PartnerViewPagerAdapter mPartnerViewPagerAdapter;
    private int mCurrentFragmentIndex;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshFragment(getCurrentFragmentIndex());

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(null!=mMainPartnerViews) {
            PartnerView partnerView = mMainPartnerViews.get(getCurrentFragmentIndex());
            if(null!=partnerView) {
                Fragment fragment = partnerView.getFragment();
                if(null!=fragment) {
                    fragment.onActivityResult(requestCode, resultCode, data);
                }
            }
        }

        //super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    protected void initData() {

        setContext(getActivity());
        mMainPartnerViews=new ArrayList<PartnerView>();



        /**
         * start: HOME_PAGE
         */
        HomePageFragment homePageFragment=new HomePageFragment();
        PartnerView homePageView=new PartnerView(BOTTOM_TAB_TAG.HOME_PAGE, homePageFragment);
        mMainPartnerViews.add(homePageView);
        /**
         * end: HOME_PAGE
         */




        /**
         * start:MORE
         */
        PartnerView moreView=new PartnerView(BOTTOM_TAB_TAG.MORE, new MoreFragment());
        mMainPartnerViews.add(moreView);
        /**
         * end:MORE
         */

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_main, container, false);


        mCustomViewPager=(CustomViewPager) view.findViewById(R.id.custom_view_pager);
        mCustomViewPager.setPagingEnabled(true);
        mCustomViewPager.setOffscreenPageLimit(mMainPartnerViews.size());

        mBottomTabView=(BottomTabView)view.findViewById(R.id.bottom_tab_view);
        mBottomTabView.removeAllViews();

        /**
         * start:HOME_PAGE
         */
        IconButtonValue homePageIconBtnValue=new IconButtonValue(BOTTOM_TAB_TAG.HOME_PAGE,R.mipmap.home_page_icon_selected_unfocused, R.mipmap.home_page_icon_unselected, R.string.home_page);
        IconButtonData homePageIconBtnData=new IconButtonData(getContext(), homePageIconBtnValue);
        mBottomTabView.addIconButtonData(homePageIconBtnData);
        /**
         * end:HOME_PAGE
         */



        /**
         * start:MORE
         */
        IconButtonValue moreIconBtnValue=new IconButtonValue(BOTTOM_TAB_TAG.MORE,R.mipmap.more_icon_selected_unfocused, R.mipmap.more_icon_unselected, R.string.more);
        IconButtonData moreIconBtnData=new IconButtonData(getContext(), moreIconBtnValue);
        mBottomTabView.addIconButtonData(moreIconBtnData);
        /**
         * end:MORE
         */


        mBottomTabView.setOnTabChange(this);
        return view;
    }

    @Override
    protected void initListener() {
        FragmentManager fm = getChildFragmentManager();
        mPartnerViewPagerAdapter=new PartnerViewPagerAdapter(fm, mMainPartnerViews);
        mCustomViewPager.setAdapter(mPartnerViewPagerAdapter);
        int item=SharedPreferencesUtil.getInt(AppApplication.getContext(),TAG,0);
        if(item>=mMainPartnerViews.size()){
            item=mMainPartnerViews.size()-1;
        }

        mCustomViewPager.setCurrentItem(item);
        setCurrentFragmentIndex(item);

        PartnerView partnerView=mMainPartnerViews.get(item);
        mBottomTabView.setCurrentTabItem(partnerView.getTag());

        mCustomViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int pos) {

                PartnerView partnerView=mMainPartnerViews.get(pos);
                //Toast.makeText(getContext(),addressBookView.getTag().toString()+"+++" , Toast.LENGTH_LONG).show();
                mBottomTabView.setCurrentTabItem(partnerView.getTag());
                setCurrentFragmentIndex(pos);
                //refreshFragment(pos);
            }

            @Override
            public void onPageScrolled(int pos, float posOffset, int posOffsetPixels) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    /*start: OnTabChange*/
    @Override
    public void onChangeToTab(Object fromTab, Object toTab, TAB_CHANGE_STATE tabChangeState) {
        int item=getPartnerViewItem(mMainPartnerViews,toTab);
        SharedPreferencesUtil.putInt(AppApplication.getContext(),TAG,item);
        mCustomViewPager.setCurrentItem(item);
        refreshFragment(getCurrentFragmentIndex());
        LogUtil.i(TAG,"onChangeToTab "+fromTab.toString()+"to "+toTab.toString()+" "+tabChangeState.toString());
    }

    @Override
    public void onClickTab(Object currentTab, TAB_CHANGE_STATE tabChangeState) {
        LogUtil.i(TAG,"onClickTab "+currentTab.toString()+" "+tabChangeState.toString());

    }
    /*end: OnTabChange*/

    public boolean onKeyDown(int keycode, KeyEvent e){
        //LogUtil.i(TAG,"keycode["+keycode+"] "+e.toString());
        switch(keycode) {
            case KeyEvent.KEYCODE_MENU:
                LogUtil.i(TAG,"keycode["+keycode+"] ==KEYCODE_MENU"+e.toString());

                break;
           /* case KeyEvent.KEYCODE_HOME:
                LogUtil.i(TAG,"keycode["+keycode+"] ==KEYCODE_HOME"+e.toString());
                PortalActivity.launch(getContext());
                break;*/
            default:
                break;
        }

        return true;
    }


    private void refreshFragment(int pageSelectedPos){
        if(pageSelectedPos>=0&&pageSelectedPos<mMainPartnerViews.size()){
            Fragment fragment=mPartnerViewPagerAdapter.getItem(pageSelectedPos);
            if(null!=fragment){
                if(fragment instanceof HomePageFragment){
                    ((HomePageFragment) fragment).refreshFragment();
                }else if(fragment instanceof MoreFragment){
                    ((MoreFragment) fragment).refreshFragment();
                }
            }
        }
    }

/*    public void onReceiveBroadcast(Msg msg){
        do{
            if(null==msg){
                break;
            }

            int pageSelectedPos=getCurrentFragmentIndex();
            if(pageSelectedPos>=0&&pageSelectedPos<mMainPartnerViews.size()){
                Fragment fragment=mPartnerViewPagerAdapter.getItem(pageSelectedPos);
                if(null!=fragment){
                    if(fragment instanceof HomePageFragment){
                        //((HomePageFragment) fragment).onReceiveBroadcast(msg);
                    }else if(fragment instanceof MoreFragment){
                        //((MoreFragment) fragment).onReceiveBroadcast(msg);
                    }
                }
            }

        }while (false);
        return;
    }*/
    public int getCurrentFragmentIndex() {
        return mCurrentFragmentIndex;
    }

    public void setCurrentFragmentIndex(int currentFragmentIndex) {

        mCurrentFragmentIndex = currentFragmentIndex;

    }



    public static int getPartnerViewItem(List<PartnerView> partnerViews, Object tag){
        int item=0;;
        do{
            if((null==partnerViews)||(null==tag)){
                break;
            }

            for(int i=0; i<partnerViews.size();i++){
                if(partnerViews.get(i).getTag().equals(tag)){
                    item=i;
                    break;
                }
            }
        }while(false);

        return item;
    }

    private void refreshView(){
        refreshFragment(getCurrentFragmentIndex());
        return;
    }

}
