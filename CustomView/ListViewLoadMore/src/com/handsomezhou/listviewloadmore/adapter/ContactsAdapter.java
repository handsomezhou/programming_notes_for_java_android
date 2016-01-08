package com.handsomezhou.listviewloadmore.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.handsomezhou.listviewloadmore.R;
import com.handsomezhou.listviewloadmore.model.BaseContacts;


public class ContactsAdapter extends ArrayAdapter<BaseContacts> {
	private Context mContext;
	private int mTextViewResourceId;
	private List<BaseContacts> mBaseContacts;
	
	public ContactsAdapter(Context context, int textViewResourceId,
			List<BaseContacts> BaseContacts) {
		super(context, textViewResourceId, BaseContacts);
		mContext=context;
		mTextViewResourceId=textViewResourceId;
		mBaseContacts=BaseContacts;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view=null;
		ViewHolder viewHolder;
		BaseContacts contact=getItem(position);
		if(null==convertView){
			view=LayoutInflater.from(mContext).inflate(mTextViewResourceId, null);
			viewHolder=new ViewHolder();
			viewHolder.mNameTv=(TextView) view.findViewById(R.id.name_text_view);
			viewHolder.mPhoneNumberTv=(TextView) view.findViewById(R.id.phone_number_text_view);
			view.setTag(viewHolder);
		}else{
			view=convertView;
			viewHolder=(ViewHolder) view.getTag();
		}
		
		viewHolder.mNameTv.setText(contact.getName());
		viewHolder.mPhoneNumberTv.setText(contact.getPhoneNumber());
		return view;
	}
	
	private class ViewHolder{
		TextView mNameTv;
		TextView mPhoneNumberTv;
	}
}
