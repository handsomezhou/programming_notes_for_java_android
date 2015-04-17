package com.handsomezhou.networkdemo.view;

import com.handsomezhou.networkdemo.R;
import com.handsomezhou.networkdemo.util.NetworkHelper;
import com.handsomezhou.networkdemo.util.NetworkUtil;
import com.handsomezhou.networkdemo.util.StringUtil;
import com.handsomezhou.networkdemo.util.NetworkUtil.NETWORK_TYPE;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NetworkStateTipsView extends RelativeLayout {
	private Context mContext;
	private OnNetworkStateTipsView mOnNetworkStateTipsView;
	private View mNetworkStateTipsView;
	/* Start: mNetworkStateTipsView */
	private ImageView mIconIv;
	private TextView mMessageTv;
	private ImageView mArrowIv;

	/* End: mNetworkStateTipsView */

	public NetworkStateTipsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		initData();
		initView();
		initListener();
	}

	public interface OnNetworkStateTipsView {
		void onNetworkStateTipsViewClick();
	}

	public void updateView(){
		//String  networkTypeName = NetworkUtil.getNetWorkTypeName(mContext);
		//updateView(networkType);
		NETWORK_TYPE networkType=NetworkUtil.getNetWorkType(mContext);
		String currentNetworkType=StringUtil.getNetworkType(mContext,networkType);
		String currentCallState=StringUtil.getCallState(mContext, NetworkHelper.getInstance().getCallState());
		mMessageTv.setText(currentNetworkType+";"+currentCallState);
	}
	
	public void updateView(NETWORK_TYPE networkType, int callState) {
		String currentNetworkType=StringUtil.getNetworkType(mContext, networkType);
		String currentCallState=StringUtil.getCallState(mContext, callState);
		mMessageTv.setText(currentNetworkType+";"+currentCallState);
		
	}

	private void gotoSetting() {
		Intent wifiSettingsIntent = new Intent(Settings.ACTION_SETTINGS);
		mContext.startActivity(wifiSettingsIntent);
	}

	public OnNetworkStateTipsView getOnNetworkStateTipsView() {
		return mOnNetworkStateTipsView;
	}

	public void setOnNetworkStateTipsView(
			OnNetworkStateTipsView onNetworkStateTipsView) {
		mOnNetworkStateTipsView = onNetworkStateTipsView;
	}

	public ImageView getIconIv() {
		return mIconIv;
	}

	public void setIconIv(ImageView iconIv) {
		mIconIv = iconIv;
	}

	public TextView getMessageTv() {
		return mMessageTv;
	}

	public void setMessageTv(TextView messageTv) {
		mMessageTv = messageTv;
	}

	public ImageView getArrowIv() {
		return mArrowIv;
	}

	public void setArrowIv(ImageView arrowIv) {
		mArrowIv = arrowIv;
	}

	private void initData() {

		return;
	}

	private void initView() {
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mNetworkStateTipsView = inflater.inflate(R.layout.network_state_tips,
				this);
		mIconIv = (ImageView) mNetworkStateTipsView
				.findViewById(R.id.icon_image_view);
		mMessageTv = (TextView) mNetworkStateTipsView
				.findViewById(R.id.message_text_view);
		mArrowIv = (ImageView) mNetworkStateTipsView
				.findViewById(R.id.arrow_image_view);

		return;
	}

	private void initListener() {
		mNetworkStateTipsView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				clickNetworkStateTipsView();
			}
		});
		return;
	}

	private void clickNetworkStateTipsView() {

		if (null != mOnNetworkStateTipsView) {
			mOnNetworkStateTipsView.onNetworkStateTipsViewClick();
		}

		gotoSetting();
	}

}
