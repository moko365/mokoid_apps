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

package com.moko.helloalertdialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class HelloAlertDialog extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
    	int item_id = item.getItemId();
    	
    	switch (item_id){
    		case R.id.new_message: 
	    	        AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    	        
	    	        builder.setMessage("Also post your message to Twitter?");
	    	        builder.setCancelable(false);
	    	        
	    	        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	    	        	public void onClick(DialogInterface dialog, int id) {
	    	        	}
	    	        });
	    	        
	    	        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
	    	        	public void onClick(DialogInterface dialog, int id) {
	    	        	}
	    	        });   
	    	        
	    	        AlertDialog alert = builder.create();
	    	        alert.show();
    			break;
    		case R.id.quit: 
                Toast.makeText(
                        this,
                        "Going to quit.",
                        Toast.LENGTH_LONG).show();    			
    			break;
    		default: return false;
    	}
    	return true;
    }
}