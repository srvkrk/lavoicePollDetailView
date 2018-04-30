package com.lavoice.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavoice.bean.PollDetailRequest;
import com.lavoice.bean.PollDetailResponse;
import com.lavoice.dao.PollDetailDao;
import com.lavoice.exception.ExceptionHandeler;
import com.lavoice.json.response.PollDetailJsonResponse;
  
@Service("polldetailService")
public class PollDetailServiceImpl implements PollDetailService {
	  private static String block;
		@Autowired
		  public ExceptionHandeler exp;
		
		@Autowired
	    PollDetailDao polldetailDao;
		
		public String find(PollDetailRequest polldetailRequest) {
			PollDetailJsonResponse body = new PollDetailJsonResponse();		
			try{		
				PollDetailResponse polldetailResponse = polldetailDao.find(PollDetailRequest.getPollId());
				
				if(PollDetailResponse==null) {
					body.setResponseError("Invalid PollId");
				}
				else {
			        	PollDetailResponse polldetailResponse = new PollDetailResponse(PollDetailResponse.getCreaterEmail(), PollDetailResponse.getPollQuestions(),
			        	PollDetailResponse.getPollTitle(), PollDetailResponse.getPollPurposeType(), PollDetailResponse.getOptionMediaType(),PollDetailResponse.getPollPrivacyType(),PollDetailResponse.getPollOptionType(),PollDetailResponse.getStartDateTime(),PollDetailResponse.getEndDateTime());
			        	body.setResponseMessage(PollDetailResponse);
			        }
				
				return body.getResponseMessage();
				
				}catch(Exception e){
					block="Poll Detail Service";
		            exp.checkException(e,block);
					body.setResponseError(e.toString());
					return body.getResponseMessage();
			}
		}
}

