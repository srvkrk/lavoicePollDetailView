package com.lavoice.bean;

import java.util.List;

public class PollContent {
	
	private String pollQuestions;
	
	private List<PollOption> pollOption;

	public String getPollQuestions() {
		return pollQuestions;
	}

	public void setPollQuestions(String pollQuestions) {
		this.pollQuestions = pollQuestions;
	}

	public List<PollOption> getPollOption() {
		return pollOption;
	}

	public void setPollOption(List<PollOption> pollOption) {
		this.pollOption = pollOption;
	}
	
	

	
}
