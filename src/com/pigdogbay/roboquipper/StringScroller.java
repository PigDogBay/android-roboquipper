package com.pigdogbay.roboquipper;

import java.util.StringTokenizer;

import android.os.AsyncTask;

/**
 * @author mark.bailey
 * @param <T>
 */
public class StringScroller {

	public static final long SCROLL_PAUSE = 200L;
	private String[] _Buffer;
	public StringScrollerCallBack _CallBack;
	private boolean _Lock;
	
	public StringScroller(int capacity) {
		_Buffer = new String[capacity];
		_Lock = false;
	}

	public void add(String toAdd) {
		//shuffle strings up the array
		for (int i = _Buffer.length-1; i>0;i--){
			_Buffer[i]  = _Buffer[i-1];
		}
		_Buffer[0] = toAdd;
	}
	public String get(int index)
	{
		return _Buffer[index];
	}
	public void Scroll(String string)
	{
		if (!_Lock)
		{
			_Lock = true;
			this.new BackgroundWorker().execute(string);
		}
	}
	public interface StringScrollerCallBack
	{
		void Update();
	}
	private class BackgroundWorker extends AsyncTask<String, Void, Void>
	{
		@Override
		protected Void doInBackground(String... params)
		{
			StringTokenizer tokenizer = new StringTokenizer(params[0], "\n");
			while (tokenizer.hasMoreElements()){
				addLine(tokenizer.nextToken());
			}
			addLine(" ");
			return null;
		}
		private void addLine(String line){
			add(line);
			publishProgress();
			try {
				Thread.sleep(SCROLL_PAUSE);
			}catch (Exception e){}
			
		}
		@Override
		protected void onProgressUpdate(Void... values)
		{
			if (_CallBack!=null){
				_CallBack.Update();
			}
		}
		
		@Override
		protected void onPostExecute(Void result)
		{
			_Lock = false;
		}
	}
}
