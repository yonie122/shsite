package com.bit.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bit.myapp.domain.FreeBoard;


public interface FreeBoardMapper {
 
	
	

	
	public List<FreeBoard> freeBoardList(@Param("baseNum") int  baseNum, @Param("endNum") int endNum);
	public int postCount();
	public void insertFree(FreeBoard freeBoard);
	public List<FreeBoard> selectFree(@Param("baseNum") int baseNum);
	public void deleteFree(@Param("baseNum") int baseNum);
	
	public void updateFree(@Param("baseNum") int baseNum, @Param("ptagName") String ptagName, @Param("ptitle") String ptitle, @Param("pdetail") String detail /*@,Param("writer") String writer*/); 
//	public void updateFree(@Param("baseNum") int baseNum, @Param("ptagName") String ptagName);
	
	public void freePlus(@Param("baseNum")int baseNum);
	
/*	public void updateFree(FreeBoard freeboard); */
	
	
	
}
