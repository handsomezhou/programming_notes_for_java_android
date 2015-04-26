package com.handsomezhou.listviewcustom.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SinglePictureActivity extends Activity {
	public static final String RESID = "RESID";
	private static final int ILLEGAL_RESID = -1;
	private ImageView mImageView;
	private Button mBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_picture);

		mImageView = (ImageView) findViewById(R.id.single_picture_image_view);
		mBack = (Button) findViewById(R.id.back_btn);
		Bundle bundle = getIntent().getExtras();
		int resid;
		if (null != bundle) {
			resid = bundle.getInt(RESID, ILLEGAL_RESID);
			if (ILLEGAL_RESID != resid) {
				mImageView.setBackgroundResource(resid);
			} else {
				Toast.makeText(SinglePictureActivity.this, "ILLEGAL_RESID",
						Toast.LENGTH_SHORT).show();
			}
		} else {
			Toast.makeText(SinglePictureActivity.this, "ILLEGAL_RESID",
					Toast.LENGTH_SHORT).show();
		}

		mBack.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}

		});
	}
}
