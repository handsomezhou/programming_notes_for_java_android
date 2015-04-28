package com.handsomezhou.customdialog.fragment;

import com.handsomezhou.customdialog.R;
import com.handsomezhou.customdialog.dialog.BaseProgressDialog;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ProgressDialogDemoFragment extends BaseFragment {
    private static final int PROGRESS_DIALOG_SHOW_TIME_MILLIS = 5000;// ms
    private static final int HANDLER_MSG_PROGRESS_DIALOG_DISPLAY = 0x01;
    private static final int HANDLER_MSG_PROGRESS_DIALOG_DISAPPEAR = 0x02;
    
    private Button mProgressDialogDemoBtn;
    private BaseProgressDialog mBaseProgressDialog;
    

    final Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case HANDLER_MSG_PROGRESS_DIALOG_DISPLAY:
                    break;
                case HANDLER_MSG_PROGRESS_DIALOG_DISAPPEAR:
                    getBaseProgressDialog().hide();
                    break;
                default:
                    break;
            }

        }

    };

    @Override
    protected void initData() {
      setContext(getActivity());
        
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_dialog_progress_fragment_demo, container, false);
        mProgressDialogDemoBtn=(Button)view.findViewById(R.id.progress_dialog_demo_btn);
        setBaseProgressDialog(new BaseProgressDialog(getActivity()));
        return view;
    }

    @Override
    protected void initListener() {
        mProgressDialogDemoBtn.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                getBaseProgressDialog().show(getContext().getResources().getString(R.string.loading));
                sendProgressDialogDisappearMsg();
                
            }
        });
        
    }

    @Override
    public void onDestroy() {
        clearViewDisappearMsg();
        super.onDestroy();
    }
    
    private BaseProgressDialog getBaseProgressDialog() {
        if(null==mBaseProgressDialog){
            mBaseProgressDialog=new BaseProgressDialog(getActivity());
        }
        return mBaseProgressDialog;
    }

    private void setBaseProgressDialog(BaseProgressDialog baseProgressDialog) {
        mBaseProgressDialog = baseProgressDialog;
    }

    private void sendProgressDialogDisappearMsg() {
        clearViewDisappearMsg();
        handler.sendEmptyMessageDelayed(HANDLER_MSG_PROGRESS_DIALOG_DISAPPEAR,
                PROGRESS_DIALOG_SHOW_TIME_MILLIS);
        return;
    }

    private void clearViewDisappearMsg() {

        if (handler.hasMessages(HANDLER_MSG_PROGRESS_DIALOG_DISAPPEAR)) {
            handler.removeMessages(HANDLER_MSG_PROGRESS_DIALOG_DISAPPEAR);
        }

        return;
    }
    
    

}
