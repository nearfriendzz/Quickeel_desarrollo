package com.android.quickeel;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONStringer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.actionbarsherlock.app.*;
import com.WazaBe.HoloEverywhere.sherlock.SActivity;

public class Register extends SActivity {

	private final static String SERVICE_URI = "http://quickeel.com/WSQuickeel.svc"; //"http://192.168.1.131/QuickService/WSQuickeel.svc";
	 public EditText edit_registro_nombre;
	  public EditText edit_registro_email;
	  public EditText edit_registro_password;
	  public EditText edit_registro_password_ver;
	  public Button btJoin;
	   @Override
	    public void onCreate(Bundle savedInstanceState) {
		   	setTheme(R.style.Holo_Theme_Sherlock_Light_NoActionBar);
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.register);
	     
	        
	        btJoin = (Button) findViewById(R.id.btJoin);
	        btJoin.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) 
				{
					JoinAccount();
				}
	        });
	        
	    }

	    
	    
	    //Registrar usuario Quickeel
	    public void Registrarse(UserRequest userRequest){
	    	try { 
		        HttpPost httpost = new HttpPost(SERVICE_URI+"/PostRegister"); 
		        HttpClient httpclient = new DefaultHttpClient();  
		        JSONStringer img = new JSONStringer() 
		            .object() 
		            .key("user") 
		                .object() 
		                    .key("fullname").value(userRequest.getNombre()) 
		                    .key("email").value(userRequest.getEmail()) 
		                    .key("password").value(userRequest.getPassword()) 
		                .endObject() 
		            .endObject(); 
		            StringEntity se = new StringEntity(img.toString()); 

		        httpost.setEntity(se); 

		        httpost.setHeader("Accept", "application/json"); 
		        httpost.setHeader("Content-type", "application/json"); 

		       // return httpclient.execute(httpost); 
		        
		      //  HttpResponse response = client.execute(request);  
		        HttpResponse response = httpclient.execute(httpost);
	            String re = EntityUtils.toString(response.getEntity());  
	           // response.getStatusLine().getStatusCode();
	            int responseCode = response.getStatusLine().getStatusCode();
	            switch(responseCode)
	            {
	                case 200:
	                    HttpEntity entity = response.getEntity();
	             if(entity != null)
	             {
	              //String responseBody = EntityUtils.toString(entity);
	            	 Intent intent = new Intent(getApplicationContext(), Dashboard.class);
					 this.startActivity(intent);
					 finish();
	             }
	                    break;
	            } 
	           
	            
		        } catch (Exception e) {  
	                //e.printStackTrace();  
		        	AlertDialog alertDialog = new AlertDialog.Builder(this).create();
	            	alertDialog.setTitle("Upss!");
	            	alertDialog.setMessage("Ya hay una cuenta asociada a este Email, intente con otro");
	            	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	            	   public void onClick(DialogInterface dialog, int which) {
	            	      // here you can add functions
	            	   }
	            	});
	            	alertDialog.setIcon(R.drawable.smile);
	            	alertDialog.show();
	            	
	            }  
	    }
	    
	    private void JoinAccount(){
	    	
	    	UserRequest userRequest = new UserRequest();
	        int i = 0;   
	        edit_registro_nombre = (EditText)findViewById(R.id.edit_registro_nombre);
	        edit_registro_email = (EditText)findViewById(R.id.edit_registro_email);
	        edit_registro_password = (EditText)findViewById(R.id.edit_registro_password);
	        edit_registro_password_ver = (EditText)findViewById(R.id.edit_registro_password_ver);
	        
	        if(edit_registro_nombre.getText().length()==0)
	        {
	        	edit_registro_nombre.setError(getResources().getString(R.string.msg_registro_campo));
	        }else{
	        	userRequest.setNombre(edit_registro_nombre.getText().toString());
	        	i = i+1;
	        }
	        
	        if(edit_registro_email.getText().length()==0)
	        {
	        	edit_registro_email.setError(getResources().getString(R.string.msg_registro_campo));
	        }else{
	        	userRequest.setEmail(edit_registro_email.getText().toString());
	        	i = i+1;
	        }
	    	
	        if(edit_registro_password.getText().length()==0)
	        {
	        	edit_registro_password.setError(getResources().getString(R.string.msg_registro_campo));
	        }else{
	        	userRequest.setPassword(edit_registro_password.getText().toString());
	        	i = i+1;
	        }
	        

	        if(edit_registro_password_ver.getText().equals(edit_registro_password.getText().toString()))
	        {
	        	edit_registro_password_ver.setError(getResources().getString(R.string.msg_registro_campo_ver));
	        }else{
	        	
	        	i = i+1;
	        }
	        
	        if(i == 4)
	        {
	        	Registrarse(userRequest);
	        }

	    	
	    }
}
