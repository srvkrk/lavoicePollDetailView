package com.lavoice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.lavoice.bean.PollDetailResponse;
import com.lavoice.exception.ExceptionHandeler;

@Component
public class PollDetailDaoImpl implements PollDetailDao{
	private static String block;
	@Autowired
	  public ExceptionHandeler exp;
	@Autowired
    MongoOperations mongoTemplate;
	@Autowired
	PollDetailResponse polldetailresponse;
    final String COLLECTION = "pollInfo";
    
    public PollDetailResponse find(String pollId)
    {

    	try{
    		
    		Query query = new Query(Criteria.where("pollId").is(pollId));
            
    		polldetailresponse=mongoTemplate.findOne(query, PollDetailResponse.class, COLLECTION);
        }
        catch(Exception e){
        	block="poll detail Dao";
            exp.checkException(e,block);
        }
    	 return polldetailresponse; 
    }

}
