/*
 * Copyright (C) 2011 Moko365 Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mokoid.media;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class MusicPlayer extends Activity implements View.OnClickListener {
    public static final int PLAYER_READY = 0;
	private Context mContext;
	private Thread mThread;
	protected MediaPlayer mMediaPlayer;
	private MediaPlayerHandler mHandler;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnStart = (Button) findViewById(R.id.start);
        btnStart.setOnClickListener(this);
        btnStart.setClickable(false);
        
        mContext = this;
        
        /*
         * Create Handler object in UI thread.
         */
        mHandler = new MediaPlayerHandler();
        
        PrepareMediaPlayer();
    }
    
    class MediaPlayerHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case MusicPlayer.PLAYER_READY:
					Toast.makeText(mContext, 
							"MediaPlayer is ready.", 
							Toast.LENGTH_LONG).show();
					break;
			}
			super.handleMessage(msg);
		}
    	
    }

	private void PrepareMediaPlayer() {
		mThread = new Thread(new Runnable() {
			public void run() {
		        mMediaPlayer = MediaPlayer.create(mContext,  
			    /*         R.raw.test_cbr);	*/
		        	Uri.parse("http://www.jollen.org/test.mp3"));
		        
		        Message m = new Message();
		        m.what = MusicPlayer.PLAYER_READY;
		        mHandler.sendMessage(m);
			}
		});
		
		mThread.start();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start:		        
			mMediaPlayer.start();
			break;
		case R.id.stop:
		}
	}
}