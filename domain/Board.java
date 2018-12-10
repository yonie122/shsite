package com.bit.myapp.domain;

import java.sql.Date;

public class Board {
	private int postno;
	private String ptagname;
	private String ptitle;
	private String pdetail; 
	private String writer;
	private Date postdate;
	private Date modidate;
	private int postnv;
	private int likecount;
	private String imgpath;
	private String modidate2;
	
	
	
	public String getModidate2() {
		return modidate2;
	}

	public void setModidate2(String modidate2) {
		this.modidate2 = modidate2;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public Board() {}

	public int getPostno() {
		return postno;
	}

	public void setPostno(int postno) {
		this.postno = postno;
	}

	public String getPtagname() {
		return ptagname;
	}

	public void setPtagname(String ptagname) {
		this.ptagname = ptagname;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getPdetail() {
		return pdetail;
	}

	public void setPdetail(String pdetatil) {
		this.pdetail = pdetatil;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	public Date getModidate() {
		return modidate;
	}

	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}

	public int getPostnv() {
		return postnv;
	}

	public void setPostnv(int postnv) {
		this.postnv = postnv;
	}

	public int getLikecount() {
		return likecount;
	}

	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}

	@Override
	public String toString() {
		return "Board [postno=" + postno + ", ptagname=" + ptagname + ", ptitle=" + ptitle + ", pdetatil=" + pdetail
				+ ", writer=" + writer + ", postdate=" + postdate + ", modidate=" + modidate + ", postnv=" + postnv
				+ ", likecount=" + likecount + "]";
	}
	
	
}
