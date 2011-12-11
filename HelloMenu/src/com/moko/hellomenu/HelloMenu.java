/* Ωd®“¿…¶W°GHelloMenu.java */
package com.moko.hellomenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class HelloMenu extends Activity {
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
                Toast.makeText(
                        this,
                        "Please enter your message."
                                + " Your message is at max 255 characters.",
                        Toast.LENGTH_LONG).show();
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