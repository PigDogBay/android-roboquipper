package com.pigdogbay.roboquipper;

import java.util.Locale;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.pigdogbay.roboquipper.StringScroller.StringScrollerCallBack;

import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,
		StringScrollerCallBack {

	public static final int CONSOLE_ROWS = 8;
	private TextView[] _Console = new TextView[CONSOLE_ROWS];
	private StringScroller _StringScroller;
	private Camera _Camera;
	private CameraPreview _CameraPreview;
	private AdView _AdView;

	private int[] _Sounds = { R.raw.air_wrench, R.raw.casing_dropped,
			R.raw.lock_load_fire, R.raw.m1_garrand, R.raw.micro_volume,
			R.raw.news_intro, R.raw.ricochet, R.raw.shotgun,
			R.raw.shotgun_reload, R.raw.sniper };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		_StringScroller = new StringScroller(CONSOLE_ROWS);
		_StringScroller._CallBack = this;
		wireUpButtons();
		wireUpTextViews();
		setupAds();
		//Get tracker - hopefully will auto track the activities
		((RoboQuipApplication) getApplication()).getTracker();
		
		checkAppRate();
		Toast.makeText(this, "Your Move Creep!", Toast.LENGTH_LONG).show();
		playSound(7);
	}
	@Override
	protected void onStart() {
		super.onStart();
		//Report the start of an Activity, so that it can be tracked by any Trackers that have enabled auto activity tracking
		GoogleAnalytics.getInstance(this).reportActivityStart(this);
	}
	@Override
	protected void onStop() {
		super.onStop();
		GoogleAnalytics.getInstance(this).reportActivityStop(this);;
	}

	private void setupAds() {
		// Look up the AdView as a resource and load a request.
		_AdView = (AdView) this.findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				.addTestDevice(getString(R.string.code_test_device_1_id))
				.addTestDevice(getString(R.string.code_test_device_2_id))
				.addTestDevice(getString(R.string.code_test_device_3_id))
				.build();
		_AdView.loadAd(adRequest);
	}

	@Override
	protected void onResume() {
		super.onResume();
		_AdView.resume();
		_StringScroller.Scroll(Quotes.getQuote(0));
		setupCamera();
	}

	@Override
	protected void onPause() {
		_AdView.pause();
		super.onPause();
		releaseCamera();
	}

	@Override
	public void onDestroy() {
		_AdView.destroy();
		super.onDestroy();
	}

	private void wireUpButtons() {
		int[] btns = new int[] { R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
				R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9 };
		for (int btn : btns) {
			((Button) findViewById(btn)).setOnClickListener(this);
		}
	}

	private void wireUpTextViews() {
		int[] tvs = new int[] { R.id.textView1, R.id.textView2, R.id.textView3,
				R.id.textView4, R.id.textView5, R.id.textView6, R.id.textView7,
				R.id.textView8, };
		for (int i = 0; i < CONSOLE_ROWS; i++) {
			_Console[i] = (TextView) findViewById(tvs[i]);
		}
	}

	private void setupCamera() {
		if (CameraUtils.checkCameraHardware(this)) {
			_Camera = CameraUtils.getCameraInstamce();
			_Camera.setDisplayOrientation(90);
			_CameraPreview = new CameraPreview(this, _Camera);
			FrameLayout layout = (FrameLayout) findViewById(R.id.camera_preview);
			layout.addView(_CameraPreview);
		}
	}

	private void playSound(int soundIndex) {
		int soundID = _Sounds[soundIndex];
		MediaPlayer player = MediaPlayer.create(this, soundID);
		player.start();
	}

	private void checkAppRate() {
		new com.pigdogbay.androidutils.apprate.AppRate(this)
				.setMinDaysUntilPrompt(7).setMinLaunchesUntilPrompt(5).init();
	}

	@Override
	public void onClick(View v) {
		int soundIndex = Integer.parseInt((String) v.getTag());
		_StringScroller.Scroll(Quotes.GetRandomQuote().toUpperCase(Locale.US));
		playSound(soundIndex);
	}

	@Override
	public void Update() {
		for (int i = 0; i < CONSOLE_ROWS; i++) {
			_Console[i].setText(_StringScroller.get(i));
		}
	}

	private void releaseCamera() {
		if (_Camera != null) {
			_Camera.release();
			_Camera = null;
		}
		FrameLayout layout = (FrameLayout) findViewById(R.id.camera_preview);
		layout.removeAllViews();
		_CameraPreview = null;
	}

}
