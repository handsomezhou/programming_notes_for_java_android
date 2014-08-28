package com.handsomezhou.listviewsimple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	private int[] shapeId = { R.drawable.linear, R.drawable.curve,
			R.drawable.triangle, R.drawable.rounded_rectangle,
			R.drawable.diamond, R.drawable.rectangle, R.drawable.pentagon,
			R.drawable.oval, R.drawable.corners_star, R.drawable.pentagram,
			R.drawable.hexagon, R.drawable.hexagram, R.drawable.up_arrow,
			R.drawable.down_arrow, R.drawable.left_arrow,
			R.drawable.right_arrow };
	private String[] mShapeName = null;
	private ArrayAdapter<String> mAdapter;
	private ListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mShapeName = getShapeName();
		mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mShapeName);
		mListView = (ListView) findViewById(R.id.list_view);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this, "position=" + position,
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(MainActivity.this,
						SinglePictureActivity.class);
				intent.putExtra(SinglePictureActivity.RESID, shapeId[position]);
				startActivity(intent);
			}
		});

	}

	public String[] getShapeName() {

		String[] shapeName = new String[shapeId.length];
		for (int i = 0; i < shapeId.length; i++) {
			shapeName[i] = String.valueOf(getResources().getString(shapeId[i]));
			Log.i(TAG, "shamename=" + shapeName[i]);
		}

		return shapeName;
	}

}
