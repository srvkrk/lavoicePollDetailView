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

import com.lavoice.bean.LoggedInSession;
import com.lavoice.bean.LoginRequest;
import com.lavoice.exception.ExceptionHandeler;
import com.lavoice.json.response.LoginJsonResponse;
import com.lavoice.service.LoginService;

@RestController
public class LoginController {
	private static String block;
	@Autowired
	  public ExceptionHandeler exp;
	@Autowired
	  public LoginService loginService;
	@Autowired
	  public HttpSession session;
	
	@RequestMapping(value = "/loginRequest", headers = "Accept=application/json", method = RequestMethod.POST,
			  produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> getFoosWithHeaders(@RequestBody String jsondata) throws JSONException {
		
		//For web use only
		//jsondata="{ "+jsondata+" }";
		//jsondata = jsondata.replace('&',',');
		
		String response = "";
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject(jsondata);
			LoginRequest loginRequest= new LoginRequest(jsonObj.getString("username"), jsonObj.getString("password"));
			response = loginService.find(loginRequest);
			
			LoggedInSession loggedInSession = (LoggedInSession) session.getAttribute("loggedInSession");
	        System.out.println(loggedInSession);
			
		} catch (JSONException e) {
			LoginJsonResponse errorJosn = new LoginJsonResponse();
			errorJosn.setResponseError(e.toString());
			response = errorJosn.getResponseMessage();
			block="login controller block";
	        exp.checkException(e,block);
		}
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/homeRequest", headers = "Accept=application/json", method = RequestMethod.POST,
			  produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> getHome(@RequestBody String jsondata) {
			
		LoggedInSession loggedInSession = (LoggedInSession) session.getAttribute("loggedInSession");
	    System.out.println(loggedInSession);
	    
	    LoginJsonResponse errorJosn = new LoginJsonResponse();
	    if(loggedInSession!=null) {
	    	errorJosn.setResponseError(loggedInSession.toString());
	    }
	    else {
	    	errorJosn.setResponseError("No Session");
	    }
		
		return new ResponseEntity<String>(errorJosn.getResponseMessage(), HttpStatus.OK);
	}
}
