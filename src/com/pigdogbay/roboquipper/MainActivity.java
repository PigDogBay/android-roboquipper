package com.pigdogbay.roboquipper;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

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
        setContentView(R.layout.activity_main);
        wireUpButtons();
		checkAppRate();
		Toast.makeText(this, "Your Move Creep!", Toast.LENGTH_LONG).show();
		//playSound(R.raw.shotgun);
    }
	private void wireUpButtons(){
		int[] btns = new int[]{R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn4,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
		for(int btn : btns)
		{
			((Button) findViewById(btn)).setOnClickListener(this);
		}
	}
	
	private void ShowQuipDialog(String msg)
	{
		String title = getResources().getString(R.string.quip_title);
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_info).setTitle(title).setMessage(msg).setPositiveButton(
                R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();		
	}    
	private void playSound(int soundID)
	{
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
    	ShowQuipDialog(Quotes.GetRandomQuote());
    	//playSound(_Sounds[soundIndex]);
	}	
}
