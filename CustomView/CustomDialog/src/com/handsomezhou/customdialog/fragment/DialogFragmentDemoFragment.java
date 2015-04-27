package com.handsomezhou.customdialog.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.customdialog.R;
import com.handsomezhou.customdialog.dialog.ExitDialogFragment;
import com.handsomezhou.customdialog.dialog.ExitDialogFragment.OnExitDialog;

public class DialogFragmentDemoFragment extends BaseFragment implements OnExitDialog{
	private Button mDialogFragmentDemoBtn;
	private ExitDialogFragment mExitDialog;
	
	@Override
	protected void initData() {
		setContext(getActivity());

	}

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		View view=inflater.inflate(R.layout.fragment_dialog_fragment_demo, container, false);
		mDialogFragmentDemoBtn=(Button) view.findViewById(R.id.dialog_fragment_demo_btn);
		mExitDialog = new ExitDialogFragment(getContext());
		mExitDialog.setOnExitDialog(this);
		mExitDialog.getAlertDialog().show();
		return view;
	}

	@Override
	protected void initListener() {
		mDialogFragmentDemoBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clickExitDialog();
			}
		});

	}

	/*Start: OnExitDialog*/
	@Override
	public void onExitDialogOk() {
		Toast.makeText(getContext(), "onOk", Toast.LENGTH_SHORT).show();
		getActivity().finish();
		
	}

	@Override
	public void onExitDialogCancel() {
		Toast.makeText(getContext(), "onCancel", Toast.LENGTH_SHORT).show();
		
	}
	/*End: OnExitDialog*/
	
	public void clickExitDialog() {
		if (mExitDialog.getAlertDialog().isShowing()) {
			mExitDialog.getAlertDialog().hide();
		} else {
			mExitDialog.getAlertDialog().show();
		}
	}

}
