package com.lavoice.util;

public enum PollPrivacyType {

	ClosedGroup("ClosedGroup",1),
	Public("Public",2);
	
	private String name;
	private int value;
	
	PollPrivacyType(String argName, int argValue){
		name = argName;
		value = argValue;
	}
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
	
	public static PollPrivacyType getEnum(String arg){
		if(arg.contentEquals("1"))
			return PollPrivacyType.ClosedGroup;
	    if(arg.contentEquals("2"))
	    	return PollPrivacyType.Public;
	    return null;
	}
}
