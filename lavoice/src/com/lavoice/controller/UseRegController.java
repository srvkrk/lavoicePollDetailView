package com.lavoice.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lavoice.bean.RegistrationRequest;
import com.lavoice.json.response.RegistrationJsonResponse;
import com.lavoice.service.RegistrationService;

@RestController
public class UseRegController {
	
	@Autowired
	  public RegistrationService userService;
	
	@RequestMapping(
			  value = "/registrationRequest", 
			  headers = "Accept=application/json",
			  method = RequestMethod.POST,
			  produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> getFoosWithHeaders(@RequestBody String jsondata) throws JSONException 
	{
		
		//For web use only
		//jsondata="{ "+jsondata+" }";
		//jsondata = jsondata.replace('&',',');
		String response="";
		System.out.println(jsondata);
		JSONObject jsonObj = null;
	
		try {
			jsonObj = new JSONObject(jsondata);
		    
			RegistrationRequest newUser= new RegistrationRequest(jsonObj.getString("firstname"),
					jsonObj.getString("lastname"),
					jsonObj.getString("email"),
					jsonObj.getString("password"), 
					jsonObj.getString("dob"));
			response=userService.insertUser(newUser);
			
			System.out.println(newUser);
			
			
		} catch (JSONException e) {
			RegistrationJsonResponse errorJosn = new RegistrationJsonResponse();
			errorJosn.setResponseError(e.toString());
			response = errorJosn.getResponseMessage();
		}
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	 @RequestMapping(value = "/verifyEmail", method = RequestMethod.GET)
	  public ModelAndView showLogin(@RequestParam("str") String mailLink) throws JSONException {
		String response = userService.verifyMail(mailLink);
		System.out.println(response);
	    ModelAndView mav = new ModelAndView("WEB-INF/jsp/success.jsp");
	    return mav;
	  }
}


