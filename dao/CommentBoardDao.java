package com.bit.myapp.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bit.myapp.domain.postComment;


public interface CommentBoardDao {
	/*
	 * 1.댓글가져오기(getAllComments)
	 * 2.댓글 입력(insertComment)
	 * 3.댓글 삭제(deleteComment)
	 */
	List<postComment> getAllComments(@Param("postno")int postno);
	void insertComment(postComment pComment);
	void deleteComment(HashMap<String, Integer> dNumData);
}
