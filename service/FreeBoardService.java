package com.bit.myapp.service;

import java.util.List;

import com.bit.myapp.domain.FreeBoard;

public interface FreeBoardService {

	
	public List <FreeBoard> freeBoardList(int baseNum, int endNum);
	public int postCount();
	public void insertFree(FreeBoard freeBoard);
	public List<FreeBoard> selectFree(int baseNum);
	public void deleteFree(int baseNum);
	public void updateFree(int baseNum, String ptagName, String ptitle, String detail);
	public void freePlus(int baseNum);
}
