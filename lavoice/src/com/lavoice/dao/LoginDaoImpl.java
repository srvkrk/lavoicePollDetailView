package com.lavoice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.lavoice.bean.LoginResponse;
import com.lavoice.exception.ExceptionHandeler;

@Component
public class LoginDaoImpl implements LoginDao {
	private static String block;
	@Autowired
	  public ExceptionHandeler exp;
	@Autowired
    MongoOperations mongoTemplate;
	@Autowired
	LoginResponse loginResponse;
    final String COLLECTION = "userInfo";
    
    public LoginResponse find(String username)
    {

    	try{
    		
    		Query query = new Query(Criteria.where("username").is(username));
            
    		loginResponse=mongoTemplate.findOne(query, LoginResponse.class, COLLECTION);
        }
        catch(Exception e){
        	block="login Dao";
            exp.checkException(e,block);
        }
    	 return loginResponse; 
    }

}
