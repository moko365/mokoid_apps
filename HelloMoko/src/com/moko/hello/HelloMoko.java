package com.moko.hello;

import com.moko.hello.R;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

public class HelloMoko extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        
        startService(new Intent ("com.moko.hello.START_MUSIC"));
	}
}