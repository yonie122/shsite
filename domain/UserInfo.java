package com.bit.myapp.domain;

import java.sql.Date;

public class UserInfo {
		
	private String userid;
	private String userpw;
	private String uname;
	private String nickname;
	private String uemail;
	private Date joindate;
	
	
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public UserInfo(String userid, String userpw, String uname, String nickname, String uemail,Date joindate) {
	
		this.userid = userid;
		this.userpw = userpw;
		this.uname = uname;
		this.nickname = nickname;
		this.uemail = uemail;
		this.joindate = joindate;
	}
	public UserInfo() {
		
	}

	
	
	

}
