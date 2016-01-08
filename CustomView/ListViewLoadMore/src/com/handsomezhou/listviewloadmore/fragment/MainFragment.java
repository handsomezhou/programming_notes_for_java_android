
package com.handsomezhou.listviewloadmore.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handsomezhou.listviewloadmore.R;
import com.handsomezhou.listviewloadmore.adapter.ContactsAdapter;
import com.handsomezhou.listviewloadmore.model.BaseContacts;
import com.handsomezhou.listviewloadmore.util.ViewUtil;
import com.handsomezhou.listviewloadmore.view.LoadListView;
import com.handsomezhou.listviewloadmore.view.LoadListView.OnLoad;

public class MainFragment extends BaseFragment implements OnLoad {
    private List<BaseContacts> mContacts;
    private LoadListView mContactsLv;
    private ContactsAdapter mContactsAdapter;

    @Override
    protected void initData() {
        setContext(getActivity());
        mContacts = new ArrayList<BaseContacts>();
        for (int i = 0; i < 20; i++) {
            BaseContacts bc = new BaseContacts();
            bc.setName("name" + i);
            bc.setPhoneNumber("0000000000" + i);
            mContacts.add(bc);
        }
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mContactsLv = (LoadListView) view.findViewById(R.id.contacts_list_view);
        mContactsAdapter = new ContactsAdapter(getContext(), R.layout.contacts_list_item, mContacts);
        mContactsLv.setOnLoad(this);
        mContactsLv.setAdapter(mContactsAdapter);
        return view;
    }

    @Override
    protected void initListener() {
        // TODO Auto-generated method stub

    }

    private void loadContacts() {
        if (null == mContacts) {
            mContacts = new ArrayList<BaseContacts>();
        }

        int currentContactsCount = mContacts.size();
        for (int i = currentContactsCount; i < currentContactsCount + 20; i++) {
            BaseContacts bc = new BaseContacts();
            bc.setName("name" + i);
            bc.setPhoneNumber("0000000000" + i);
            mContacts.add(bc);
        }
    }


    /*start: OnLoad*/
    @Override
    public void onStartLoad() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                // 获取更多数据
                loadContacts();
               
                refreshContactsLv();
                
                // 通知listview加载完毕
                mContactsLv.loadComplete();
            }
        }, 1000);
        
    }
    /*end: OnLoad*/
    
   

    private void refreshContactsLv() {
        if (null != mContactsAdapter) {
            mContactsAdapter.notifyDataSetChanged();
            if (mContactsAdapter.getCount() > 0) {
                ViewUtil.showView(mContactsLv);
            } else {
                ViewUtil.hideView(mContactsLv);
            }
        }
    }

    
}
