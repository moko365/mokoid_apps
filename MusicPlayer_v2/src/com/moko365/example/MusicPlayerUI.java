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

package com.moko365.example;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Debug;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.Runnable;

public class MusicPlayerUI extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	MediaPlayer mMediaPlayer;
	Thread mThread;
	Context mContext;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button playBtn = (Button) findViewById(R.id.playBtn);        
        playBtn.setOnClickListener(this);
        
        mContext = this;
        
        mThread = new Thread(new Runnable() {
            public void run() {
            	mMediaPlayer = MediaPlayer.create(mContext, R.raw.test);		
            }
        });
    }

	public void onClick(View v) {
	    mThread.start();
	}
}