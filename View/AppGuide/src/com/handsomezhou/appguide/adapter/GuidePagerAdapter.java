package com.handsomezhou.appguide.adapter;

import java.util.List;





import com.handsomezhou.appguide.R;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class GuidePagerAdapter extends PagerAdapter {
	private List<View> mViews;
	private Context mContext;
	private OnGuidePagerAdapter mOnGuidePagerAdapter;
	public interface OnGuidePagerAdapter{
		void exitGuidePager();
	}
	
	public GuidePagerAdapter(List<View> views, Context context) {
		mViews = views;
		mContext = context;
		mOnGuidePagerAdapter=null;
	}
	
	public OnGuidePagerAdapter getOnGuidePagerAdapter() {
		return mOnGuidePagerAdapter;
	}

	public void setOnGuidePagerAdapter(OnGuidePagerAdapter onGuidePagerAdapter) {
		mOnGuidePagerAdapter = onGuidePagerAdapter;
	}
	
	
	
	@Override
	public int getCount() {
		if (null != mViews) {
			return mViews.size();
		}

		return 0;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {

		return (view == object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(mViews.get(position));
		if((mViews.size()-1)==position){
			Button enterHomePagerBtn=(Button) container.findViewById(R.id.enter_home_pager_btn);
			enterHomePagerBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					enterhomePager();
				}
			});
		}
		return mViews.get(position);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mViews.get(position));  
	}

	
	private void enterhomePager(){
		if(null!=mOnGuidePagerAdapter){
			mOnGuidePagerAdapter.exitGuidePager();
		}
	}
	

}
