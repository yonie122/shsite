package com.bit.myapp.service;

import java.util.HashMap;
import java.util.List;

import com.bit.myapp.domain.postComment;

public interface CommentBoardService {
	/*
	 * 1.댓글가져오기(getAllComments)
	 * 2.댓글 입력(insertComment)
	 * 3.댓글 삭제(deleteComment)
	 */
	List<postComment> getAllComments(int postno);
	void insertComment(postComment pComnet);
	void deleteComment(HashMap<String, Integer> dNumData);
}
