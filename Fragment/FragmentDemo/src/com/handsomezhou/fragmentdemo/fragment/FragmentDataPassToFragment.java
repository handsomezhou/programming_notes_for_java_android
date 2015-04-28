
package com.handsomezhou.fragmentdemo.fragment;

import java.util.Date;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.fragmentdemo.R;

public class FragmentDataPassToFragment extends BaseFragment {
    private Button mFragmentDataPassToBtn;
    public static final String EXTRA_DATE = "FragmentDataPassToFragment.EXTRA_DATE";
    private Date mDate;
    public static FragmentDataPassToFragment newInstance(Date date){
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_DATE, date);
        
        FragmentDataPassToFragment fragment = new FragmentDataPassToFragment();
        fragment.setArguments(bundle);

        return fragment;
    }
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mDate=(Date) getArguments().getSerializable(EXTRA_DATE);
        //Toast.makeText(getActivity(), mDate.toString(), Toast.LENGTH_LONG).show();
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    protected void initData() {
        // TODO Auto-generated method stub

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_fragment_data_pass_to, container, false);
        mFragmentDataPassToBtn = (Button) view.findViewById(R.id.fragment_data_pass_to_btn);
        return view;
    }

    @Override
    protected void initListener() {
        mFragmentDataPassToBtn.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                clickFragmentDataPassToBtn();
            }
        });

    }
    
    private void clickFragmentDataPassToBtn(){
        
    }

}
