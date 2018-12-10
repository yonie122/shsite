package com.bit.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.myapp.dao.AnonyBoardDao;
import com.bit.myapp.domain.Board;

@Service("anonyService")
public class AnonyBoardServiceImpl implements AnonyBoardService{


	@Autowired
	AnonyBoardDao aservice;

	@Override
	public void anonyinsertBoard(Board board) {
		aservice.anonyinsertBoard(board);
		
	}
	
	@Override
	public Board anonyselectBoard(int postno) {
		return aservice.anonyselectBoard(postno);
	}

	@Override
	public void anonyModiBoard(Board board) {
		
		aservice.anonyModiBoard(board);
	}

	@Override
	public void anonydeleteBoard(int postno) {
		aservice.anonydeleteBoard(postno);
	}

	@Override
	public List<Board> anonygetAllBoard() {	
		return aservice.anonygetAllBoard();
	}
	
	public void anonyPostnvPlus(int postno) {
		aservice.anonyPostnvPlus(postno);
	}
	@Override
	public void anonyLikePlus(int postno) {
		aservice.anonyLikePlus(postno);
		
	}
	

}