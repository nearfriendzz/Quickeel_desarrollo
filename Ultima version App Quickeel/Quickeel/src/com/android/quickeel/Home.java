package com.android.quickeel;




import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import com.actionbarsherlock.app.*;
import com.WazaBe.HoloEverywhere.sherlock.SActivity;

public class Home extends SActivity {

	Button btlogin;
	Button btRegistro;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	setTheme(R.style.Holo_Theme_Sherlock_Light_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        
        SharedPreferences settings = getSharedPreferences("UserPreferencias", MODE_PRIVATE);
        long idUser = settings.getLong("iduser",0);
        if(idUser != 0){
        	final Intent intent = new Intent(this, Dashboard.class);
   	       this.startActivityForResult(intent,300);
        }
        
        btlogin = (Button)findViewById(R.id.btlogin);
        btlogin.setOnClickListener( new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			
    			goLogin();
    			
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


  /*  public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }*/
    
    
    private void goLogin() 
	   {
	       final Intent intent = new Intent(this, Login.class);
	       this.startActivityForResult(intent,100);
	   }
	   
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if ((resultCode == 100)||(resultCode == 300)) {
	    	finish();
	    	
	    }
	   
	}
    
    private void goRegister() 
	   {
	       final Intent intent = new Intent(this, Register.class);
	       this.startActivityForResult(intent,200);
	   }
}
