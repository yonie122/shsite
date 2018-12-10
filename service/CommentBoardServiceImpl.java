package com.bit.myapp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.myapp.dao.CommentBoardDao;
import com.bit.myapp.domain.postComment;

@Service("commentService")
public class CommentBoardServiceImpl implements CommentBoardService{


	@Autowired
	CommentBoardDao cService;

	@Override
	public List<postComment> getAllComments(int postno) {
		// TODO Auto-generated method stub
		return cService.getAllComments(postno);
	}

	@Override
	public void insertComment(postComment pComnet) {
		// TODO Auto-generated method stub
		cService.insertComment(pComnet);
	}

	@Override
	public void deleteComment(HashMap<String, Integer> dNumData) {
		// TODO Auto-generated method stub
		cService.deleteComment(dNumData);
	}


	


	
	

}