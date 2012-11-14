package com.android.quickeel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.WazaBe.HoloEverywhere.sherlock.SActivity;

public class Login extends SActivity {

	  private final static String SERVICE_URI = "http://quickeel.com/WSQuickeel.svc";//"http://192.168.1.131/QuickService/WSQuickeel.svc";
	  public Button btlogin;
	  public EditText edit_usuario;
	  public EditText edit_password;
	  private String _email ;
	  private String _pass;
	  private int _validaEmail,_validaPassword;
	  private SharedPreferences settings;
	   @Override
	    public void onCreate(Bundle savedInstanceState) {
		   setTheme(R.style.Holo_Theme_Sherlock_Light_NoActionBar);
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.login);
	        
	        edit_usuario = (EditText)findViewById(R.id.edit_usuario);
	        edit_password = (EditText)findViewById(R.id.edit_password);
	        
	        btlogin = (Button) findViewById(R.id.btlogin);
	        btlogin.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (edit_usuario.getText().length() == 0)
					{
						edit_usuario.setError(getResources().getString(R.string.msg_login_email));
						_validaEmail = 1;
					}else{
						_validaEmail = 0;
					}
					
					if(edit_password.getText().length()==0)
					{
						edit_password.setError(getResources().getString(R.string.msg_login_password));
						_validaPassword = 1;
					}else{
						_validaPassword = 0;
					}
					
