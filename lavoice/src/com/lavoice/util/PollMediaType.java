package com.lavoice.util;

public enum PollMediaType {

	TEXT("Text",1),
	AUDIO("Audio",2),
	VIDEO("Video",3),
	IMAGE("Image",4),
	MXIED("Mixed",5);
	
	private String name;
	private int value;
	
	PollMediaType(String argName, int argValue){
		name = argName;
		value = argValue;
	}
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
	
	public static PollMediaType getEnum(String arg){
		if(arg.contentEquals("1"))
			return PollMediaType.TEXT;
	    if(arg.contentEquals("2"))
	    	return PollMediaType.AUDIO;
	    if(arg.contentEquals("3"))
	    	return PollMediaType.VIDEO;
	    if(arg.contentEquals("4"))
	    	return PollMediaType.IMAGE;
	    if(arg.contentEquals("5"))
	    	return PollMediaType.MXIED;
	    return null;
	}
	
}
