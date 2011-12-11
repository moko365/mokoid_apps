package com.moko.hellowidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.SystemClock;
import android.widget.RemoteViews;

public class HelloAppWidgetProvider extends AppWidgetProvider {
	
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
    
    public void onDeleted(Context context, int[] appWidgetIds) {
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
            int appWidgetId) {
        	
        CharSequence time = Long.toString(SystemClock.elapsedRealtime());
    	
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);
        views.setTextViewText(R.id.appwidget_text, time);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}