					if ((_validaEmail == 0)&&(_validaEmail==0))
					{
						//Llamada metodo de iniciar sesión
						InicioSesion(edit_usuario.getText().toString(),edit_password.getText().toString());
					}
					
					
				}
			});
	       
	        
	    }

	   
	  
	    
	    
	    private void login(String email , String pass) {
	    	 
	    	//private final static String SERVICE_URI = "http://10.0.2.2/tytservice/Service.svc";    
	    	try {
	    	            // Send GET request to <service>/GetPlates
	    	            HttpGet request = new HttpGet(SERVICE_URI + "/Hello");
	    	            request.setHeader("Accept", "application/json");
	    	            request.setHeader("Content-type", "application/json");

	    	            DefaultHttpClient httpClient = new DefaultHttpClient();
	    	            HttpResponse response = httpClient.execute(request);

	    	            HttpEntity responseEntity = response.getEntity();

	    	            // Read response data into buffer
	    	            char[] buffer = new char[(int)responseEntity.getContentLength()];
	    	            InputStream stream = responseEntity.getContent();
	    	            InputStreamReader reader = new InputStreamReader(stream);
	    	            reader.read(buffer);
	    	            stream.close();

	    	            String data = new String(buffer);
	    	            Log.i("Metodo", data);
	    	            Toast.makeText(this,data,Toast.LENGTH_LONG).show();
	    	 } catch (Exception e) {
		            e.printStackTrace();
		        }
	    /*    try {
	     
	      email= "aa";
	      pass= "bb";
	            boolean isValid = true;
	     
	            // Data validation goes here
	     
	            if (isValid) {
	     
	                // POST request to <service>/SaveVehicle
	                HttpPost request = new HttpPost(SERVICE_URI + "/DoLogin");
	                request.setHeader("Accept", "application/json");
	                request.setHeader("Content-type", "application/json");
	     
	                // Build JSON string
	                JSONStringer logindata = new JSONStringer()
	                    .object()
	                        .key("login")
	                            .object()
	                                .key("email").value(email)
	                                .key("password").value(pass)
	                            .endObject()
	                        .endObject();
	                StringEntity entity = new StringEntity(logindata.toString());
	     
	                request.setEntity(entity);
	     
	                // Send request to WCF service
	                DefaultHttpClient httpClient = new DefaultHttpClient();
	                HttpResponse response = httpClient.execute(request);
	     
	                Log.d("WebInvoke", "Saving : " + response.getStatusLine().toString());
	                 Log.i("WebInvoke", "Saving : " + response.getStatusLine().getStatusCode());
	                 Log.i("WebInvoke", "Saving : " + "Prueba babababab");
	                 Toast.makeText(this, "lalalala",3);
	                // Reload plate numbers
	               // refreshVehicles();
	            }
	     
	        } catch (Exception e) {
	            e.printStackTrace();
	        }*/
	    }
	    
	  
	    public static String convertStreamToString(InputStream is)
	    {
	    	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    	StringBuilder sb = new StringBuilder();

	    	String line = null;
	    	try {
	    		while ((line = reader.readLine()) != null) {
	    			sb.append(line + "\n");
	    		}
	    	}
	    	catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	finally {
	    		try {
	    			is.close();
	    		} catch (IOException e) {
					e.printStackTrace();
	    		}
	    	}
	    	return sb.toString();
	    }
	    
	    
	    
	    public void verifyLogin(String UserName,String Password)
	    {
	        try {  
                HttpClient client = new DefaultHttpClient();  

                HttpPost request = new HttpPost(SERVICE_URI+"/SendMessageByPost1");  

              
                JSONObject p = new JSONObject();  
                p.put("value", 4);  
                p.put("message", "ccc");  
                
                /*  JSONStringer logindata = new JSONStringer()
                .object()
                    .key("login")
                        .object()
                            .key("email").value(4)
                            .key("password").value("ccccccc")
                        .endObject()
                    .endObject();*/
                
                request.setEntity(new StringEntity(p.toString()));  
                
                request.setHeader(HTTP.CONTENT_TYPE, "text/json");  

                HttpResponse response = client.execute(request);  
                String re = EntityUtils.toString(response.getEntity());  
                Toast.makeText(this, re,  
                        Toast.LENGTH_SHORT).show();  
                
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
	}
	    
	    
	    //Iniciar Sesion usuario Quickeel
	    public void InicioSesion(String email, String password)
	    {
	    	HttpResponse response = null;
	    	String re = "0";
	    	
	        try {  
                HttpClient client = new DefaultHttpClient();  

                HttpPost request = new HttpPost(SERVICE_URI+"/InicioSesion");  
                JSONObject json = new JSONObject();
                          
                JSONObject p = new JSONObject();  
                p.put("email", email);  
                p.put("password", password);  
                
                
                request.setEntity(new StringEntity(p.toString()));  
                request.setHeader(HTTP.CONTENT_TYPE, "text/json");  
                
	            
                response  = client.execute(request);  
                 re = EntityUtils.toString(response.getEntity());  
               // HttpEntity entity = response.getEntity();
               
               if (response.getStatusLine().getStatusCode() == 200){
            	   preferencias(re);
                	 
                }
               else{
            	   AlertDialog alertDialog = new AlertDialog.Builder(this).create();
               	alertDialog.setTitle("Upss!.");
               	alertDialog.setMessage(response.getStatusLine().toString());
               	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
               	   public void onClick(DialogInterface dialog, int which) {
               	      // here you can add functions
               	   }
               	});
               	alertDialog.setIcon(R.drawable.smile);
               	alertDialog.show();
               }

                
            } catch (Exception e) {  
            	AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            	alertDialog.setTitle("Upss!.");
            	alertDialog.setMessage(response.getStatusLine().toString());
            	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            	   public void onClick(DialogInterface dialog, int which) {
            	      // here you can add functions
            	   }
            	});
            	alertDialog.setIcon(R.drawable.smile);
            	alertDialog.show();
               // e.printStackTrace();  
            }  
	        
	}
 
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		    if ((resultCode == 200)||(resultCode == 300)) {
		    	setResult(100);
		    	finish();
		    	
		    }
		  
		}
	    
	    /**
	     * @param results
	     */
	    private void preferencias(String results){

	    	try{
	    		 JSONObject json = new JSONObject(results);
	    		  JSONArray nameArray = json.names();
	    		 JSONArray ja = json.toJSONArray(nameArray);
	    				// ITERATE THROUGH AND RETRIEVE CLUB FIELDS
	    				int n = ja.length();
	    				for (int i = 0; i < n; i++) {
	    					// GET INDIVIDUAL JSON OBJECT FROM JSON ARRAY
	    					JSONObject jo = ja.getJSONObject(i);
	    					
	    					// RETRIEVE EACH JSON OBJECT'S FIELDS
	    					long id = jo.getLong("iduser");
	    					String fullname = jo.getString("fullname");
	    					String email = jo.getString("email");
	    					String password = jo.getString("password");
	    					String Error = jo.getString("messageerror");
	    					/*double clat = jo.getDouble("lat");
	    					double clon = jo.getDouble("lon");
	    					String url = jo.getString("url");
	    					String number = jo.getString("number");*/
	    					
	    					SharedPreferences prefs =
	    						     getSharedPreferences("UserPreferencias",Context.MODE_PRIVATE);
	    						 
	    						SharedPreferences.Editor editor = prefs.edit();
	    						editor.putLong("iduser", id);
		    		    		editor.putString("fullname", fullname);
		    		    		editor.putString("email", email);
		    		    		editor.putString("password", password);
	    						editor.commit();
	    						
	    						 Intent intent = new Intent(getApplicationContext(), Dashboard.class);
	    						 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    						 this.startActivityForResult(intent, 200);
	    		 		    	// finish();
	    		 		    	 
	    		 		 
	    				}
	    			} catch (Exception e) {
	    				e.printStackTrace();
	    			}
	    			
	    //	    	   JSONArray nameArray = json.names();
	    	          //  JSONArray valArray = json.toJSONArray(nameArray);
	    		//Get the element that holds the earthquakes ( JSONArray )
	    	    	//   JSONArray nameArray = json.names();
	    	//	JSONArray  earthquakes = json.getJSONArray(nameArray.toString());
	    		//JSONObject e = UserResponde.getJSONObject(1);
	    	           // valArray.getString("");
	        	//String s1 = valArray.getString(0);
	    	/*	String s1 = e.getString("email");
	        	s1 +=e.getString("password");
	        	s1 +=e.getString("createdate");
	        	s1 +=e.getString("createupdate");
	        	s1 +=e.getString("messageerror");*/
	    	 
	    	       
	    		/*SharedPreferences.Editor editor = settings.edit();
	    		editor.putString("Login", sUserName);
	    		editor.putString("Password", sPassword);
	    		editor.commit();*/
	    	
	    }
	    
	    
	    public static JSONObject getJSONfromURL(InputStream results){

	    	//initialize
	    	InputStream is = results;
	    	String result = "";
	    	JSONObject jArray = null;

	    	//http post
	    /*	try{
	    		HttpClient httpclient = new DefaultHttpClient();
	    		HttpPost httppost = new HttpPost(url);
	    		HttpResponse response = httpclient.execute(httppost);
	    		HttpEntity entity = response.getEntity();
	    		is = entity.getContent();

	    	}catch(Exception e){
	    		Log.e("log_tag", "Error in http connection "+e.toString());
	    	}*/

	    	//convert response to string
	    	try{
	    		BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
	    		StringBuilder sb = new StringBuilder();
	    		String line = null;
	    		while ((line = reader.readLine()) != null) {
	    			sb.append(line + "\n");
	    		}
	    		is.close();
	    		result=sb.toString();
	    	}catch(Exception e){
	    		Log.e("log_tag", "Error converting result "+e.toString());
	    	}

	    	//try parse the string to a JSON object
	    	try{
	            	jArray = new JSONObject(result);
	    	}catch(JSONException e){
	    		Log.e("log_tag", "Error parsing data "+e.toString());
	    	}
	    	

	    	return jArray;
	    } 
	    
	
	    
	    public void TestPost() 
	    { 
	    	try { 
	        HttpPost httpost = new HttpPost(SERVICE_URI+"/TestPost"); 
	        HttpClient httpclient = new DefaultHttpClient();  
	        JSONStringer img = new JSONStringer() 
	            .object() 
	            .key("tm") 
	                .object() 
	                    .key("p1").value("test") 
	                    .key("p2").value("test") 
	                    .key("p3").value(1) 
	                    .key("p4").value("test") 
	                    .key("p5").value(2) 
	                    .key("p6").value("test;test") 
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
            if (re =="1"){
            	  Toast.makeText(this, "Conectado",  
                          Toast.LENGTH_SHORT).show();  
            }
            else{
            	if (re== "0"){
            	AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            	alertDialog.setTitle(".");
            	alertDialog.setMessage("Esta cuenta no es valida");
            	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            	   public void onClick(DialogInterface dialog, int which) {
            	      // here you can add functions
            	   }
            	});
            	alertDialog.setIcon(R.drawable.logo);
            	alertDialog.show();
            	}
            }
            
	        } catch (Exception e) {  
                e.printStackTrace();  
            }  
	    }
	
	    
	/*    public void Credential() 
	    { 
	    	try { 
	        HttpPost httpost = new HttpPost(SERVICE_URI+"/TestPost"); 
	        HttpClient httpclient = new DefaultHttpClient();  
	        JSONStringer img = new JSONStringer() 
	            .object() .key("tm") .object() 
	                    .key("p1").value(email) 
	                    .key("p2").value(password) 
	                    .key("p3").value(1) 
	                    .key("p4").value("test") 
	                    .key("p5").value(2) 
	                    .key("p6").value("test;test") 
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
            if (re =="1"){
            	  Toast.makeText(this, "Conectado",  
                          Toast.LENGTH_SHORT).show();  
            }
            else{
            	if (re== "0"){
            	AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            	alertDialog.setTitle(".");
            	alertDialog.setMessage("Esta cuenta no es valida");
            	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            	   public void onClick(DialogInterface dialog, int which) {
            	      // here you can add functions
            	   }
            	});
            	alertDialog.setIcon(R.drawable.logo);
            	alertDialog.show();
            	}
            }
            
	        } catch (Exception e) {  
                e.printStackTrace();  
            }  
	    }*/
	    
	    
