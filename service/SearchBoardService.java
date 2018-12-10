package com.bit.myapp.service;

import java.util.List;

import com.bit.myapp.domain.Board;

public interface SearchBoardService {
	/*
	 * 1.전체검색(allSearchBoard)
	 */
	List<Board> allSearchBoard(String sTxt);
}
