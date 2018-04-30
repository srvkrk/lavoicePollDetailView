package com.lavoice.bean;

import java.io.Serializable;

public class PollDetailRequest implements Serializable {
private static final long serialVersionUID = 1L;
	
	@com.owlike.genson.annotation.JsonProperty("pollId")
    private String pollId;
	public PollDetailRequest() {
        pollId="";
    }
	public PollDetailRequest(String pollId) {
		this.setPollId(pollId);
	}
	public String getPollId() {
		return pollId;
	}
	public void setPollId(String pollId) {
		this.pollId = pollId;
	}
    
 }
