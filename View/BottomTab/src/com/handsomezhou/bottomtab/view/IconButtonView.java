package com.handsomezhou.bottomtab.view;

import com.handsomezhou.bottomtab.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class IconButtonView extends RelativeLayout {
    private Context mContext;
    private ImageView mIconIv;
    private TextView mTitleTv;
   
    public IconButtonView(Context context) {
        super(context);
        mContext=context;
        initView();
    }

    public IconButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        initView();
    }

    public ImageView getIconIv() {
        return mIconIv;
    }

    public void setIconIv(ImageView iconIv) {
        mIconIv = iconIv;
    }

    public TextView getTitleTv() {
        return mTitleTv;
    }

    public void setTitleTv(TextView titleTv) {
        mTitleTv = titleTv;
    }
    
    private void initView(){
      
        
        mTitleTv=new TextView(mContext);
        mTitleTv.setTextSize(mContext.getResources().getDimensionPixelSize(R.dimen.tab_index_text_size));
        
        RelativeLayout.LayoutParams titleTvLp=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        titleTvLp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        titleTvLp.addRule(RelativeLayout.CENTER_HORIZONTAL);
        this.addView(mTitleTv, titleTvLp);
        
        mIconIv=new ImageView(mContext);
        int layoutWidth=(int) mContext.getResources().getDimension(R.dimen.tab_index_icon_width);
        int layoutHeight=(int) mContext.getResources().getDimension(R.dimen.tab_index_icon_height);
        RelativeLayout.LayoutParams iconIvLp=new RelativeLayout.LayoutParams(layoutWidth,layoutHeight);
        iconIvLp.addRule(RelativeLayout.CENTER_HORIZONTAL);
        
        this.removeAllViews();
        this.addView(mTitleTv);
        this.addView(mIconIv);
        return;
    }
}
