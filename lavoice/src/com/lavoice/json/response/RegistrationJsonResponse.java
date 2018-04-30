package com.lavoice.json.response;

import com.lavoice.bean.RegistrationResponse;

public class RegistrationJsonResponse {
	private String responseMessage;

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(RegistrationResponse response) {
		this.responseMessage = "{" +
				"\"error\":\"" + "false" + '\"' +
				",\"firstname\":\"" + response.getFirstname() + '\"' +
                ",\"lastname\":\"" + response.getLastname() + '\"' +
                ",\"email\":\"" + response.getUsername() + '\"' +
                ",\"id\":\"" + response.getId() + '\"' +
                
                '}';
	}
	
	public void setResponseError(String s) {
		this.responseMessage = "{" +
				"\"Error\":\"" + "true" + '\"' +
				",\"ErrorMessage\":\"" + s + '\"' +
                '}';
	}
}
