package com.handsomezhou.futurerecenttimeselect.view;

import com.handsomezhou.futurerecenttimeselect.view.FutureRecentTimeView.OnFutureRecentTimeView;
import com.handsomezhou.futurerecenttimeselectview.R;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FutureRecentTimeSelectView extends LinearLayout implements OnFutureRecentTimeView{
	private static final String TAG="FutureRecentTimeSelectView";
	private Context mContext;
	private OnFutureRecentTimeSelectView mOnFutureRecentTimeSelectView;
	private View mFutureRecentTimeSelectView;
	/*Start: mFutureRecentTimeSelectView*/
	private Button mOkBtn;
	private Button mCancelBtn;
	private FutureRecentTimeView mFutureRecentTimeView;
	/*End: mFutureRecentTimeSelectView*/
	
	public FutureRecentTimeSelectView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		initData();
		initView();
		initListener();
	}

	public interface OnFutureRecentTimeSelectView{
		void onFutureRecentTimeSelectViewCancel();
		void onFutureRecentTimeSelectViewOk(int dayValue,int hourValue,int minuteValue);
		void onTimeChanged(int dayValue,int hourValue,int minuteValue);
	}
	
	/*Start: OnFutureRecentTimeView*/
	@Override
	public void onTimeChanged(int dayValue, int hourValue, int minuteValue) {
		Log.i(TAG,"dayValue["+dayValue+"]hourValue["+ hourValue+"]minuteValue["+minuteValue+"]");
		if(null!=mOnFutureRecentTimeSelectView){
			mOnFutureRecentTimeSelectView.onTimeChanged(dayValue, hourValue, minuteValue);
		}
	}
	/*End: OnFutureRecentTimeView*/
	
	public OnFutureRecentTimeSelectView getOnFutureRecentTimeSelectView() {
		return mOnFutureRecentTimeSelectView;
	}

	public void setOnFutureRecentTimeSelectView(OnFutureRecentTimeSelectView onFutureRecentTimeSelectView) {
		this.mOnFutureRecentTimeSelectView = onFutureRecentTimeSelectView;
	}
	
	public void updateView(){
		mFutureRecentTimeView.updateView();
		return;
	}
	
	private void initData() {

		return;
	}

	private void initView() {
		LayoutInflater inflater=(LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mFutureRecentTimeSelectView = inflater.inflate(R.layout.future_recent_time_select_layout,this);
		mFutureRecentTimeView=(FutureRecentTimeView) mFutureRecentTimeSelectView.findViewById(R.id.future_recent_time_view);
		mFutureRecentTimeView.setOnFutureRecentTimeView(this);
		mOkBtn=(Button) mFutureRecentTimeSelectView.findViewById(R.id.ok_btn);
		mCancelBtn=(Button) mFutureRecentTimeSelectView.findViewById(R.id.cancel_btn);
		
		return;
	}

	private void initListener() {
		mOkBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clickOk();
			}
		});
		
		mCancelBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clickCancel();
			}
		});
	}
	
	private void clickOk(){
		if(null!=mOnFutureRecentTimeSelectView){
			
			int dayValue=mFutureRecentTimeView.getDayValue();
			int hourValue=mFutureRecentTimeView.getHourValue();
			int minuteValue=mFutureRecentTimeView.getMinuteValue();
			
			mOnFutureRecentTimeSelectView.onFutureRecentTimeSelectViewOk(dayValue, hourValue, minuteValue);
		}
		
		return;
	}
	
	private void clickCancel(){
		if(null!=mOnFutureRecentTimeSelectView){
			mOnFutureRecentTimeSelectView.onFutureRecentTimeSelectViewCancel();
		}
		
		return;
	}
}
