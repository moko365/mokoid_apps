package com.moko.web;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.moko.web.R;

public class HelloWeb extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final String mimetype = "text/html";
        final String encoding = "utf-8";
        
        WebView wv;
        
        wv = (WebView) findViewById(R.id.wv);
        wv.loadData("<h1>Android Day</h1><a href=\"www.androidday.com\">...</a>", mimetype, encoding);
    }
}