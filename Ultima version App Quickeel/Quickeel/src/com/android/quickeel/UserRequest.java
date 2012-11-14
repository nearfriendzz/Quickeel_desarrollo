package com.android.quickeel;

public class UserRequest {

	private String nombre; 
	private String email; 
	private String password; 
	

	public UserRequest( ){ } 

	// Aquí empezamos a declarar gets y sets 

	public String getNombre( ){ 
	return this.nombre; 
	} 

	public void setNombre(String nombre){ 
	this.nombre = nombre; 
	} 

	public String getEmail( ){ 
	return this.email; 
	} 

	public void setEmail(String email){ 
	this.email = email; 
	} 

	public String getPassword( ){ 
	return this.password; 
	} 

	public void setPassword(String password){ 
	this.password= password; 
	} 


}
