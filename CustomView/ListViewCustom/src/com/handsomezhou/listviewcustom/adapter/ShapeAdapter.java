package com.handsomezhou.listviewcustom.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.handsomezhou.listviewcustom.activity.R;
import com.handsomezhou.listviewcustom.model.Shape;

public class ShapeAdapter extends ArrayAdapter<Shape> {
	private int mTextViewResourceId;

	public ShapeAdapter(Context context, int textViewResourceId,
			List<Shape> objects) {
		super(context, textViewResourceId, objects);
		mTextViewResourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Shape shape = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (null == convertView) {
			view = LayoutInflater.from(getContext()).inflate(
					mTextViewResourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.shapeImage = (ImageView) view
					.findViewById(R.id.shape_image_image_view);
			viewHolder.shapeName = (TextView) view
					.findViewById(R.id.shape_name_text_view);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}

		// ImageView shapeImage = (ImageView) view
		// .findViewById(R.id.shape_image_image_view);
		// TextView shapeName = (TextView) view
		// .findViewById(R.id.shape_name_text_view);
		// shapeImage.setImageResource(shape.getImageId());
		// shapeName.setText(shape.getName());
		viewHolder.shapeImage.setImageResource(shape.getImageId());
		viewHolder.shapeName.setText(shape.getName());

		return view;
	}

	class ViewHolder {
		ImageView shapeImage;
		TextView shapeName;
	}

}
