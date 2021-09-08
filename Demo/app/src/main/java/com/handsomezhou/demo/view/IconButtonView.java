package com.handsomezhou.demo.view;



import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.handsomezhou.demo.R;

/**
 * Created by handsomezhou on 2021/9/8.
 */
public class IconButtonView extends RelativeLayout {
	private static final int TITLE_TEXT_VIEW_ID=1;
    private Context mContext;
    private ImageView mIconIv;
    private TextView mTitleTv;
    public static final int TITLE_COLOR = Color.argb(0xFF, 0x32,  0x32,  0x32);
   
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
    	 this.removeAllViews();

		mTitleTv = new TextView(mContext);
		mTitleTv.setId(TITLE_TEXT_VIEW_ID);
        mTitleTv.setTextColor(TITLE_COLOR);
		// mTitleTv.setTextSize(mContext.getResources().getDimension(R.dimen.tab_index_text_size));

		mTitleTv.setGravity(Gravity.CENTER);
		LayoutParams titleTvLp = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		titleTvLp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		titleTvLp.addRule(RelativeLayout.CENTER_HORIZONTAL);
		this.addView(mTitleTv, titleTvLp);

		mIconIv = new ImageView(mContext);

		int layoutWidth = (int) mContext.getResources().getDimension(
				R.dimen.tab_index_icon_width);
		int layoutHeight = (int) mContext.getResources().getDimension(
				R.dimen.tab_index_icon_height);
		/*
		 * int layoutWidth= LayoutParams.WRAP_CONTENT;
		 *  intlayoutHeight=LayoutParams.WRAP_CONTENT;
		 */
		LayoutParams iconIvLp = new LayoutParams(
				layoutWidth, layoutHeight);
		iconIvLp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
		iconIvLp.addRule(RelativeLayout.ABOVE, mTitleTv.getId());
      
         
        this.addView(mIconIv,iconIvLp);
        
        return;
    }
}
