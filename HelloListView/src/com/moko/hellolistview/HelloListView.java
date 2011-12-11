package com.moko.hellolistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class HelloListView extends ListActivity {
    /** Called when the activity is first created. */
	private String[] mStrings = {
			"www.moko365.com",
			"www.google.com",
			"www.jollen.org",
	};
    @Override
    public void onCreate(Bundle savedInstanceState) {
    
    	
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        ListAdapter adapter = new ArrayAdapter<String>(
        		this, 
        		android.R.layout.simple_list_item_1, 
        		mStrings
        	);
        
        setListAdapter(adapter);
    }
}