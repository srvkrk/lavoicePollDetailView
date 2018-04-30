package com.lavoice.util;

public enum PollPurposeType {

	Private("Private",1),
	Business("Business",2);
	
	private String name;
	private int value;
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
	
	PollPurposeType(String argName, int argValue){
		name = argName;
		value = argValue;
	}
	
	public static PollPurposeType getEnum(String arg) {
		if(arg.contentEquals("1"))
			return PollPurposeType.Private;
	    if(arg.contentEquals("2"))
	    	return PollPurposeType.Business;
	    return null;
	}
}
