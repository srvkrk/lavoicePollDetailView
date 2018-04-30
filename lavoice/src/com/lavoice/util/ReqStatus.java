package com.lavoice.util;

public enum ReqStatus {
	
	PENDING("PENDING",1),
	REJECT("REJECT",2),
	ACCEPT("ACCEPT",3);
	
	private String name;
	private int value;
	
	ReqStatus(String argName, int argValue){
		name = argName;
		value = argValue;
	}
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return value;
	}
	
	public static ReqStatus getEnum(String arg){
		if(arg.contentEquals("1"))
			return ReqStatus.PENDING;
	    if(arg.contentEquals("2"))
	    	return ReqStatus.REJECT;
	    if(arg.contentEquals("3"))
	    	return ReqStatus.ACCEPT;
	    return null;
	}
}
