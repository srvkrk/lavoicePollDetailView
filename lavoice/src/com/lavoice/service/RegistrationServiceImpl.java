package com.lavoice.service;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.lavoice.json.response.RegistrationJsonResponse;
import com.lavoice.bean.LoginResponse;
import com.lavoice.bean.RegistrationRequest;
import com.lavoice.bean.RegistrationResponse;
import com.lavoice.dao.LoginDao;
import com.lavoice.dao.RegistrationDao;
import com.lavoice.exception.ExceptionHandeler;

@Service("regService")
public class RegistrationServiceImpl implements RegistrationService {

	
	private static String block;
	@Autowired
	  public ExceptionHandeler exp;
	
	 @Autowired
	 RegistrationDao userDao;
	 @Autowired
	 LoginDao loginDao;
	 @Autowired
	 public JavaMailSender emailSender;
	 @Autowired
	 public SimpleMailMessage template;
	 
	 public String insertUser(RegistrationRequest user) {
		 RegistrationJsonResponse body = new RegistrationJsonResponse();	
		 try {
			 LoginResponse loginResponse = loginDao.find(user.getUsername());
			 if(loginResponse==null) {
			 /*Start of password Encryption*/
			 String  password = user.getPassword();
			 
			 int iterations = getRandomInteger(9999, 99999);
		     char[] chars = password.toCharArray();
		     byte[] salt = getSalt();
		         
		     PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
		     SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		     byte[] hash = skf.generateSecret(spec).getEncoded();
		        
		     String generatedSecuredPasswordHash = iterations + ":" + toHex(salt) + ":" + toHex(hash);
		     user.setPassword(generatedSecuredPasswordHash);
			 /*End of password Encryption*/
			 
			 RegistrationResponse userBack = userDao.insertUser(user);
			 
			 String mailSubject ="Verify E-mail Address (LAVOICE)";
			 String customer_name=userBack.getFirstname()+" "+userBack.getLastname();
			 String verify_mailLink="{" +
					 "\"id\":\"" + userBack.getId() + '\"' +
					 ",\"username\":\"" + userBack.getUsername() + '\"' +
			 		 "}";
			 String encodedString = Base64.getEncoder().encodeToString(verify_mailLink.getBytes());	
			 sendSimpleMessageUsingTemplate(userBack.getUsername(), mailSubject, template, customer_name, encodedString);
			 body.setResponseMessage(userBack);
			 return body.getResponseMessage();
			 }
			 else {
				 body.setResponseError("Account Already Exists");
				 return body.getResponseMessage();
			 }
			 
		 }catch(Exception e){
			 block="reg Service";
	            exp.checkException(e,block);
			 body.setResponseError(e.toString());
			 return body.getResponseMessage();	 
		 }
		 
	 }
	 
	 public String verifyMail(String mailLink) {
		 
		 String response="";
		 byte[] decodedBytes = Base64.getDecoder().decode(mailLink);
		 String decodedString = new String(decodedBytes);
		 System.out.println(decodedString);
		 try {
			JSONObject jsonObj = new JSONObject(decodedString);
			userDao.verifyUser(jsonObj.getString("id"), jsonObj.getString("username"));
			response="Success";
		 } catch (JSONException e) {
			 block="reg Service mail verify";
	            exp.checkException(e,block);
			response=e.toString();
		 }
		 return response;
	 }
	 
	 private static int getRandomInteger(int maximum, int minimum){ 
		 return ((int) (Math.random()*(maximum - minimum))) + minimum; 
		 }

	 private void sendSimpleMessageUsingTemplate(String to,
             String subject,
             SimpleMailMessage template,
             String customer_name, String verify_mailLink) {

		 System.out.println( "From Service SimpleMessageUsingTemplate are set");
		 try {
			 Map<String, String> valuesMap = new HashMap<String, String>();
			 valuesMap.put("customer_name", customer_name);
			 valuesMap.put("verify_mailLink", verify_mailLink);
			 StrSubstitutor sub = new StrSubstitutor(valuesMap);
			 String text = sub.replace(template.getText());
			 MimeMessage message = emailSender.createMimeMessage();
			 message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			 message.setSubject(subject);
			 message.setContent(text,"text/html");
			 emailSender.send(message);
			 
		 } catch (MessagingException e) {
			 e.printStackTrace();
		 }
	 }
	 
	 private static byte[] getSalt() throws NoSuchAlgorithmException
	    {
	        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
	        byte[] salt = new byte[16];
	        sr.nextBytes(salt);
	        return salt;
	    }
	     
	    private static String toHex(byte[] array) throws NoSuchAlgorithmException
	    {
	        BigInteger bi = new BigInteger(1, array);
	        String hex = bi.toString(16);
	        int paddingLength = (array.length * 2) - hex.length();
	        if(paddingLength > 0)
	        {
	            return String.format("%0"  +paddingLength + "d", 0) + hex;
	        }else{
	            return hex;
	        }
	    }
	 
}
