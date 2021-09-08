package com.handsomezhou.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.commontools.constant.Constant;
import com.android.commontools.util.CommonUtil;
import com.handsomezhou.demo.R;
import com.handsomezhou.demo.model.VersionInfo;
import com.handsomezhou.demo.util.ViewUtil;


import java.util.List;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public class VersionInfoAdapter extends ArrayAdapter<VersionInfo> {
	private Context mContext;
	private int mLayoutResId;
	
	public VersionInfoAdapter(Context context, int layoutResId, List<VersionInfo> objects) {
		super(context, layoutResId, objects);
		mContext=context;
		mLayoutResId = layoutResId;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view=null;
		ViewHolder viewHolder;
		VersionInfo versionInfo=getItem(position);
		if(null==convertView){
			view=LayoutInflater.from(mContext).inflate(mLayoutResId, null);
			viewHolder=new ViewHolder();
			viewHolder.mVersionNameTv=(TextView)view.findViewById(R.id.version_name_text_view);
			viewHolder.mUpgradeInfoTv=(TextView)view.findViewById(R.id.upgrade_info_text_view);
			viewHolder.mRemarkTv=(TextView)view.findViewById(R.id.remark_text_view);
			view.setTag(viewHolder);
		}else{
			view=convertView;
			viewHolder=(ViewHolder)view.getTag();
		}
		
		viewHolder.mVersionNameTv.setText(Constant.NULL_STRING+versionInfo.getId()+ Constant.SPACE+ Constant.SPACE+ Constant.V+versionInfo.getVersionName());
		viewHolder.mUpgradeInfoTv.setText(versionInfo.getUpgradeInfo());
		if(false== CommonUtil.isEmpty(versionInfo.getRemark())) {
			ViewUtil.showView(viewHolder.mRemarkTv);
			viewHolder.mRemarkTv.setText(versionInfo.getRemark());
		}else {
			ViewUtil.hideView(viewHolder.mRemarkTv);
		}

		return view;
	}


	private class ViewHolder{
		TextView mVersionNameTv;
		TextView mUpgradeInfoTv;
		TextView mRemarkTv;
	}

}
