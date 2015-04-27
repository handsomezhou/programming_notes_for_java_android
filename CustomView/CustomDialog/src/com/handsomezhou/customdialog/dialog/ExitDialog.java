package com.handsomezhou.customdialog.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.handsomezhou.customdialog.R;

public class ExitDialog extends BaseDialog{
	
	private OnExitDialog mOnExitDialog;
	
	//Start: mExitDialog Data
	private int mIcon;
	private String mTitle;
	private String mMessage;
	private String mOk;
	private String mCancel;
	//End: mExitDialog Data
	
	private View mExitDialogLayout;

	//Start: mExitDialog View
	private ImageView mIconIv;
	private TextView mTitleTv;
	private TextView mMessageTv;
	private Button mOkBtn;
	private Button mCancelBtn;
	//End: mExitDialog View
	

	public ExitDialog(Context context) {
		super(context);
		initData();
		initListener();
	}

	public interface OnExitDialog{
		void onExitDialogOk();
		void onExitDialogCancel();
	}
	
	/*Start : BaseDialog*/
	@Override
	protected View getView() {
		return initView();
	}	
	/*End : BaseDialog*/
	
	public OnExitDialog getOnExitDialog() {
		return mOnExitDialog;
	}

	public void setOnExitDialog(OnExitDialog onExitDialog) {
		mOnExitDialog = onExitDialog;
	}

	
	
	public int getIcon() {
		return mIcon;
	}

	public void setIcon(int icon) {
		mIcon = icon;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}
	
	public String getMessage() {
		return mMessage;
	}

	public void setMessage(String message) {
		mMessage = message;
	}

	public String getOk() {
		return mOk;
	}

	public void setOk(String ok) {
		mOk = ok;
	}

	public String getCancel() {
		return mCancel;
	}

	public void setCancel(String cancel) {
		mCancel = cancel;
	}

	public View getExitDialogLayout() {
		return mExitDialogLayout;
	}

	public void setExitDialogLayout(View exitDialogLayout) {
		mExitDialogLayout = exitDialogLayout;
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

	public TextView getMessageTv() {
		return mMessageTv;
	}

	public void setMessageTv(TextView messageTv) {
		mMessageTv = messageTv;
	}

	public Button getOkBtn() {
		return mOkBtn;
	}

	public void setOkBtn(Button okBtn) {
		mOkBtn = okBtn;
	}

	public Button getCancelBtn() {
		return mCancelBtn;
	}

	public void setCancelBtn(Button cancelBtn) {
		mCancelBtn = cancelBtn;
	}

	private void initData() {

		return;
	}

	private View initView() {
		LayoutInflater inflater = LayoutInflater.from(getContext());
		setExitDialogLayout(inflater.inflate(R.layout.dialog_exit, null));
		setIconIv((ImageView)getExitDialogLayout().findViewById(R.id.icon_image_view));
		setTitleTv((TextView)getExitDialogLayout().findViewById(R.id.title_text_view));
		setMessageTv((TextView)getExitDialogLayout().findViewById(R.id.message_text_view));
		setOkBtn((Button)getExitDialogLayout().findViewById(R.id.ok_btn));
		setCancelBtn((Button)getExitDialogLayout().findViewById(R.id.cancel_btn));
		
		return getExitDialogLayout();
	}

	private void initListener() {
		mOkBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clickOkBtn();
			}
		});
		
		mCancelBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clickCancelBtn();
			}
		});
		
		return;
	}
	
	private void clickOkBtn(){
		
		if(null!=mOnExitDialog){
			mOnExitDialog.onExitDialogOk();
		}
		getAlertDialog().dismiss();
		
		return;
	}
	
	private void clickCancelBtn(){
		
		if(null!=mOnExitDialog){
			mOnExitDialog.onExitDialogCancel();
		}
		
		getAlertDialog().dismiss();
		
		return;
	}

	
}