public void Save(){
	
	HttpClient httpclient = new DefaultHttpClient();
	 HttpPost httppost = new HttpPost(SERVICE_URI+"/AdicionarNovoUsuario");
	 //"http://www.diegoampessan.com.br/servicos/WCF/WCFRest.svc/AdicionarNovoUsuario");

	try {

	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
	 2);
	 nameValuePairs.add(new BasicNameValuePair("email",
	 "ampessann@gmail.com"));
	 nameValuePairs.add(new BasicNameValuePair("password",
	 "mypassoowrd"));
	
	 httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	Log.i("Enviando:", nameValuePairs.toString());

	// Execute HTTP Post Request
	 HttpResponse response = httpclient.execute(httppost);

	HttpEntity responseEntity = response.getEntity();
	 char[] buffer = new char[(int) responseEntity
	 .getContentLength()];

	try {
	 InputStream stream = responseEntity.getContent();
	 InputStreamReader reader = new InputStreamReader(stream);

	reader.read(buffer);
	 stream.close();
	 reader.close();

	} catch (IOException e) {

	e.printStackTrace();
	 }

	String teste = new String(buffer);
	 //txtPOST.setText(teste);

	} catch (ClientProtocolException e) {
	 // TODO Auto-generated catch block
	 } catch (IOException e) {
	 // TODO Auto-generated catch block
	 }
	 }

	   
}

	    

