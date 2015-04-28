
package com.handsomezhou.fragmentdemo.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.handsomezhou.fragmentdemo.R;
import com.handsomezhou.fragmentdemo.activity.AddressBookBottomTabActivity;
import com.handsomezhou.fragmentdemo.activity.AddressBookTopTabActivity;
import com.handsomezhou.fragmentdemo.activity.FragmentDataPassFromActivity;

public class MainVerticalFragment extends BaseFragment {
    private Button mFragmentTopTabBtn;
    private Button mFragmentBottomTabBtn;
    private Button mFragmentDataPassBtn;

    @Override
    protected void initData() {
        setContext(getActivity());

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_main_vertical, container, false);
        mFragmentTopTabBtn = (Button) view.findViewById(R.id.fragment_top_tab_btn);
        mFragmentBottomTabBtn = (Button) view.findViewById(R.id.fragment_bottom_tab_btn);
        mFragmentDataPassBtn=(Button)view.findViewById(R.id.fragment_data_pass_btn);
        return view;
    }

    @Override
    protected void initListener() {
        mFragmentTopTabBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clickclickFragmentTopTab();
            }
        });

        mFragmentBottomTabBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clickFragmentBottomTab();
            }
        });

        mFragmentDataPassBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clickFragmentDataPass();
            }
        });
        return;

    }

    private void clickclickFragmentTopTab() {
        Toast.makeText(getContext(), "fragment_top_tab", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), AddressBookTopTabActivity.class);
        startActivity(intent);

    }

    private void clickFragmentBottomTab() {
        Toast.makeText(getContext(), "fragment_bottom_tab", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), AddressBookBottomTabActivity.class);
        startActivity(intent);
    }
    
    private void clickFragmentDataPass(){
        Toast.makeText(getContext(), "fragment_data_pass", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getContext(), FragmentDataPassFromActivity.class);
        startActivity(intent);
    }
}
