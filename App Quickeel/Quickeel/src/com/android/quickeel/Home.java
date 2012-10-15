package com.android.quickeel;




import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class Home extends Activity {

	Button btlogin;
	Button btRegistro;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        
        
        btlogin = (Button)findViewById(R.id.btlogin);
        btlogin.setOnClickListener( new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			
    			goDashboard();
    			
    		}
    	});
        
        btRegistro = (Button)findViewById(R.id.btRegistro);
        btRegistro.setOnClickListener( new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			
    			goRegister();
    			
    		}
    	});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }
    
    
    private void goDashboard() 
	   {
	       final Intent intent = new Intent(this, Dashboard.class);
	       this.startActivity (intent);
	   }
	   
    private void goRegister() 
	   {
	       final Intent intent = new Intent(this, Dashboard.class);
	       this.startActivity (intent);
	   }
}
