package com.handsomezhou.demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handsomezhou.demo.dialog.BaseProgressDialog;
import com.handsomezhou.demo.util.ViewUtil;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public abstract class BaseFragment extends Fragment {
	private Context mContext;
	private boolean mHideImeTouchOutsideEditText=true;
	private BaseProgressDialog mBaseProgressDialog;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
	
		View view =initView(inflater,container);
		if(isHideImeTouchOutsideEditText()){
            ViewUtil.setHideIme(getActivity(), view);
        }
		
		initListener();
		
		return view;
	}

	/**
	 * init data in onCreate()
	 * 
	 * initData()->initView()->initListener()
	 */
	protected abstract void initData();
	
	/**
	 * init view in onCreate()
	 * 
	 * initData()->initView()->initListener()
	 * @return 
	 */
	protected abstract View initView(LayoutInflater inflater, ViewGroup container);
		
	
	/**
	 * init Listener in onCreate()
	 * 
	 * initData()->initView()->initListener()
	 */
	protected abstract void initListener();

	@Override
	public Context getContext() {
		return mContext;
	}

	public void setContext(Context context) {
		mContext = context;
	}
	
    public boolean isHideImeTouchOutsideEditText() {
        return mHideImeTouchOutsideEditText;
    }

    public void setHideImeTouchOutsideEditText(boolean hideImeTouchOutsideEditText) {
        mHideImeTouchOutsideEditText = hideImeTouchOutsideEditText;
    }

	public BaseProgressDialog getBaseProgressDialog() {
		if (null == mBaseProgressDialog) {
			if(null==getContext()){
				if(null!=getActivity()){
					setContext(getActivity());
				}else {
					return null;
				}
			}
			mBaseProgressDialog = new BaseProgressDialog(getContext());
			mBaseProgressDialog.setCanceledOnTouchOutside(true);
		}
		return mBaseProgressDialog;
	}

	public void setBaseProgressDialog(BaseProgressDialog baseProgressDialog) {
		mBaseProgressDialog = baseProgressDialog;
	}
}
