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
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;
import android.view.View;

public class PlayerUI extends Activity implements View.OnClickListener {
	
    private static final String PLAYER_TAG = "MokoidPlayer";	
	private static IPlayerControl mIPlayerControl;
        
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button startBtn = (Button) findViewById(R.id.start);
        startBtn.setOnClickListener(this);
        
        Button stopBtn = (Button) findViewById(R.id.stop);
        stopBtn.setOnClickListener(this);
        
        startService(new Intent("com.mokoid.media.Start"));
    }

    private ServiceConnection mConnection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mIPlayerControl = IPlayerControl.Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub			
		}
    	
    };
    
	@Override
	public void onClick(View v) {
		bindService(new Intent("com.mokoid.media.Start"), mConnection, 
				Context.BIND_AUTO_CREATE);
		
		if (mIPlayerControl == null) {
			Toast.makeText(this, 
						"Can't find a music player!",
						Toast.LENGTH_LONG).show();
			return ;
		}
		/* 
		 * Calling an IPC method.
		 */
		
		switch (v.getId()) {
				case R.id.start:
					try {
						mIPlayerControl.Start();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				case R.id.stop:
					try {
						mIPlayerControl.Stop();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
		}
	}
}