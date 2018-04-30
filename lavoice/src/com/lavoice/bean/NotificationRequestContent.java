package com.lavoice.bean;

import com.lavoice.util.ReqStatus;
import com.lavoice.util.ReqType;

public class NotificationRequestContent {
	private String pollId;
	private String pollUserEmail;
	private String pollQuestion;
	private String pollTitle;
	private ReqStatus status;
	private ReqType reqType;
	public String getPollId() {
		return pollId;
	}
	public void setPollId(String pollId) {
		this.pollId = pollId;
	}
	public String getPollUserEmail() {
		return pollUserEmail;
	}
	public void setPollUserEmail(String pollUserEmail) {
		this.pollUserEmail = pollUserEmail;
	}
	public String getPollQuestion() {
		return pollQuestion;
	}
	public void setPollQuestion(String pollQuestion) {
		this.pollQuestion = pollQuestion;
	}
	public String getPollTitle() {
		return pollTitle;
	}
	public void setPollTitle(String pollTitle) {
		this.pollTitle = pollTitle;
	}
	public ReqStatus getStatus() {
		return status;
	}
	public void setStatus(ReqStatus status) {
		this.status = status;
	}
	public ReqType getReqType() {
		return reqType;
	}
	public void setReqType(ReqType reqType) {
		this.reqType = reqType;
	}
	
	
}
