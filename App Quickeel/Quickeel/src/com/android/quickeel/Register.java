package com.android.quickeel;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class Register extends Activity {

	   @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_home);
	    }

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.activity_home, menu);
	        return true;
	    }
}
