package com.bit.myapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.myapp.dao.NoticeMapper;
import com.bit.myapp.domain.Notice;
import com.bit.myapp.domain.SearchCriteria;

@Service("notice")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;

	// 글목록
	public ArrayList<Notice> list() {
		return noticeMapper.list();

	}

//	@Override
//	public List<Notice> list(String searchOption, String keyword) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("searchOption", searchOption);
//		map.put("keyword", keyword);
//		return noticeMapper.list(searchOption, keyword);
//	}
	// 글쓰기
//	@Override
//	public void write(Notice notice) {
//	noticeMapper.write(notice);	
//	}

	public void write(Notice notice) {
		noticeMapper.write(notice);
//		String[] files = notice.getFiles();
//		if (files == null)
//			return;
//		for (String name : files) {
//			noticeMapper.noticeAttach(name);
//		}
	}

	// 글조회

	public Notice contentView(int noticePostNo) {
		return noticeMapper.contentView(noticePostNo);
	}

	// 글삭제
	public void delete(int noticePostNo) {
		noticeMapper.delete(noticePostNo);

	}

	// 글수정
	public void modify(Notice notice) {
		noticeMapper.modify(notice);
	}

	// 조회
	public void noticePostNvUp(int noticePostNo) {
		noticeMapper.noticePostNvUp(noticePostNo);

	}



//	// 파일 업로드
//	public void noticeAttach(String uploadFileName) {
//		noticeMapper.noticeAttach(uploadFileName);
//
//	}
//
//	// 검색된 목록
////	public List<Notice> list(String searchOption, String keyword) {
////		return noticeMapper.list(searchOption, keyword);
////	}
//

	 //게시글 레코드 갯수
//	public int countPost(String searchOption, String keyword) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("searchOption", searchOption);
//		map.put("keyword", keyword);
//		return noticeMapper.countPost(searchOption, keyword);
//	}

	
	public List<Notice> searchList(SearchCriteria cri) throws Exception {
		return noticeMapper.searchList(cri);
	}



}