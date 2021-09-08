package com.handsomezhou.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;


import com.handsomezhou.demo.Interface.OnTabChange;
import com.handsomezhou.demo.model.IconButtonData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public class BottomTabView extends LinearLayout implements OnClickListener {
    private static final int PADDING_DEFAULT = 0;
    private static final int PADDING_LEFT_DEFAULT = 0;
    private static final int PADDING_TOP_DEFAULT = 0;
    private static final int PADDING_RIGHT_DEFAULT = 0;
    private static final int PADDING_BOTTOM_DEFAULT = 0;

    private static final int MARGIN_DEFAULT = 0;
    private static final int MARGIN_LEFT_DEFAULT = 0;
    private static final int MARGIN_TOP_DEFAULT = 0;
    private static final int MARGIN_RIGHT_DEFAULT = 0;
    private static final int MARGIN_BOTTOM_DEFAULT = 0;


    private Context mContext;
    private List<IconButtonData> mIconButtonData;//data
    private OnTabChange mOnTabChange;
    private Object mCurrentTab = null;
    private int mLastIconResId;

    public BottomTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initData();
        initView();
        initListener();
    }

    /*Start: OnClickListener*/
    @Override
    public void onClick(View v) {

        if (null == v || null == v.getTag()) {
            return;
        }

        Object toTab = v.getTag();
        Object fromTab = getCurrentTab();
        changeToTab(fromTab, toTab);

    }
    /*End: OnClickListener*/

    public void addIconButtonData(IconButtonData iconButtonData) {

        if (null == mIconButtonData) {
            mIconButtonData = new ArrayList<IconButtonData>();
        }

        mIconButtonData.add(iconButtonData);
        addIconButtonView(mIconButtonData.get(mIconButtonData.size() - 1).getIconButtonView());
        setCurrentTab(mIconButtonData.get(0).getIconButtonValue().getTag());
        mIconButtonData.get(0).getIconButtonView().getIconIv().setBackgroundResource(mIconButtonData.get(0).getIconButtonValue().getIconSelectedFocused());
        setLastIconResId(mIconButtonData.get(0).getIconButtonValue().getIconSelectedFocused());

        mIconButtonData.get(mIconButtonData.size() - 1).getIconButtonView().setOnClickListener(this);
        mIconButtonData.get(mIconButtonData.size() - 1).getIconButtonView().setTag(mIconButtonData.get(mIconButtonData.size() - 1).getIconButtonValue().getTag());

        return;
    }

    public void setCurrentTabItem(Object tag) {
        if (null == tag) {
            return;
        }

        setCurrentTab(tag);
        for (IconButtonData ibd : mIconButtonData) {
            if (ibd.getIconButtonValue().getTag().equals(tag)) {
                ibd.getIconButtonView().getIconIv().setBackgroundResource(ibd.getIconButtonValue().getIconSelectedFocused());
                setLastIconResId(ibd.getIconButtonValue().getIconSelectedFocused());
            } else {
                ibd.getIconButtonView().getIconIv().setBackgroundResource(ibd.getIconButtonValue().getIconUnselected());
            }
        }
    }

    public void removeIconButtonData(IconButtonData iconButtonData) {

    }

    public OnTabChange getOnTabChange() {
        return mOnTabChange;
    }

    public void setOnTabChange(OnTabChange onTabChange) {
        mOnTabChange = onTabChange;
    }

    public Object getCurrentTab() {
        return mCurrentTab;
    }

    public void setCurrentTab(Object currentTab) {
        mCurrentTab = currentTab;
    }

    private void initData() {
        mIconButtonData = new ArrayList<IconButtonData>();

        return;
    }

    @SuppressWarnings("static-access")
    private void initView() {
        this.setOrientation(this.HORIZONTAL);
        //this.setPadding(PADDING_LEFT_DEFAULT, PADDING_TOP_DEFAULT, PADDING_RIGHT_DEFAULT, PADDING_BOTTOM_DEFAULT);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        //lp.setMargins(MARGIN_LEFT_DEFAULT, MARGIN_TOP_DEFAULT, MARGIN_RIGHT_DEFAULT, MARGIN_BOTTOM_DEFAULT);

        this.setLayoutParams(lp);


        return;
    }

    private void initListener() {

        return;
    }

    private int getLastIconResId() {
        return mLastIconResId;
    }

    private void setLastIconResId(int lastIconResId) {
        mLastIconResId = lastIconResId;
    }


    private void addIconButtonView(IconButtonView iconButtonView) {
        if (null == iconButtonView) {
            return;
        }
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1.0f);
        lp.setMargins(MARGIN_LEFT_DEFAULT, MARGIN_TOP_DEFAULT, MARGIN_RIGHT_DEFAULT, MARGIN_BOTTOM_DEFAULT);
        iconButtonView.setLayoutParams(lp);
        this.addView(iconButtonView);
    }

    private void changeToTab(Object fromTab, Object toTab) {
        if (fromTab != toTab) {//change tab
            setCurrentTab(toTab);
            if (null != mOnTabChange) {
                mOnTabChange.onChangeToTab(fromTab, toTab, OnTabChange.TAB_CHANGE_STATE.TAB_SELECTED_FOCUSED);
                IconButtonData fromTabIconButtonData = getIconButtonData(fromTab);
                if (null != fromTabIconButtonData) {
                    fromTabIconButtonData.getIconButtonView().getIconIv().setBackgroundResource(fromTabIconButtonData.getIconButtonValue().getIconUnselected());
                }
                IconButtonData toTabIconButtonData = getIconButtonData(toTab);
                if (null != toTabIconButtonData) {
                    toTabIconButtonData.getIconButtonView().getIconIv().setBackgroundResource(toTabIconButtonData.getIconButtonValue().getIconSelectedFocused());
                }

                setLastIconResId(toTabIconButtonData.getIconButtonValue().getIconSelectedFocused());
            }
        } else {//click tab
            if (null != mOnTabChange) {

                IconButtonData toTabIconButtonData = getIconButtonData(toTab);
                if (null != toTabIconButtonData) {
                    if (getLastIconResId() == toTabIconButtonData.getIconButtonValue().getIconSelectedUnfocused()) {
                        toTabIconButtonData.getIconButtonView().getIconIv().setBackgroundResource(toTabIconButtonData.getIconButtonValue().getIconSelectedFocused());
                        setLastIconResId(toTabIconButtonData.getIconButtonValue().getIconSelectedFocused());
                        mOnTabChange.onClickTab(toTab, OnTabChange.TAB_CHANGE_STATE.TAB_SELECTED_FOCUSED);
                    } else {
                        toTabIconButtonData.getIconButtonView().getIconIv().setBackgroundResource(toTabIconButtonData.getIconButtonValue().getIconSelectedUnfocused());
                        setLastIconResId(toTabIconButtonData.getIconButtonValue().getIconSelectedUnfocused());
                        mOnTabChange.onClickTab(toTab, OnTabChange.TAB_CHANGE_STATE.TAB_SELECTED_UNFOCUSED);
                    }
                }
            }

        }
    }

    private IconButtonData getIconButtonData(Object object) {
        IconButtonData iconButtonData = null;
        do {
            if (null == object) {
                break;
            }

            for (IconButtonData ibd : mIconButtonData) {
                if (ibd.getIconButtonValue().getTag().equals(object)) {
                    iconButtonData = ibd;
                    break;
                }
            }
            break;
        } while (false);
        return iconButtonData;
    }
}
