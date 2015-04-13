package com.handsomezhou.customdialog.activity;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.customdialog.R;
import com.handsomezhou.customdialog.dialog.ExitDialog;
import com.handsomezhou.customdialog.dialog.ExitDialog.OnExitDialog;

public class MainActivity extends Activity implements OnExitDialog{
	private Context mContext;
	private Button mExitDialogBtn;
	private ExitDialog mExitDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initView();
		initListener();
	}

	@Override
	public void onBackPressed() {
		//super.onBackPressed();
		clickExitDialog();
	}

	
	/*Start:OnExitDialog*/
	@Override
	public void onExitDialogOk() {
		Toast.makeText(mContext, "onOk", Toast.LENGTH_SHORT).show();
		this.finish();
	}

	@Override
	public void onExitDialogCancel() {
		Toast.makeText(mContext, "onCancel", Toast.LENGTH_SHORT).show();
	}
	/*End:OnExitDialog*/
	
	private void initData(){
		mContext=this;
		mExitDialogBtn=(Button) findViewById(R.id.exit_dialog_btn);
		
		return;
	}
	
	private void initView(){
		
		mExitDialog=new ExitDialog(mContext);
		mExitDialog.setOnExitDialog(this);
		
		return;
	}
	
	private void initListener(){
		mExitDialogBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clickExitDialog();
			}
		});
		return;
	}
	
	private void clickExitDialog(){
		if(mExitDialog.getAlertDialog().isShowing()){
			mExitDialog.getAlertDialog().hide();
		}else{
			mExitDialog.getAlertDialog().show();
		}
	}

	

}
