package com.bit.myapp.domain;

public class postComment {
	private int commentno;
	private String cuser;
	private String cdetail;
	private String cdate;
	private int likecount;
	private int postno;
	
	
	
	public int getCommentno() {
		return commentno;
	}
	public void setCommentno(int commentno) {
		this.commentno = commentno;
	}
	public String getCuser() {
		return cuser;
	}
	public void setCuser(String cuser) {
		this.cuser = cuser;
	}
	public String getCdetail() {
		return cdetail;
	}
	public void setCdetail(String cdetail) {
		this.cdetail = cdetail;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}
	public int getPostno() {
		return postno;
	}
	public void setPostno(int postno) {
		this.postno = postno;
	}
	@Override
	public String toString() {
		return "postComment [commentno=" + commentno + ", cuser=" + cuser + ", cdetail=" + cdetail + ", cdate=" + cdate
				+ ", likecount=" + likecount + ", postno=" + postno + "]";
	}
	

	
	
	
	
	
}
