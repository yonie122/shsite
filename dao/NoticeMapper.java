package com.bit.myapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.bit.myapp.domain.Notice;
import com.bit.myapp.domain.SearchCriteria;

public interface NoticeMapper {
	public void write(Notice notice); // 글쓰기

	public ArrayList<Notice> list(); // 글목록

	public Notice contentView(int noticePostNo); // 글읽기

	public void delete(int noticePostNo); // 글삭제

	public void modify(Notice notice); // 글수정

	public void noticePostNvUp(int noticePostNo); // 조회수

	public List<Notice> searchList(SearchCriteria cri)throws Exception;



	
	
//	public void noticeAttach(String uploadFileName);
//	
//	public List<Notice> list(String searchOption, String keyword);
//
////	
//	public int countPost(String searchOption, String keyword);

}
