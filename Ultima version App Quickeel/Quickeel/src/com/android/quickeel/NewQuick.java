package com.android.quickeel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.WazaBe.HoloEverywhere.sherlock.SActivity;

public class NewQuick extends SActivity {

	private EditText edit_location;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Holo_Theme_Sherlock_Light_NoActionBar);
        setContentView(R.layout.new_quick);
        
        edit_location = (EditText) findViewById(R.id.edit_location);        
        edit_location.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
    	   	    startActivity(intent);
			}
		});
	}
	
}
