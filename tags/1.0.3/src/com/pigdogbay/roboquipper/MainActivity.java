package com.pigdogbay.roboquipper;

import java.util.Random;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

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
	
	Random _Random = new Random();

	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		((Button) findViewById(R.id.btnQuip)).setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				playRandomSound();
		    	ShowQuipDialog(Quotes.GetRandomQuote());
			}
		});
		Toast.makeText(this, "Press Quip!", Toast.LENGTH_LONG).show();
		playSound(R.raw.shotgun);
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
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		Intent intent;
		switch (item.getItemId())
		{
		case (R.id.menu_about):
			intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
			break;
		default:
			return false;
		}
		return true;
	}   
	
	private void playRandomSound()
	{
		int index = _Random.nextInt(_Sounds.length);
		playSound(_Sounds[index]);
	}
	private void playSound(int soundID)
	{
		MediaPlayer player = MediaPlayer.create(this, soundID);
		player.start();
	}
}