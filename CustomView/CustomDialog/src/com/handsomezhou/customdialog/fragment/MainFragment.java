
package com.handsomezhou.customdialog.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.handsomezhou.customdialog.R;
import com.handsomezhou.customdialog.activity.DialogDemoActivity;
import com.handsomezhou.customdialog.activity.DialogFragmentDemoActivity;
import com.handsomezhou.customdialog.activity.ProgressDialogDemoActivity;
import com.handsomezhou.customdialog.dialog.BaseProgressDialog;

public class MainFragment extends BaseFragment {
    private Button mDialogDemoBtn;
    private Button mDialogFragmentDemoBtn;
    private Button mProgressDialogDemoBtn;
  

  
    @Override
    protected void initData() {
        setContext(getActivity().getApplicationContext());
      
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mDialogDemoBtn = (Button) view.findViewById(R.id.dialog_demo_btn);
        mDialogFragmentDemoBtn = (Button) view
                .findViewById(R.id.dialog_fragment_demo_btn);
        mProgressDialogDemoBtn = (Button) view.findViewById(R.id.progress_dialog_demo_btn);
     
        return view;
    }

    @Override
    protected void initListener() {
        mDialogDemoBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),
                        DialogDemoActivity.class);
                startActivity(intent);

            }
        });

        mDialogFragmentDemoBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),
                        DialogFragmentDemoActivity.class);
                startActivity(intent);

            }
        });

        mProgressDialogDemoBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              Intent intent=new Intent(getActivity(), ProgressDialogDemoActivity.class);
              startActivity(intent);
            }
        });

    }

}
