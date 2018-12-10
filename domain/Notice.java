package com.bit.myapp.domain;

import java.sql.Date;
import java.util.Arrays;

public class Notice {

	private int noticePostNo;
	private String noticePtagName;
	private String noticeTitle;
	private String noticePdetail;
	private String noticePostWriter;
	private Date noticePostDate;
	private Date noticeModiDate;
	private int noticePostNv;
	private int noticePostLike;
	
//	private String[] files;
//	
//	
//	public String[] getFiles() {
//		return files;
//	}
//
//
//	public void setFiles(String[] files) {
//		this.files = files;
//	}


	public Notice() {}


	public Notice(int noticePostNo, String noticePtagName, String noticeTitle, String noticePdetail,
			String noticePostWriter, Date noticePostDate, Date noticeModiDate, int noticePostNv, int noticePostLike) {
		super();
		this.noticePostNo = noticePostNo;
		this.noticePtagName = noticePtagName;
		this.noticeTitle = noticeTitle;
		this.noticePdetail = noticePdetail;
		this.noticePostWriter = noticePostWriter;
		this.noticePostDate = noticePostDate;
		this.noticeModiDate = noticeModiDate;
		this.noticePostNv = noticePostNv;
		this.noticePostLike = noticePostLike;
	}


	public int getNoticePostNo() {
		return noticePostNo;
	}


	public void setNoticePostNo(int noticePostNo) {
		this.noticePostNo = noticePostNo;
	}


	public String getNoticePtagName() {
		return noticePtagName;
	}


	public void setNoticePtagName(String noticePtagName) {
		this.noticePtagName = noticePtagName;
	}


	public String getNoticeTitle() {
		return noticeTitle;
	}


	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}


	public String getNoticePdetail() {
		return noticePdetail;
	}


	public void setNoticePdetail(String noticePdetail) {
		this.noticePdetail = noticePdetail;
	}


	public String getNoticePostWriter() {
		return noticePostWriter;
	}


	public void setNoticePostWriter(String noticePostWriter) {
		this.noticePostWriter = noticePostWriter;
	}


	public Date getNoticePostDate() {
		return noticePostDate;
	}


	public void setNoticePostDate(Date noticePostDate) {
		this.noticePostDate = noticePostDate;
	}


	public Date getNoticeModiDate() {
		return noticeModiDate;
	}


	public void setNoticeModiDate(Date noticeModiDate) {
		this.noticeModiDate = noticeModiDate;
	}


	public int getNoticePostNv() {
		return noticePostNv;
	}


	public void setNoticePostNv(int noticePostNv) {
		this.noticePostNv = noticePostNv;
	}


	public int getNoticePostLike() {
		return noticePostLike;
	}


	public void setNoticePostLike(int noticePostLike) {
		this.noticePostLike = noticePostLike;
	}


	@Override
	public String toString() {
		return "Notice [noticePostNo=" + noticePostNo + ", noticePtagName=" + noticePtagName + ", noticeTitle="
				+ noticeTitle + ", noticePdetail=" + noticePdetail + ", noticePostWriter=" + noticePostWriter
				+ ", noticePostDate=" + noticePostDate + ", noticeModiDate=" + noticeModiDate + ", noticePostNv="
				+ noticePostNv + ", noticePostLike=" + noticePostLike + ", files= ]";
	}




}
