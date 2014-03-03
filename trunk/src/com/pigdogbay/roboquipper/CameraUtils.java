package com.pigdogbay.roboquipper;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;

public class CameraUtils {
	
	/**
	 * @param context
	 * @return True if camera is present
	 */
	public static boolean checkCameraHardware(Context context) {
	    if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
	        // this device has a camera
	        return true;
	    } else {
	        // no camera on this device
	        return false;
	    }
	}	
	public static Camera getCameraInstamce()
	{
	    Camera c = null;
	    try {
	        c = Camera.open();
	    }
	    catch (Exception e){
	    }
	    return c;
	}

}
