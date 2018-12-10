package com.bit.myapp.service;

import java.util.List;

import com.bit.myapp.domain.UserInfo;

public interface UserService {
	public List<UserInfo> selectUser(String userid) throws Exception;
	public void insertUser(UserInfo userinfo) throws Exception;
	public UserInfo login(UserInfo userinfo) throws Exception;
}
