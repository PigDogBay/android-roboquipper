package com.pigdogbay.roboquipper;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Based on code from
 * http://developer.android.com/guide/topics/media/camera.html
 */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback{

    private SurfaceHolder _Holder;
    private Camera _Camera;
    
	@SuppressWarnings("deprecation")
	public CameraPreview(Context context, Camera camera) {
		super(context);
		_Camera = camera;
        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        _Holder = getHolder();
        _Holder.addCallback(this);
        // deprecated setting, but required on Android versions prior to 3.0
        _Holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// If your preview can change or rotate, take care of those events here.
        // Make sure to stop the preview before resizing or reformatting it.

        if (_Holder.getSurface() == null){
          // preview surface does not exist
          return;
        }

        // stop preview before making changes
        try {
            _Camera.stopPreview();
        } catch (Exception e){
          // ignore: tried to stop a non-existent preview
        }

        // set preview size and make any resize, rotate or
        // reformatting changes here

        // start preview with new settings
        try {
            _Camera.setPreviewDisplay(_Holder);
            _Camera.startPreview();

        } catch (Exception e){
            Log.d("RoboQuip", "Error starting camera preview: " + e.getMessage());
        }		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
        // The Surface has been created, now tell the camera where to draw the preview.
        try {
            _Camera.setPreviewDisplay(holder);
            _Camera.startPreview();
        } catch (IOException e) {
            Log.d("RoboQuip", "Error setting camera preview: " + e.getMessage());
        }		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// empty. Take care of releasing the Camera preview in your activity.		
	}

}
