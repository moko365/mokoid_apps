package com.moko.hellotheme;

import android.app.Activity;
import android.os.Bundle;

public class HelloTheme extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* setTheme(R.style.myTheme); */
        setContentView(R.layout.main);
    }
}