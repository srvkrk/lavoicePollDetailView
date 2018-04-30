package com.lavoice.bean;

import java.io.Serializable;

public class LoginRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@com.owlike.genson.annotation.JsonProperty("username")
    private String username;
	@com.owlike.genson.annotation.JsonProperty("password")
    private String password;

    public LoginRequest() {
        username="";
        password="";
    }
    
    public LoginRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
