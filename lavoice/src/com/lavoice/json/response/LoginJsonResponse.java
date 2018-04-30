package com.lavoice.json.response;

import com.lavoice.bean.LoginResponse;

public class LoginJsonResponse {
	private String responseMessage;

	public String getResponseMessage() {
		return responseMessage;
	}
	
	public void setResponseMessage(LoginResponse response) {
		this.responseMessage = "{" +
				"\"error\":\"" + "false" + '\"' +
				",\"_Id\":\"" + response.getId() + '\"' +
				",\"username\":\"" + response.getUsername() + '\"' +
                ",\"firstname\":\"" + response.getFirstname() + '\"' +
                ",\"lastname\":\"" + response.getLastname() + '\"' +
                ",\"emailVerified\":\"" + response.getEmailVerified() + '\"' +
                '}';
	}
	
	public void setResponseError(String message) {
		this.responseMessage = "{" +
				"\"Error\":\"" + "true" + '\"' +
				",\"ErrorMessage\":\"" + message + '\"' +
                '}';
	}
}
