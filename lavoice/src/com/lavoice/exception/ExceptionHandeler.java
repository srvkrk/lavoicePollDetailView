package com.lavoice.exception;

import java.nio.channels.NetworkChannel;

import org.bson.json.JsonParseException;
import org.json.JSONException;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoException;
import com.mongodb.WriteConcernException;
import com.mongodb.util.JSONParseException;

public class ExceptionHandeler extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private static String qwerty;
	
  
    
    public  void checkException(Exception e,String block) {
       
        if (e instanceof NumberFormatException) {
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof JsonParseException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof JSONParseException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof JSONException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof DuplicateKeyException){
            System.out.println(e);//mongodb
            System.out.println(block);
            
        }
        else if(e instanceof NetworkChannel){
            System.out.println(e);//mongodb
            System.out.println(block);
            
        }
        else if(e instanceof WriteConcernException){
            System.out.println(e);//mongodb
            System.out.println(block);
            
        }
        else if(e instanceof MongoException){
            System.out.println(e);//mongodb
            System.out.println(block);
            
        }
        else if(e instanceof ArithmeticException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof StringIndexOutOfBoundsException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof ArrayIndexOutOfBoundsException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof ArrayStoreException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof IllegalThreadStateException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof ClassCastException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof EnumConstantNotPresentException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof IllegalArgumentException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof IllegalMonitorStateException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof IllegalStateException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof IndexOutOfBoundsException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof NegativeArraySizeException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof NullPointerException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof SecurityException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof TypeNotPresentException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof UnsupportedOperationException){
            System.out.println(e);
            System.out.println(block);
        }
        
        else if(e instanceof ClassNotFoundException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof CloneNotSupportedException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof IllegalAccessException){
            System.out.println(e);
            System.out.println(block);
        }
        else if(e instanceof InstantiationException){
            System.out.println(e);System.out.println(block);
        }
        else if(e instanceof InterruptedException){
            System.out.println(e);System.out.println(block);
        }
        else if(e instanceof NoSuchFieldException){
            System.out.println(e);System.out.println(block);
        }
        else if(e instanceof NoSuchMethodException){
            System.out.println(e);System.out.println(block);
        }
    }
}

