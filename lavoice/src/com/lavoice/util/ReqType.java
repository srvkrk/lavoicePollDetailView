package com.lavoice.util;

public enum ReqType {
	
	PARTICIPATION("PARTICIPATION",1),
	COLLABORATION("COLLABORATION",2);
	
	private String name;
	private int value;
	
	ReqType(String argName, int argValue){
		name = argName;
		value = argValue;
	}
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
	
	public static ReqType getEnum(String arg){
		if(arg.contentEquals("1"))
			return ReqType.PARTICIPATION;
	    if(arg.contentEquals("2"))
	    	return ReqType.COLLABORATION;
	    return null;
	}

}
