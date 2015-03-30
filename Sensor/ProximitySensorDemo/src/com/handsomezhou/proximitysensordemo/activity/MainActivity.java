package com.handsomezhou.proximitysensordemo.activity;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.proximitysensordemo.R;
import com.handsomezhou.proximitysensordemo.util.ViewUtil;

public class MainActivity extends Activity implements SensorEventListener {
	private static final String TAG = "MainActivity";

	public enum LockScreenState {
		LOCK_SCREEN_YES, LOCK_SCREEN_NO,
	}

	private SensorManager mSensorManager;
	private Sensor mProximitySensor;

	private View mMainLayout;
	private View mLockScreenLayout;

	private LockScreenState mLockScreenState;

	@Override
	public final void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initData();
		initView();
		initListener();

	}

	@Override
	protected void onResume() {
		// Register a listener for the sensor.
		super.onResume();
		mSensorManager.registerListener(this, mProximitySensor,
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		// Be sure to unregister the sensor when the activity pauses.
		super.onPause();
		mSensorManager.unregisterListener(this);
	}

	@Override
	public final void onAccuracyChanged(Sensor sensor, int accuracy) {
		// Do something here if sensor accuracy changes.
	}

	@Override
	public final void onSensorChanged(SensorEvent event) {
		float distance = event.values[0];
		// Do something with this sensor data.
		Log.i(TAG,
				"distance=[" + distance + "]getMaximumRange=["
						+ mProximitySensor.getMaximumRange() + "]LockScreenState=["
						+ getLockScreenState().toString() + "]");

		if (distance < mProximitySensor.getMaximumRange()) {
			setLockScreenState(LockScreenState.LOCK_SCREEN_YES);
		} else {
			setLockScreenState(LockScreenState.LOCK_SCREEN_NO);
		}

		updateView();

	}

	private void initData() {
		// Get an instance of the sensor service, and use that to get an
		// instance of
		// a particular sensor.
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mProximitySensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		setLockScreenState(LockScreenState.LOCK_SCREEN_NO);

		return;
	}

	public LockScreenState getLockScreenState() {
		return mLockScreenState;
	}

	public void setLockScreenState(LockScreenState lockScreenState) {
		mLockScreenState = lockScreenState;
	}

	private void initView() {
		mMainLayout = findViewById(R.id.main_layout);
		mLockScreenLayout = findViewById(R.id.lock_screen_layout);

		updateView();

		return;
	}

	private void initListener() {

		return;
	}

	private void updateView() {
		if (getLockScreenState() == LockScreenState.LOCK_SCREEN_NO) {
			ViewUtil.showView(mMainLayout);
			ViewUtil.hideView(mLockScreenLayout);
		} else {
			ViewUtil.hideView(mMainLayout);
			ViewUtil.showView(mLockScreenLayout);
		}
	}

}
