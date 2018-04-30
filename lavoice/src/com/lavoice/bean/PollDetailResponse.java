package com.lavoice.bean;

import java.util.Date;

import com.lavoice.util.PollMediaType;
import com.lavoice.util.PollPrivacyType;
import com.lavoice.util.PollPurposeType;
import com.lavoice.util.PollType;

public class PollDetailResponse {
	private String CreaterEmail;
	private String pollQuestions;
	private String pollTitle;
	private PollPurposeType pollPurposeType;
	private PollMediaType OptionMediaType;
	private PollPrivacyType pollPrivacyType;
	private PollType pollOptionType;
	private Date startDateTime;
	private Date endDateTime;
	 
	public String getCreaterEmail() {
		return CreaterEmail;
	}
	public void setCreaterEmail(String createrEmail) {
		CreaterEmail = createrEmail;
	}
	public String getPollQuestions() {
		return pollQuestions;
	}
	public void setPollQuestions(String pollQuestions) {
		this.pollQuestions = pollQuestions;
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
	public PollMediaType getOptionMediaType() {
		return OptionMediaType;
	}
	public void setOptionMediaType(PollMediaType optionMediaType) {
		OptionMediaType = optionMediaType;
	}
	public PollPrivacyType getPollPrivacyType() {
		return pollPrivacyType;
	}
	public void setPollPrivacyType(PollPrivacyType pollPrivacyType) {
		this.pollPrivacyType = pollPrivacyType;
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
	@Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("CreaterEmail:- " + getCreaterEmail() + ", PollQuestions:- " + getPollQuestions()
        +"PollTitle:- " + getPollTitle()+ "PollPurposeType:- " + getPollPurposeType()
        +"OptionMediaType:-" + getOptionMediaType()+ "PollPrivacyType:-" + getPollPrivacyType()
        +"PollOptionType:-" + getPollOptionType()+ "StartDateTime:-" + getStartDateTime()
        +"EndDateTime:-" + getEndDateTime());
        return str.toString();
    }
}
