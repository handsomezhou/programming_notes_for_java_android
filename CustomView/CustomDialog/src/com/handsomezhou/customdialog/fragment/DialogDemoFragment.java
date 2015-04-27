package com.handsomezhou.customdialog.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.customdialog.R;
import com.handsomezhou.customdialog.dialog.ExitDialog;
import com.handsomezhou.customdialog.dialog.ExitDialog.OnExitDialog;

public class DialogDemoFragment extends BaseFragment implements OnExitDialog {
	private Button mDialogDemoBtn;
	private ExitDialog mExitDialog;

	@Override
	protected void initData() {
		setContext(getActivity());//must not be getActivity().getApplicationContext()

	}

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.fragment_dialog_demo, container,
				false);
		mDialogDemoBtn = (Button) view.findViewById(R.id.dialog_demo_btn);
		mExitDialog = new ExitDialog(getContext());
		mExitDialog.setOnExitDialog(this);
		mExitDialog.getAlertDialog().show();

		return view;
	}

	@Override
	protected void initListener() {
		mDialogDemoBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				clickExitDialog();
			}
		});
		return;

	}

	/* Start: OnExitDialog */
	@Override
	public void onExitDialogOk() {
		Toast.makeText(getContext(), "onOk", Toast.LENGTH_SHORT).show();
		getActivity().finish();

	}

	@Override
	public void onExitDialogCancel() {
		Toast.makeText(getContext(), "onCancel", Toast.LENGTH_SHORT).show();

	}

	/* END: OnExitDialog */
	private void clickExitDialog() {
		if (mExitDialog.getAlertDialog().isShowing()) {
			mExitDialog.getAlertDialog().hide();
		} else {
			mExitDialog.getAlertDialog().show();
		}
	}
}
