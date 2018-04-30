package com.lavoice.bean;

import java.util.List;

public class Group {
	private String groupId;
	private String groupName;
	private String groupImage;
	private List<Friend> friend;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupImage() {
		return groupImage;
	}
	public void setGroupImage(String groupImage) {
		this.groupImage = groupImage;
	}
	public List<Friend> getFriend() {
		return friend;
	}
	public void setFriend(List<Friend> friend) {
		this.friend = friend;
	}
	
}
