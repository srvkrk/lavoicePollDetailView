package com.lavoice.dao;

import com.lavoice.bean.RegistrationRequest;
import com.lavoice.bean.RegistrationResponse;

public interface RegistrationDao {
	RegistrationResponse insertUser(RegistrationRequest user);
	void verifyUser(String id, String username);
}
