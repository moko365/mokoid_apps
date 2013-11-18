package com.moko.hello;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MokoService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		stopForeground(true);
		//play MP3
	}
	
	@Override
	public void onDestroy() {
		
	}
}
