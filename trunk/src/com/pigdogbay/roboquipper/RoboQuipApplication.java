package com.pigdogbay.roboquipper;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import android.app.Application;

public class RoboQuipApplication extends Application{
	private Tracker _Tracker;

	synchronized Tracker getTracker(){
		if (_Tracker==null){
			_Tracker = GoogleAnalytics.getInstance(this).newTracker(R.xml.app_tracker);
		}
		return _Tracker;
	}

}
