
package com.handsomezhou.customdialog.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.handsomezhou.customdialog.R;
import com.handsomezhou.customdialog.activity.DialogDemoActivity;
import com.handsomezhou.customdialog.activity.ProgressDialogDemoActivity;

public class MainFragment extends BaseFragment {
    private Button mDialogDemoBtn;
    private Button mProgressDialogDemoBtn;
  

  
    @Override
    protected void initData() {
        setContext(getActivity().getApplicationContext());
      
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mDialogDemoBtn = (Button) view.findViewById(R.id.dialog_demo_btn);
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


        mProgressDialogDemoBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              Intent intent=new Intent(getActivity(), ProgressDialogDemoActivity.class);
              startActivity(intent);
            }
        });

    }

}
