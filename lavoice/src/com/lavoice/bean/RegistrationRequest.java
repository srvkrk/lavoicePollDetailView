package com.lavoice.bean;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 
@Document(collection = "userInfo")
public class RegistrationRequest {
	 @Id
	    private String id;
	 @NotNull
	    private String firstname;
	 @NotBlank(message = "Task description must not be blank!")
	    private String lastname;
	 @Email
	    private String email;
	 	private String username;
	    private String password;
	    private String dob;
	 public RegistrationRequest(String firstname,String lastname,String email, String password,String dob)
	 {
		 super();
	     this.firstname=firstname;
	     this.lastname = lastname;
	     this.email=email;
	     this.password=password;
	     this.dob=dob;
		 this.username=email;
	 }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	 
	
}
