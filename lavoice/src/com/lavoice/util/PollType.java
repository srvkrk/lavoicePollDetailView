package com.lavoice.util;

public enum PollType {

	MCQ("MCQ",1),
	OpenText("OpenText",2),
	Ratting("Ratting",3);
	
	private String name;
	private int value;
	
	PollType(String argName, int argValue){
		name = argName;
		value = argValue;
	}
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
	
	public static PollType getEnum(String arg){
		if(arg.contentEquals("1"))
			return PollType.MCQ;
	    if(arg.contentEquals("2"))
	    	return PollType.OpenText;
	    if(arg.contentEquals("3"))
	    	return PollType.Ratting;
	    return null;
	}
}
