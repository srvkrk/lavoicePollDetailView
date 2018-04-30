package com.lavoice.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavoice.bean.LoggedInSession;
import com.lavoice.bean.LoginRequest;
import com.lavoice.bean.LoginResponse;
import com.lavoice.dao.LoginDao;
import com.lavoice.exception.ExceptionHandeler;
import com.lavoice.json.response.LoginJsonResponse;

@Service("loginService")
public class LoginRequestImpl implements LoginService {
	private static String block;
	@Autowired
	  public ExceptionHandeler exp;
	@Autowired
    private HttpSession session;
	
	@Autowired
    LoginDao loginDao;
	
	public String find(LoginRequest loginRequest) {
		LoginJsonResponse body = new LoginJsonResponse();		
		try{		
			LoginResponse loginResponse = loginDao.find(loginRequest.getUsername());
			
			if(loginResponse==null) {
				body.setResponseError("Invalid Username");
			}
			else {
				/*Start of Password Matching Process*/
				boolean matched = validatePassword(loginRequest.getPassword(), loginResponse.getPassword());
				/*End of Password Matching Process*/
		        if(matched) {
		        	LoggedInSession loggedInSession = new LoggedInSession(loginResponse.getId(), loginResponse.getUsername(),
		        			loginResponse.getFirstname(), loginResponse.getLastname(), loginResponse.getEmailVerified());
		        	session.setAttribute("loggedInSession", loggedInSession);
		        	body.setResponseMessage(loginResponse);
		        }
		        else {
		        	body.setResponseError("Invalid Password");
		        }
			}
			return body.getResponseMessage();
			
			}catch(Exception e){
				block="login Service";
	            exp.checkException(e,block);
				body.setResponseError(e.toString());
				return body.getResponseMessage();
		}
    }
	
	private static boolean validatePassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);
         
        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();
         
        int diff = hash.length ^ testHash.length;
        for(int i = 0; i < hash.length && i < testHash.length; i++)
        {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }
	
    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException
    {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i<bytes.length ;i++)
        {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}
