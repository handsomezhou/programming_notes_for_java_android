package com.handsomezhou.service.startservice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private final static String LISTEN_SERVICE = "com.handsomezhou.service.startservice.ListenService";
	private Button startServiceBtn;
	private Button stopServiceBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startServiceBtn = (Button) findViewById(R.id.start_service);
		stopServiceBtn = (Button) findViewById(R.id.stop_service);
		final Intent intent = new Intent();
		intent.setAction(LISTEN_SERVICE);

		startServiceBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startService(intent);
			}
		});

		stopServiceBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				stopService(intent);

			}
		});
	}

}
