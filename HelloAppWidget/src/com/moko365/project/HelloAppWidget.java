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

package com.moko365.project;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.TimePicker;


@SuppressLint("NewApi")
public class HelloAppWidget extends AppWidgetProvider {
	
	private static AppWidgetManager widgetManager;
	private static int[] widgetIds;
	private static Context widgetContext;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		if (widgetManager != null) {
			Log.i("--appwidget--", "onreceive -> updateAppWidget();");
			updateAppWidget(widgetContext, widgetManager, widgetIds);
		}
		super.onReceive(context, intent);
	}

	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
	    	Log.i("--appwidget--", "onEnabled");
	    	Intent i = new Intent("com.mokoid.appwidget");
	    	PendingIntent updateWidget = PendingIntent.getBroadcast(context, 1, i, 
	    			PendingIntent.FLAG_UPDATE_CURRENT);
	    	AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
	    	am.setRepeating(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime(), 3000, updateWidget);
		super.onEnabled(context);
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		Log.i("--appwidget--", "Call HelloAppWdiget.onUpdate().");
		
		widgetContext = context;
		widgetManager = appWidgetManager;
		widgetIds = appWidgetIds;
		
		updateAppWidget(context, appWidgetManager, appWidgetIds);
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}

	private void updateAppWidget(Context context,
			AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		final int N = appWidgetIds.length;
		
		for ( int i = 0; i < N; i++) {
			int appWidgetId = appWidgetIds[i];
			
            TimePicker picker = new TimePicker(context);
            picker.setIs24HourView(true);
            String time = picker.getCurrentHour()+":"+picker.getCurrentMinute();
                        
			RemoteViews v = new RemoteViews(context.getPackageName(),R.layout.main);
			v.setTextViewText(R.id.appwidget, time);
			
			appWidgetManager.updateAppWidget(appWidgetId, v);
		}
	}

}
