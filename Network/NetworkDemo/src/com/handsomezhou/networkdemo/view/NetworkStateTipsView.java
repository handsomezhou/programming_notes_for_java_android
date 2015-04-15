package com.handsomezhou.networkdemo.view;

import com.handsomezhou.networkdemo.R;
import com.handsomezhou.networkdemo.util.NetworkUtil;
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
		String  networkTypeName = NetworkUtil.getNetWorkTypeName(mContext);
		//updateView(networkType);
		mMessageTv.setText(networkTypeName);
	}
	public void updateView(NETWORK_TYPE networkType) {
		String currentNetworkType=(String) mContext.getText(R.string.current_network_type);
		switch (networkType) {
		case NETWORKTYPE_INVALID:
			mMessageTv.setText(currentNetworkType+mContext.getText(R.string.network_type_invalid));
			break;

		case NETWORKTYPE_2G:
			mMessageTv.setText(currentNetworkType+mContext.getText(R.string.network_type_2g));
			break;

		case NETWORKTYPE_3G:
			mMessageTv.setText(currentNetworkType+mContext
					.getText(R.string.network_type_3g));
			break;

		case NETWORKTYPE_4G_NO_LESS:
			mMessageTv.setText(currentNetworkType+mContext
					.getText(R.string.network_type_4g_no_less));
			break;
		case NETWORKTYPE_WIFI:
			mMessageTv.setText(mContext.getText(R.string.network_type_wifi));
			break;

		default:
			mMessageTv.setText(currentNetworkType+mContext.getText(R.string.network_type_unknow));

			break;
		}
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
