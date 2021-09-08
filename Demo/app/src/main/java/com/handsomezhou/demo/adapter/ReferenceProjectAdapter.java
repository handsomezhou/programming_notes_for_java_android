package com.handsomezhou.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.commontools.constant.Constant;
import com.handsomezhou.demo.R;
import com.handsomezhou.demo.model.ProjectInfo;

import java.util.List;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public class ReferenceProjectAdapter extends ArrayAdapter<ProjectInfo> {
	private Context mContext;
	private int mLayoutResId;
	
	public ReferenceProjectAdapter(Context context, int layoutResId,
                                   List<ProjectInfo> objects) {
		super(context, layoutResId, objects);
		mContext=context;
		mLayoutResId = layoutResId;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view=null;
		ViewHolder viewHolder;
		ProjectInfo projectInfo=getItem(position);
		if(null==convertView){
			view=LayoutInflater.from(mContext).inflate(mLayoutResId, null);
			viewHolder=new ViewHolder();
			viewHolder.mIndexTv=(TextView)view.findViewById(R.id.index_text_view);
			viewHolder.mProjectNameTv=(TextView)view.findViewById(R.id.project_name_text_view);
			viewHolder.mProjectAddressTv=(TextView)view.findViewById(R.id.project_address_text_view);
			view.setTag(viewHolder);
		}else{
			view=convertView;
			viewHolder=(ViewHolder)view.getTag();
		}

		viewHolder.mIndexTv.setText(Constant.NULL_STRING+(position+1));
		viewHolder.mProjectNameTv.setText(projectInfo.getProjectName());
		viewHolder.mProjectAddressTv.setText(projectInfo.getProjectAddress());
		
		return view;
	}


	private class ViewHolder{
		TextView mIndexTv;
		TextView mProjectNameTv;
		TextView mProjectAddressTv;
	}

}
