package com.lavoice.controller;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lavoice.bean.PollDetailRequest;
import com.lavoice.exception.ExceptionHandeler;
import com.lavoice.json.response.PollDetailJsonResponse;
import com.lavoice.json.response.RegistrationJsonResponse;
import com.lavoice.service.PollDetailService;
 
@RestController
public class PollDetailController {
		//private static String block;
		@Autowired
		  public ExceptionHandeler exp;
		@Autowired
		  public PollDetailService polldetailService;
		@Autowired
		  public HttpSession session;
		
		@RequestMapping(value = "/polldetailRequest", headers = "Accept=application/json", method = RequestMethod.POST,
				  produces = "application/json")
		@ResponseBody
		public ResponseEntity<String> getFoosWithHeaders(@RequestBody String jsondata) throws JSONException {
			String response="";
			System.out.println(jsondata);
			JSONObject jsonObj = null;
		
			try {
				jsonObj = new JSONObject(jsondata);
			    
				PollDetailRequest polldetailRequest= new PollDetailRequest(jsonObj.getString("pollId"));
				response=polldetailService.find(pollId).tostring();
				
				System.out.println(response);
				
				
			} catch (JSONException e) {
				PollDetailJsonResponse errorJosn = new PollDetailJsonResponse();
				errorJosn.setResponseError(e.toString());
				response = errorJosn.getResponseMessage();
			}
			
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}

}
