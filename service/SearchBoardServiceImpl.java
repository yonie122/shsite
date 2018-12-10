package com.bit.myapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.myapp.dao.AnonyBoardDao;
import com.bit.myapp.dao.SearchBoardDao;
import com.bit.myapp.domain.Board;

@Service("searchService")
public class SearchBoardServiceImpl implements SearchBoardService{


	@Autowired
	AnonyBoardDao aservice;
	
	@Autowired
	SearchBoardDao searchSerivce;

	@Override
	public List<Board> allSearchBoard(String sTxt) {
		// TODO Auto-generated method stub
		return searchSerivce.allSearchBoard(sTxt);
	}

	
	

}