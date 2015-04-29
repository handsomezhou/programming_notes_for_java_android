package com.handsomezhou.fragmentdemo.fragment;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.fragmentdemo.R;
import com.handsomezhou.fragmentdemo.activity.FragmentDataPassToActivity;

public class FragmentDataPassFromFragment extends BaseFragment {
	public static final int REQUEST_DATE = 0;
    private Button mFragmentDataPassFromBtn;
    @Override
    protected void initData() {
        setContext(getActivity());
        
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_fragment_data_pass_from, container, false);
        mFragmentDataPassFromBtn=(Button) view.findViewById(R.id.fragment_data_pass_from_btn);
        return view;
    }

    @Override
    protected void initListener() {
        mFragmentDataPassFromBtn.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                clickFragmentDataPassFromBtn();
            }
        });
        
    }
    
    @Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        
        if (requestCode == REQUEST_DATE) {
            Date date = (Date) data.getSerializableExtra(FragmentDataPassToFragment.EXTRA_DATE);
            Toast.makeText(getContext(), "[" + date + "]"+"requestCode=["+requestCode+"]resultCode["+resultCode+"]", Toast.LENGTH_LONG).show();

        }
	}

	private void clickFragmentDataPassFromBtn(){
        Intent intent=new Intent(getActivity(), FragmentDataPassToActivity.class);
        Bundle bundle = new Bundle();
        Date date=new Date();
        bundle.putSerializable(FragmentDataPassToFragment.EXTRA_DATE, date);
        intent.putExtras(bundle);
        startActivityForResult(intent, REQUEST_DATE);
    }

}
