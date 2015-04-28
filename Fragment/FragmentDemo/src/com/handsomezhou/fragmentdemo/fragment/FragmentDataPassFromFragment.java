package com.handsomezhou.fragmentdemo.fragment;

import java.util.Date;

import com.handsomezhou.fragmentdemo.R;
import com.handsomezhou.fragmentdemo.activity.FragmentDataPassToActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentDataPassFromFragment extends BaseFragment {
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
    
    private void clickFragmentDataPassFromBtn(){
        Intent intent=new Intent(getActivity(), FragmentDataPassToActivity.class);
        FragmentDataPassToFragment.newInstance(new Date());
        startActivity(intent);
    }

}
