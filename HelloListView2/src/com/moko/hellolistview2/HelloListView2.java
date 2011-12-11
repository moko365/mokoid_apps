package com.moko.hellolistview2;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class HelloListView2 extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
       
        String[] mStrings = getResources().getStringArray(R.array.HelloListView2StringArray);
        ListAdapter adapter = new ArrayAdapter<String>(
        		this, 
        		R.layout.main,
        		R.id.tv,
        		mStrings);
        
        setListAdapter(adapter);
    }

}