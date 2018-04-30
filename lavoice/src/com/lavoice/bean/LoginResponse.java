package com.lavoice.bean;

import java.util.List;

public class LoginResponse {
	
	private String userEmail;
	private String profilePic;
	private String imageBackground;
    private String firstname;
    private String lastname;
    private String emailVerified;
    private List<PollCreate> poll;
    private List<Friend> friendList;
    private List<Group> myGroups;
    private List<NotificationRequestContent> pollReq;
    private List<NotificationRequestContent> colaborationReq;
	
    
    public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getImageBackground() {
		return imageBackground;
	}
	public void setImageBackground(String imageBackground) {
		this.imageBackground = imageBackground;
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
	public String getEmailVerified() {
		return emailVerified;
	}
	public void setEmailVerified(String emailVerified) {
		this.emailVerified = emailVerified;
	}
	public List<PollCreate> getPoll() {
		return poll;
	}
	public void setPoll(List<PollCreate> poll) {
		this.poll = poll;
	}
	public List<Friend> getFriendList() {
		return friendList;
	}
	public void setFriendList(List<Friend> friendList) {
		this.friendList = friendList;
	}
	public List<Group> getMyGroups() {
		return myGroups;
	}
	public void setMyGroups(List<Group> myGroups) {
		this.myGroups = myGroups;
	}
	public List<NotificationRequestContent> getPollReq() {
		return pollReq;
	}
	public void setPollReq(List<NotificationRequestContent> pollReq) {
		this.pollReq = pollReq;
	}
	public List<NotificationRequestContent> getColaborationReq() {
		return colaborationReq;
	}
	public void setColaborationReq(List<NotificationRequestContent> colaborationReq) {
		this.colaborationReq = colaborationReq;
	}
    
    
    
  
    
    
}
