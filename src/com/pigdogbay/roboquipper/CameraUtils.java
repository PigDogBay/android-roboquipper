package com.pigdogbay.roboquipper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.util.Log;

public class CameraUtils {
	
	/**
	 * @param context
	 * @return True if camera is present
	 */
	public static boolean checkCameraHardware(Context context) {
		//Check for back facing and front facing camera 
	    if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)
	    		|| context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)){
	        // this device has a camera
	        return true;
	    } else {
	        // no camera on this device
	        return false;
	    }
	}	
	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	public static Camera getCameraInstamce()
	{
	    Camera c = null;
	    try {
			int sdk = android.os.Build.VERSION.SDK_INT;
			if (sdk < android.os.Build.VERSION_CODES.GINGERBREAD)
			{
				c = Camera.open();
			}
			else
			{
				c = Camera.open(0);
			}
	    }
	    catch (Exception e){
	    	Log.v("Camera", e.getMessage());
	    }
	    return c;
	}

}
