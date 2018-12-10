package com.bit.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.myapp.dao.UserDAO;
import com.bit.myapp.domain.UserInfo;

@Service("userService")
public class UserServiceImpl implements UserService {


@Autowired
private UserDAO userdao;

@Override
public List<UserInfo> selectUser(String userid) throws Exception {
	// TODO Auto-generated method stub
	return userdao.selectUser(userid);
}

@Override
public void insertUser(UserInfo userinfo) throws Exception {
	// TODO Auto-generated method stub
	
	userdao.insertUser(userinfo);
	
}



@Override
public UserInfo login(UserInfo userinfo) throws Exception {
	// TODO Auto-generated method stub
	return userdao.login(userinfo);
}


}
