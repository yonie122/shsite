package com.bit.myapp.dao;

import java.util.List;

import com.bit.myapp.domain.Board;


public interface SearchBoardDao {
	/*
	 * 1.전체검색(allSearchBoard)

	 */
	List<Board> allSearchBoard(String sTxt);

}
