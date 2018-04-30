package com.lavoice.dao;

import com.lavoice.bean.LoginResponse;

public interface LoginDao {
	LoginResponse find(String username) ;
}
