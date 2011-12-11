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

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PlayerService extends Service {

	private static MediaPlayer mMediaPlayer;
	private static PlayerControl mPlayerControl;
	
	@Override
	public IBinder onBind(Intent intent) {
		mPlayerControl = new PlayerControl(this);
		return mPlayerControl;
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		
		mMediaPlayer = MediaPlayer.create(this, R.raw.test_cbr);
	}
	
	public void Start() {
		mMediaPlayer.start();
	}
	
	public void Stop() {
		mMediaPlayer.stop();
	}

}
