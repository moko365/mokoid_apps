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

package com.moko.dummywidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

public class DummyWidget extends AppWidgetProvider {

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    	Log.i("--DummyWidget--", "Call HelloAppWdiget.onUpdate().");
    	Toast.makeText(context, "onUpdate", Toast.LENGTH_SHORT).show();
        final int N = appWidgetIds.length;
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
    
    public void onDeleted(Context context, int[] appWidgetIds) {
    	Log.i("--DummyWidget--", "Call HelloAppWdiget.onDelete().");
    	Toast.makeText(context, "onDelete", Toast.LENGTH_SHORT).show();
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
            int appWidgetId) {
        CharSequence time = Long.toString(SystemClock.elapsedRealtime());
    	
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);
        views.setTextViewText(R.id.appwidget_text, time);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}