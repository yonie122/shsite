package com.bit.myapp.dao;

import java.util.List;

import com.bit.myapp.domain.UserInfo;

public interface UserDAO {
	
	public List<UserInfo> selectUser(String userid) throws Exception;
	public void insertUser(UserInfo userinfo) throws Exception;
	
	public UserInfo login(UserInfo userinfo) throws Exception;
	
	

}
