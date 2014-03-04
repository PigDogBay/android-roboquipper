package com.pigdogbay.roboquipper;

import java.util.Locale;

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

public class MainActivity extends Activity implements OnClickListener, StringScrollerCallBack {

	public static final int CONSOLE_ROWS = 8;
	private TextView[] _Console = new TextView[CONSOLE_ROWS]; 
	private StringScroller _StringScroller;
	private Camera _Camera;
	private CameraPreview _CameraPreview;
	
	private int[] _Sounds = {
			R.raw.air_wrench,
			R.raw.casing_dropped,
			R.raw.lock_load_fire,
			R.raw.m1_garrand,
			R.raw.micro_volume,
			R.raw.news_intro,
			R.raw.ricochet,
			R.raw.shotgun,
			R.raw.shotgun_reload,
			R.raw.sniper};
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        _StringScroller = new StringScroller(CONSOLE_ROWS);
        _StringScroller._CallBack = this;
        wireUpButtons();
        wireUpTextViews();
		checkAppRate();
		Toast.makeText(this, "Your Move Creep!", Toast.LENGTH_LONG).show();
		playSound(7);
    }
	@Override
	protected void onResume() {
		super.onResume();
		_StringScroller.Scroll(Quotes.getQuote(0));
		setupCamera();
	}
	@Override
	protected void onPause() {
		super.onPause();
		releaseCamera();
	}
	private void wireUpButtons(){
		int[] btns = new int[]{R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
		for(int btn : btns)
		{
			((Button) findViewById(btn)).setOnClickListener(this);
		}
	}
	private void wireUpTextViews(){
		int[] tvs = new int[]{R.id.textView1,R.id.textView2,R.id.textView3,R.id.textView4,R.id.textView5,R.id.textView6,R.id.textView7,R.id.textView8,};
		for (int i=0; i<CONSOLE_ROWS;i++)
		{
			_Console[i] = (TextView) findViewById(tvs[i]);
		}
	}
	private void setupCamera(){
        if (CameraUtils.checkCameraHardware(this))
        {
	        _Camera = CameraUtils.getCameraInstamce();
	        _Camera.setDisplayOrientation(90);
	        _CameraPreview = new CameraPreview(this, _Camera);
	        FrameLayout layout = (FrameLayout)findViewById(R.id.camera_preview);
	        layout.addView(_CameraPreview);
        }
	}
	private void playSound(int soundIndex)
	{
		int soundID = _Sounds[soundIndex];
		MediaPlayer player = MediaPlayer.create(this, soundID);
		player.start();
	}
	private void checkAppRate() {
		new com.pigdogbay.androidutils.apprate.AppRate(this)
				.setMinDaysUntilPrompt(7).setMinLaunchesUntilPrompt(5)
				.init();
	}
	@Override
	public void onClick(View v) {
		int soundIndex = Integer.parseInt((String)v.getTag());
		_StringScroller.Scroll(Quotes.GetRandomQuote().toUpperCase(Locale.US));
    	playSound(soundIndex);
	}
	@Override
	public void Update() {
		for (int i=0;i<CONSOLE_ROWS;i++)
		{
			_Console[i].setText(_StringScroller.get(i));
		}
	}
	
    private void releaseCamera(){
        if (_Camera != null){
            _Camera.release();
            _Camera = null;
        }
        FrameLayout layout = (FrameLayout)findViewById(R.id.camera_preview);
        layout.removeAllViews();
        _CameraPreview = null;
    }	
	
}
