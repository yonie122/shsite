package com.bit.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bit.myapp.domain.Board;


public interface AnonyBoardDao {
	/*
	 * 1.글쓰기(anonyinsertBoard)
	 * 2.글읽기(anonyselectBoard)
	 * 3.글수정(anonyModiBoard)//글제목, 내용, 태그만 수정 가능
	 * 4.글삭제(anonydeleteBoard)
	 * 5.글목록(anonygetAllBoard)
	 * 6.조회수증가(anonyPostnvPlus)
	 * 7.좋아요증가(anonyLikePlus)
	 */
	void anonyinsertBoard(Board board);
	Board anonyselectBoard(@Param("postno")int postno);
	void anonyModiBoard(Board board);
	void anonydeleteBoard(@Param("postno")int postno);
	List<Board> anonygetAllBoard();
	void anonyPostnvPlus(@Param("postno")int postno);
	void anonyLikePlus(@Param("postno")int postno);
	
}
