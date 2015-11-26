package com.handsomezhou.futurerecenttimeselect.activity;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.handsomezhou.futurerecenttimeselect.model.TimeItemIndex;
import com.handsomezhou.futurerecenttimeselect.util.TimeItemUtil;
import com.handsomezhou.futurerecenttimeselect.util.ViewUtil;
import com.handsomezhou.futurerecenttimeselect.view.FutureRecentTimeSelectView;
import com.handsomezhou.futurerecenttimeselect.view.FutureRecentTimeSelectView.OnFutureRecentTimeSelectView;
import com.handsomezhou.futurerecenttimeselectview.R;

public class MainActivity extends Activity implements OnFutureRecentTimeSelectView{
	private Context mContext;
	private Button mFutureRecentTimeSelectBtn;
	private FutureRecentTimeSelectView mFutureRecentTimeSelectView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initView();
		initListener();
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
		mFutureRecentTimeSelectView.updateView();
	}


	/*Start: OnFutureRecentTimeSelectView*/
	@Override
	public void onFutureRecentTimeSelectViewCancel() {
		ViewUtil.hideView(mFutureRecentTimeSelectView);
		
	}

	@Override
	public void onFutureRecentTimeSelectViewOk(TimeItemIndex timeItemIndex) {
		futureRecentTimeSelectViewOk(timeItemIndex);
	}

	@Override
	public void onTimeChanged(TimeItemIndex timeItemIndex) {
		// TODO Auto-generated method stub
		
	}
	
	/*End: OnFutureRecentTimeSelectView*/
	
	private void initData(){
		mContext=this;
		
		return;
	}
	
	private void initView(){
		mFutureRecentTimeSelectBtn=(Button)findViewById(R.id.future_recent_time_select_btn);
		mFutureRecentTimeSelectView=(FutureRecentTimeSelectView) findViewById(R.id.future_recent_time_select_view);
		mFutureRecentTimeSelectView.setOnFutureRecentTimeSelectView(this);
		return;
	}
	
	private void initListener(){
		mFutureRecentTimeSelectBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clickFutureRecentTimeSelect();
			}
		});
	}
	
	private void clickFutureRecentTimeSelect(){
		ViewUtil.showView(mFutureRecentTimeSelectView);
		//Toast.makeText(mContext, "clickFutureRecentTimeSelect", Toast.LENGTH_SHORT).show();
		return;
	}
	
	@SuppressLint("SimpleDateFormat")
	private void futureRecentTimeSelectViewOk(TimeItemIndex timeItemIndex){
		if(null==timeItemIndex){
			return;
		}
		
		long timeMillis=TimeItemUtil.getTimeMillis(timeItemIndex);
		Date date=new Date(timeMillis);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(date);
		
		Toast.makeText(mContext,timeItemIndex.getDayItemIndex()+";"+timeItemIndex.getHourItemIndex()+";"+timeItemIndex.getMinuteItemIndex()+"time["+time+"]", Toast.LENGTH_SHORT).show();
		
		ViewUtil.hideView(mFutureRecentTimeSelectView);
	}
}
