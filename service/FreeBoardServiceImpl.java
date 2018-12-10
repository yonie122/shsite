package com.bit.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.myapp.dao.FreeBoardMapper;
import com.bit.myapp.domain.FreeBoard;

@Service("freeService")
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardMapper freemapper;
	
	@Override
	public List<FreeBoard> freeBoardList(int baseNum, int endNum) {
		
		return freemapper.freeBoardList(baseNum, endNum);
		
	}

	@Override
	public int postCount() {
		
		return freemapper.postCount();
	}

	@Override
	public void insertFree(FreeBoard freeBoard) {
		freemapper.insertFree(freeBoard);
		
	}

	@Override
	public List<FreeBoard> selectFree(int baseNum) {
		
		return freemapper.selectFree(baseNum);
	}

	@Override
	public void deleteFree(int baseNum) {
		freemapper.deleteFree(baseNum);
		
	}

	@Override
	public void updateFree(int baseNum, String ptagName, String ptitle, String detail) {
		freemapper.updateFree(baseNum, ptagName, ptitle, detail);
		
	}

	@Override
	public void freePlus(int baseNum) {
		freemapper.freePlus(baseNum);
	}

	
	
	
}
