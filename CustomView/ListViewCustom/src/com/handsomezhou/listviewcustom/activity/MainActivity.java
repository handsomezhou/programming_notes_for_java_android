package com.handsomezhou.listviewcustom.activity;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.handsomezhou.listviewcustom.adapter.ShapeAdapter;
import com.handsomezhou.listviewcustom.model.Shape;

public class MainActivity extends Activity {
	private static int[] shapeId = { R.drawable.linear, R.drawable.curve,
			R.drawable.triangle, R.drawable.rounded_rectangle,
			R.drawable.diamond, R.drawable.rectangle, R.drawable.pentagon,
			R.drawable.oval, R.drawable.corners_star, R.drawable.pentagram,
			R.drawable.hexagon, R.drawable.hexagram, R.drawable.up_arrow,
			R.drawable.down_arrow, R.drawable.left_arrow,
			R.drawable.right_arrow };
	private List<Shape> shapeList = new ArrayList<Shape>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initShapes();
		ShapeAdapter adapter = new ShapeAdapter(MainActivity.this,
				R.layout.shape_item, shapeList);
		ListView listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(MainActivity.this,
						SinglePictureActivity.class);
				Bundle bundle = new Bundle();
				bundle.putInt(SinglePictureActivity.RESID, shapeId[position]);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}

	private void initShapes() {
		for (int i = 0; i < shapeId.length; i++) {
			Shape shape = new Shape(getResources().getString(shapeId[i])
					.toString(), shapeId[i]);
			shapeList.add(shape);
		}

	}

}
