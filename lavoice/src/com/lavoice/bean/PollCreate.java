package com.lavoice.bean;

import java.util.Date;
import java.util.List;

import com.lavoice.util.PollPrivacyType;
import com.lavoice.util.PollPurposeType;
import com.lavoice.util.PollType;

public class PollCreate {
	private String CreaterEmail;
	private String pollId;
	private String pollTitle;
	private PollPurposeType pollPurposeType;
	private PollType pollOptionType;
	private Date startDateTime;
	private Date endDateTime;
	private List<String> emaiIdsToParticipate;
	private PollPrivacyType pollPrivacyType;
	private List<PollContent> pollContent;
	
	public String getCreaterEmail() {
		return CreaterEmail;
	}
	public void setCreaterEmail(String createrEmail) {
		CreaterEmail = createrEmail;
	}
	public String getPollId() {
		return pollId;
	}
	public void setPollId(String pollId) {
		this.pollId = pollId;
	}
	public String getPollTitle() {
		return pollTitle;
	}
	public void setPollTitle(String pollTitle) {
		this.pollTitle = pollTitle;
	}
	public PollPurposeType getPollPurposeType() {
		return pollPurposeType;
	}
	public void setPollPurposeType(PollPurposeType pollPurposeType) {
		this.pollPurposeType = pollPurposeType;
	}
	public PollType getPollOptionType() {
		return pollOptionType;
	}
	public void setPollOptionType(PollType pollOptionType) {
		this.pollOptionType = pollOptionType;
	}
	public Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	public Date getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	public List<String> getEmaiIdsToParticipate() {
		return emaiIdsToParticipate;
	}
	public void setEmaiIdsToParticipate(List<String> emaiIdsToParticipate) {
		this.emaiIdsToParticipate = emaiIdsToParticipate;
	}
	public PollPrivacyType getPollPrivacyType() {
		return pollPrivacyType;
	}
	public void setPollPrivacyType(PollPrivacyType pollPrivacyType) {
		this.pollPrivacyType = pollPrivacyType;
	}
	public List<PollContent> getPollContent() {
		return pollContent;
	}
	public void setPollContent(List<PollContent> pollContent) {
		this.pollContent = pollContent;
	}
	
	
}
