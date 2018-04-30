package com.lavoice.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userInfo")
public class RegistrationResponse {
	@Id
    private String id;

    private String firstname;
    private String lastname;

    private String username;

    public RegistrationResponse(String firstname,String lastname,String username)
	 {
		 super();
	        this.firstname=firstname;
	        this.lastname = lastname;
	        this.setUsername(username);
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
}
