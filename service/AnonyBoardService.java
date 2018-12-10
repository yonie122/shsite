package com.bit.myapp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bit.myapp.domain.Board;

public interface AnonyBoardService {
	//필요한 기능
	/*
	 * 1.글목록 읽어오기: getAll
	 */
	void anonyinsertBoard(Board board);
	Board anonyselectBoard(@Param("postno")int postno);
	void anonyModiBoard(Board board);
	void anonydeleteBoard(@Param("postno")int postno);
	List<Board> anonygetAllBoard();
	void anonyPostnvPlus(@Param("postno")int postno);
	void anonyLikePlus(@Param("postno")int postno);
}
