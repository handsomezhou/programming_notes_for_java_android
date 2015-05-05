package com.handsomezhou.fragmentdemo.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.handsomezhou.fragmentdemo.R;
import com.handsomezhou.fragmentdemo.model.IconButtonData;

public class GridViewAdapter extends ArrayAdapter<IconButtonData> {
    private Context mContext;
    private int mTextViewResourceId;
    private List<IconButtonData> mIconButtonDatas;
    
    public GridViewAdapter(Context context, int textViewResourceId, List<IconButtonData> iconButtonDatas) {
        super(context, textViewResourceId, iconButtonDatas);
        mContext=context;
        mTextViewResourceId=textViewResourceId;
        mIconButtonDatas=iconButtonDatas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        ViewHolder viewHolder;
        IconButtonData iconButtonData=getItem(position);
        if(null==convertView){
            view=LayoutInflater.from(mContext).inflate(mTextViewResourceId, null);
            viewHolder=new ViewHolder();
            viewHolder.mIconIv=(ImageView) view.findViewById(R.id.icon_image_view);
            viewHolder.mTitleTv=(TextView)view.findViewById(R.id.title_text_view);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.mIconIv.setBackgroundResource(iconButtonData.getIconButtonValue().getIconUnselected());
        viewHolder.mTitleTv.setText(iconButtonData.getIconButtonValue().getText());
        return view;
    }
    
    private class ViewHolder{
       ImageView mIconIv;
       TextView mTitleTv;
    }
}
