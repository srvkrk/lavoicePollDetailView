package com.lavoice.json.response;

import com.lavoice.bean.PollDetailResponse;

public class PollDetailJsonResponse {
	private String responseMessage;

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(PollDetailResponse response) {
		this.responseMessage = "{" +
				"\"error\":\"" + "false" + '\"' +
				",\"CreaterEmail\":\"" + response.getCreaterEmail() + '\"' +
                ",\"pollQuestions\":\"" + response.getPollQuestions() + '\"' +
                ",\"pollTitle\":\"" + response.getPollTitle() + '\"' +
                ",\"pollPurposeType\":\"" + response.getPollPurposeType() + '\"' +
                ",\"OptionMediaType\":\"" + response.getOptionMediaType() + '\"' +
                ",\"pollPrivacyType\":\"" + response.getPollPrivacyType() + '\"' +
                ",\"pollOptionType\":\"" + response.getPollOptionType() + '\"' +
                ",\"startDateTime\":\"" + response.getStartDateTime() + '\"' +
                ",\"endDateTime\":\"" + response.getEndDateTime() + '\"' +
                
                '}';
	}
	
	public void setResponseError(String s) {
		this.responseMessage = "{" +
				"\"Error\":\"" + "true" + '\"' +
				",\"ErrorMessage\":\"" + s + '\"' +
                '}';
	}
}
